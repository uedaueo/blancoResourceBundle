/*
 * blanco Framework
 * Copyright (C) 2004-2007 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.resourcebundle;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blanco.commons.io.Native2AsciiWriter;
import blanco.commons.util.BlancoFileUtil;
import blanco.commons.util.BlancoStringUtil;
import blanco.resourcebundle.resourcebundle.BlancoResourceBundleResourceBundle;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;

/**
 * 中間XMLファイルから プロパティファイルを生成します。
 * 
 * このソースコードはblancoResourceBundleの一部です。<br>
 * XMLを入力してプロパティファイルに出力を行います。<br>
 * プロパティファイル仕様として参照した情報源は下記のPropertiesクラス説明です。<br>
 * http://java.sun.com/j2se/1.5.0/docs/api/java/util/Properties.html#store(java.
 * io.OutputStream,%20java.lang.String)
 * 
 * @author IGA Tosiki
 */
public class BlancoResourceBundleXml2Properties {
    /**
     * コマンドラインに出力する際のプレフィックス。
     */
    private static final String CMDLINE_PREFIX = "rb: ";

    /**
     * リソースバンドルアクセサのインスタンス。
     */
    private BlancoResourceBundleResourceBundle fBundle = new BlancoResourceBundleResourceBundle();

    /**
     * タイムスタンプをプロパティファイルのコメントに出力するかどうか。
     */
    private boolean fCommentTimestamp = true;

    /**
     * プロパティファイルをディレクトリ付きで出力するかどうか。
     */
    private boolean fPropertieswithdirectory = true;

    /**
     * プロパティファイルにコメントとして処理日次を埋め込むかどうかのフラグをセットします。
     * 
     * @param isCommentTimestamp
     *            処理日次を埋め込むかどうか。trueなら埋め込み。
     */
    public void setCommentTimestamp(final boolean isCommentTimestamp) {
        fCommentTimestamp = isCommentTimestamp;
    }

    /**
     * プロパティファイルをディレクトリ付きで出力するかどうかのフラグをセットします。
     * 
     * @param isPropertieswithdirectory
     *            プロパティファイルをディレクトリ付きで出力するかどうか。
     */
    public void setPropertieswithdirectory(
            final boolean isPropertieswithdirectory) {
        fPropertieswithdirectory = isPropertieswithdirectory;
    }

    /**
     * 中間XMLファイルから プロパティファイルを生成します。
     * 
     * @param fileSource
     *            中間XMLファイル。
     * @param directoryTarget
     *            出力先ディレクトリ。
     */
    public void process(final File fileSource, final File directoryTarget) {
        if (directoryTarget.exists() == false) {
            // ディレクトリが無いので新規作成します。
            directoryTarget.mkdirs();
        }

        final Map<java.lang.String, java.lang.String> mapProcessedBaseName = new HashMap<java.lang.String, java.lang.String>(
                64);
        final BlancoResourceBundleBundleStructure[] structures = new BlancoResourceBundleXmlParser()
                .parse(fileSource);
        for (int index = 0; index < structures.length; index++) {
            if (mapProcessedBaseName.get(structures[index].getName()) == null) {
                // System.out.println("基底名[" + baseName + "]
                // が初めて登場しました。ロケール["
                // + locale + "]はロケールが指定されていない場合のリソースとしても利用されます。");
                structure2Properties(structures[index], null, directoryTarget);
                mapProcessedBaseName.put(structures[index].getName(),
                        structures[index].getCurrentLocale());
            }
            structure2Properties(structures[index], structures[index]
                    .getCurrentLocale(), directoryTarget);
        }
    }

    /**
     * プロパティファイルを展開します。
     * 
     * @param resourceBase
     *            構造。
     * @param locale
     *            ロケール。
     * @param directoryTarget
     *            出力先ディレクトリ。
     */
    public void structure2Properties(
            final BlancoResourceBundleBundleStructure resourceBase,
            final String locale, final File directoryTarget) {
        final String resourceDefinitionId = resourceBase.getName();

        String subDirectory = "";
        if (fPropertieswithdirectory) {
            subDirectory = "/"
                    + BlancoStringUtil.replace(resourceBase.getPackage(), ".",
                            "/", true);
        }

        // ファイル名を確定します。
        String fileName = null;
        if (locale == null) {
            fileName = directoryTarget.getAbsolutePath() + subDirectory + "/"
                    + resourceDefinitionId + ".properties";
        } else {
            fileName = directoryTarget.getAbsolutePath() + subDirectory + "/"
                    + resourceDefinitionId + "_" + locale + ".properties";
        }

        final File fileTarget = new File(fileName);

        {
            // 出力先ディレクトリの存在チェック
            final File dirParent = fileTarget.getAbsoluteFile().getParentFile();
            if (dirParent.exists() == false) {
                // 無ければ作成。
                dirParent.mkdirs();
            }
        }

        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        Native2AsciiWriter writer = null;
        try {

            // プロパティファイルは 8859_1でエンコードされています。
            writer = new Native2AsciiWriter(new BufferedWriter(
                    new OutputStreamWriter(outStream, "8859_1")));

            writer
                    .writeComment(" blancoResourceBundle properties file for locale ["
                            + (locale == null ? "default" : locale) + "]");

            if (fCommentTimestamp) {
                writer.writeComment(" generated at "
                        + DateFormat.getDateInstance().format(new Date()) + " "
                        + DateFormat.getTimeInstance().format(new Date()));
            }

            final List<BlancoResourceBundleBundleItemStructure> listResource = resourceBase
                    .getItemList();
            // 一つも指定が無い場合であっても、ファイルは生成します。

            final int sizeListRow = listResource.size();
            for (int indexField = 0; indexField < sizeListRow; indexField++) {
                final BlancoResourceBundleBundleItemStructure elementResource = listResource
                        .get(indexField);

                final String fieldResourceId = elementResource.getKey();
                String fieldResourceString = null;
                if (elementResource.getResourceStringList().size() > 0) {
                    fieldResourceString = elementResource
                            .getResourceStringList().get(0).getResourceString();
                }

                if (BlancoStringUtil.null2Blank(fieldResourceId).length() == 0) {
                    // リソースIDがnullの場合は プロパティではありません。
                    if (fieldResourceString != null) {
                        // リソースIDがnullなのだけれども文字列が指定されている場合には
                        // コメントとして扱います。
                        writer.writeComment(fieldResourceString);
                    }
                } else {
                    writer.writeProperty(fBundle.getKeyPrefix()
                            + fieldResourceId,
                            (fieldResourceString == null ? ""
                                    : fieldResourceString));
                }
            }
            writer.flush();
            outStream.flush();

            // 必要がある場合にのみファイルの作成や更新を行います。
            switch (BlancoFileUtil.bytes2FileIfNecessary(outStream
                    .toByteArray(), fileTarget)) {
            case 0:
                // System.out.println(CMDLINE_PREFIX + "skip : "
                // + fileTarget.getAbsolutePath());
                break;
            case 1:
                System.out.println(CMDLINE_PREFIX + "create: "
                        + fileTarget.getAbsolutePath());
                break;
            case 2:
                System.out.println(CMDLINE_PREFIX + "update: "
                        + fileTarget.getAbsolutePath());
                break;
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("プロパティファイル[" + fileName
                    + "]の出力時に入出力例外が発生しました。" + e.toString());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}