/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.resourcebundle.task;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.apache.tools.ant.BuildException;

import blanco.constants.BlancoConstantsXml2JavaClass;
import blanco.resourcebundle.BlancoResourceBundleConstants;
import blanco.resourcebundle.BlancoResourceBundleMeta2Xml;
import blanco.resourcebundle.BlancoResourceBundleXml2CombinedXml;
import blanco.resourcebundle.BlancoResourceBundleXml2ConstantsXml;
import blanco.resourcebundle.BlancoResourceBundleXml2JavaClass;
import blanco.resourcebundle.BlancoResourceBundleXml2Properties;
import blanco.resourcebundle.BlancoResourceBundleXmlValidator;
import blanco.resourcebundle.message.BlancoResourceBundleMessage;
import blanco.resourcebundle.resourcebundle.BlancoResourceBundleResourceBundle;
import blanco.resourcebundle.task.valueobject.BlancoResourceBundleProcessInput;

public class BlancoResourceBundleProcessImpl implements
        BlancoResourceBundleProcess {
    /**
     * メッセージ。
     */
    private final BlancoResourceBundleMessage fMsg = new BlancoResourceBundleMessage();

    /**
     * リソースバンドルアクセサのインスタンス。
     */
    private final BlancoResourceBundleResourceBundle fBundle = new BlancoResourceBundleResourceBundle();

    /**
     * {@inheritDoc}
     */
    public int execute(BlancoResourceBundleProcessInput input)
            throws IOException, IllegalArgumentException {
        System.out.println("- " + BlancoResourceBundleConstants.PRODUCT_NAME
                + " (" + BlancoResourceBundleConstants.VERSION + ")");

        try {
            /*
             * 改行コードを決定します。
             */
            String LF = "\n";
            String CR = "\r";
            String CRLF = CR + LF;
            String lineSeparatorMark = input.getLineSeparator();
            String lineSeparator = "";
            if ("LF".equals(lineSeparatorMark)) {
                lineSeparator = LF;
            } else if ("CR".equals(lineSeparatorMark)) {
                lineSeparator = CR;
            } else if ("CRLF".equals(lineSeparatorMark)) {
                lineSeparator = CRLF;
            }
            if (lineSeparator.length() != 0) {
                System.setProperty("line.separator", lineSeparator);
                if (input.getVerbose()) {
                    System.out.println("lineSeparator try to change to " + lineSeparatorMark);
                    String newProp = System.getProperty("line.separator");
                    String newMark = "other";
                    if (LF.equals(newProp)) {
                        newMark = "LF";
                    } else if (CR.equals(newProp)) {
                        newMark = "CR";
                    } else if (CRLF.equals(newProp)) {
                        newMark = "CRLF";
                    }
                    System.out.println("New System Props = " + newMark);
                }
            }

            /*
             * targetdir, targetStyleの処理。
             * 生成されたコードの保管場所を設定する。
             * targetstyle = blanco:
             *  targetdirの下に main ディレクトリを作成
             * targetstyle = maven:
             *  targetdirの下に main/java ディレクトリを作成
             * targetstyle = free:
             *  targetdirをそのまま使用してディレクトリを作成。
             *  ただしtargetdirがからの場合はデフォルト文字列(blanco)使用する。
             * by tueda, 2019/08/30
             */
            String strTarget = input.getTargetdir();
            String style = input.getTargetStyle();
            // ここを通ったら常にtrue
            boolean isTargetStyleAdvanced = true;
            if (style != null && BlancoResourceBundleConstants.TARGET_STYLE_MAVEN.equals(style)) {
                strTarget = strTarget + "/" + BlancoResourceBundleConstants.TARGET_DIR_SUFFIX_MAVEN;
            } else if (style == null ||
                    !BlancoResourceBundleConstants.TARGET_STYLE_FREE.equals(style)) {
                strTarget = strTarget + "/" + BlancoResourceBundleConstants.TARGET_DIR_SUFFIX_BLANCO;
            }
            /* style が free だったらtargetdirをそのまま使う */
            if (input.getVerbose()) {
                System.out.println("TARGETDIR = " + strTarget);
            }

            final File blancoTmpResourceBundleDirectory = new File(input
                    .getTmpdir()
                    + BlancoResourceBundleConstants.TARGET_SUBDIRECTORY);
            blancoTmpResourceBundleDirectory.mkdirs();

            final File fileMetadir = new File(input.getMetadir());
            if (fileMetadir.exists() == false) {
                throw new BuildException(fMsg.getMbrba001(input.getMetadir()));
            }

            // xlsファイルをxmlファイルへと変換します。
            new BlancoResourceBundleMeta2Xml().processDirectory(fileMetadir,
                    blancoTmpResourceBundleDirectory.getAbsolutePath());

            // テンポラリフォルダ内のXMLファイルを組み替えて combinedxmlファイルを生成します。
            final File[] fileMeta = blancoTmpResourceBundleDirectory
                    .listFiles();
            for (int index = 0; index < fileMeta.length; index++) {
                if (fileMeta[index].getName().endsWith(".xml") == false) {
                    continue;
                }

                final File fileTmpTargetCombine = new File(
                        blancoTmpResourceBundleDirectory + "/"
                                + fileMeta[index].getName() + ".combinedxml");
                // 生成したXMLファイルの組み替えを行います。
                new BlancoResourceBundleXml2CombinedXml().process(
                        fileMeta[index], fileTmpTargetCombine);
            }

            final File[] fileTmp = blancoTmpResourceBundleDirectory.listFiles();
            for (int index = 0; index < fileTmp.length; index++) {
                if (fileTmp[index].getName().endsWith(".combinedxml")) {
                    final BlancoResourceBundleXmlValidator xmlValidator = new BlancoResourceBundleXmlValidator();
                    xmlValidator.setFailOnMessageFormatError(input
                            .getFailonmessageformaterror());
                    xmlValidator.setTargetStyleAdvanced(isTargetStyleAdvanced);
                    xmlValidator.process(fileTmp[index], new File(strTarget));

                    if ("true".equals(fBundle.getGenerateBundleSource())) {
                        final BlancoResourceBundleXml2JavaClass xml2javaclass = new BlancoResourceBundleXml2JavaClass();
                        xml2javaclass.setEncoding(input.getEncoding());
                        // リソースバンドルアクセサのソースコードを生成するかどうかフラグをセット。
                        // MessageFormatパース時にエラーが発生した場合に処理中断するかどうかフラグをセット。
                        xml2javaclass.setFailOnMessageFormatError(input
                                .getFailonmessageformaterror());

                        // ログ出力をソースコードに自動生成するかどうかを設定します。
                        xml2javaclass.setLog(input.getLog());

                        // ディレクトリ付きでプロパティファイルを出力するかどうか。
                        xml2javaclass.setPropertieswithdirectory(input.getPropertieswithdirectory());
                        xml2javaclass.setTargetStyleAdvanced(isTargetStyleAdvanced);

                        // 実際のソースコード生成処理を実行。
                        xml2javaclass.process(fileTmp[index], new File(strTarget));
                    }

                    if ("true".equals(fBundle.getGenerateConstantsSource())) {
                        // 定数クラスの生成モードがONです。
                        // リソースバンドル中間XMLファイルを入力に、定数クラスの中間XMLファイルを生成します。
                        new BlancoResourceBundleXml2ConstantsXml().process(
                                fileTmp[index],
                                blancoTmpResourceBundleDirectory);
                    }
                } else if (fileTmp[index].getName().endsWith(".xml")) {
                    final BlancoResourceBundleXml2Properties xml2properties = new BlancoResourceBundleXml2Properties();
                    xml2properties.setCommentTimestamp(input
                            .getCommenttimestamp());

                    // ディレクトリ付きでプロパティファイルを出力するかどうか。
                    xml2properties.setPropertieswithdirectory(input.getPropertieswithdirectory());
                    xml2properties.setTargetStyleAdvanced(isTargetStyleAdvanced);

                    xml2properties.process(fileTmp[index], new File(strTarget));
                }
            }

            if ("true".equals(fBundle.getGenerateConstantsSource())) {
                // 定数クラスの生成モードがONです。
                // 定数クラスの中間XMLファイルから、定数クラスを生成します。
                final File[] fileTmpConstants = new File(
                        blancoTmpResourceBundleDirectory.getAbsolutePath()
                                + "/constants").listFiles();
                for (int index = 0; index < fileTmpConstants.length; index++) {
                    if (fileTmpConstants[index].getName().endsWith(
                            ".constantsxml")) {
                        BlancoConstantsXml2JavaClass blancoConstatns = new BlancoConstantsXml2JavaClass();
                        blancoConstatns.setEncoding(input.getEncoding());
                        blancoConstatns.setTargetStyleAdvanced(isTargetStyleAdvanced);
                        blancoConstatns.process(
                                fileTmpConstants[index], new File(strTarget));
                    }
                }
            }



            return BlancoResourceBundleBatchProcess.END_SUCCESS;
        } catch (TransformerException ex) {
            ex.printStackTrace();
            throw new IOException("XML変換の過程で例外が発生しました: " + ex.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean progress(final String argProgressMessage) {
        System.out.println(argProgressMessage);
        return false;
    }
}
