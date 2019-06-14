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

import java.io.File;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import blanco.commons.util.BlancoJavaSourceUtil;
import blanco.commons.util.BlancoStringUtil;
import blanco.commons.util.BlancoXmlUtil;
import blanco.resourcebundle.message.BlancoResourceBundleMessage;
import blanco.resourcebundle.resourcebundle.BlancoResourceBundleResourceBundle;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;

/**
 * 集約後の中間XMLファイルの内容妥当性チェックを行います。
 * 
 * このソースコードはblancoResourceBundleの一部です。<br>
 * 
 * @author IGA Tosiki
 */
public class BlancoResourceBundleXmlValidator {
    /**
     * メッセージ。
     */
    private final BlancoResourceBundleMessage fMsg = new BlancoResourceBundleMessage();

    /**
     * リソースバンドルアクセサのインスタンス。
     */
    private final BlancoResourceBundleResourceBundle fBundle = new BlancoResourceBundleResourceBundle();

    /**
     * リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグ。
     * 
     * trueなら処理中断して例外を発生させます。<br>
     * falseなら処理続行し、置換文字列は無いものとみなします。<br>
     * Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。<br>
     * デフォルト値[true]が設定されています。
     */
    private boolean fIsFailOnMessageFormatError = true;

    /**
     * リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグを設定します。
     * 
     * trueなら処理中断して例外を発生させます。<br>
     * falseなら処理続行し、置換文字列は無いものとみなします。<br>
     * Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。<br>
     * デフォルト値[true]が設定されています。
     * 
     * @param argIsFailOnMessageFormatError
     */
    public void setFailOnMessageFormatError(
            final boolean argIsFailOnMessageFormatError) {
        fIsFailOnMessageFormatError = argIsFailOnMessageFormatError;
    }

    /**
     * 中間XMLファイルから プロパティファイルアクセス用のJavaソースコードを生成します。
     * 
     * @param argFileSource
     *            入力となる中間XMLファイル。
     * @param argDirectoryTarget
     *            ソースコードを出力する際の出力先ディレクトリ。
     */
    public void process(final File argFileSource, final File argDirectoryTarget) {
        final DOMResult result = BlancoXmlUtil.transformFile2Dom(argFileSource);

        final Node rootNode = result.getNode();
        if (rootNode instanceof Document) {
            // これが正常系。ドキュメントルートを取得
            final Document rootDocument = (Document) rootNode;
            final NodeList listSheet = rootDocument
                    .getElementsByTagName("sheet");
            final int sizeListSheet = listSheet.getLength();
            final Map<java.lang.String, java.lang.String> mapProcessedBaseName = new HashMap<java.lang.String, java.lang.String>(
                    64);
            for (int index = 0; index < sizeListSheet; index++) {
                final Element elementSheet = (Element) listSheet.item(index);

                final NodeList listCommon = elementSheet
                        .getElementsByTagName(fBundle
                                .getMeta2xmlElementCommon());
                if (listCommon == null || listCommon.getLength() == 0) {
                    // commonが無い場合にはスキップします。
                    continue;
                }

                final Element elementCommon = (Element) listCommon.item(0);

                final BlancoResourceBundleBundleStructure structure = new BlancoResourceBundleBundleStructure();

                structure.setName(BlancoXmlUtil.getTextContent(elementCommon,
                        "baseName"));
                if (structure.getName() == null) {
                    continue;
                }

                if (BlancoXmlUtil.getTextContent(elementCommon, "packageName") == null) {
                    // TODO パッケージ抜けはエラー扱いすべき
                    continue;
                }

                final List<java.lang.String> listLocale = new ArrayList<java.lang.String>();
                final NodeList nodeListCommon = elementCommon
                        .getElementsByTagName("locale");
                if (nodeListCommon == null || nodeListCommon.getLength() == 0) {
                    continue;
                }

                final int sizeNodeListCommon = nodeListCommon.getLength();
                for (int indexLocale = 0; indexLocale < sizeNodeListCommon; indexLocale++) {
                    final Node nodeLook = nodeListCommon.item(indexLocale);
                    if (nodeLook instanceof Element == false) {
                        continue;
                    }

                    final Element elementLook = (Element) nodeLook;
                    final NodeList nodeChilds = elementLook.getChildNodes();
                    if (nodeChilds == null) {
                        continue;
                    }

                    final int nodeChildsLength = nodeChilds.getLength();
                    for (int indexChild = 0; indexChild < nodeChildsLength; indexChild++) {
                        final Node nodeChild = nodeChilds.item(indexChild);
                        if (nodeChild instanceof Text) {
                            listLocale.add(((Text) nodeChild).getNodeValue());
                        }
                    }
                }
                if (listLocale.size() == 0) {
                    continue;
                }

                if (mapProcessedBaseName.get(structure.getName()) != null) {
                    throw new IllegalArgumentException(fMsg.getMbrbi005(
                            structure.getName(), (String) mapProcessedBaseName
                                    .get(structure.getName())));
                }

                expandSheet(elementSheet, elementCommon);
                mapProcessedBaseName.put(structure.getName(), "処理されました");
            }
        }
    }

    /**
     * 集約後の中間XMLファイルの内容妥当性チェックを行います。
     * 
     * @param argElementSheet
     *            シートのエレメント。
     * @param argElementCommon
     *            共通情報のエレメント。
     */
    private void expandSheet(final Element argElementSheet,
            final Element argElementCommon) {
        final BlancoResourceBundleBundleStructure structure = new BlancoResourceBundleBundleStructure();

        structure.setName(BlancoXmlUtil.getTextContent(argElementCommon,
                "baseName"));
        structure.setDescription(BlancoXmlUtil.getTextContent(argElementCommon,
                "description"));

        final List<java.lang.String> listKnownLocale = new ArrayList<java.lang.String>();
        final Map<java.lang.String, java.lang.String> mapBundle = new HashMap<java.lang.String, java.lang.String>();
        // 与えられたパッケージ名をそのまま利用します。

        final NodeList listCommonList = argElementSheet
                .getElementsByTagName(fBundle.getMeta2xmlElementCommon());
        if (listCommonList == null || listCommonList.getLength() == 0) {
            // commonが無い場合にはスキップします。
            return;
        }

        checkLocaleDup(structure.getName(), structure.getDescription(),
                listKnownLocale, listCommonList);

        final NodeList listResourceList = argElementSheet
                .getElementsByTagName(fBundle.getMeta2xmlElementList());
        if (listResourceList == null || listResourceList.getLength() == 0) {
            // 本体部分が無いものについては処理をスキップします。
            return;
        }

        final NodeList listResource = ((Element) listResourceList.item(0))
                .getElementsByTagName("resource");
        if (listResource == null || listResource.getLength() == 0) {
            return;
        }

        final int sizeListResource = listResource.getLength();
        for (int indexResource = 0; indexResource < sizeListResource; indexResource++) {
            final Element elementResource = (Element) listResource
                    .item(indexResource);

            final String fieldResourceId = BlancoStringUtil
                    .null2Blank(BlancoXmlUtil.getTextContent(elementResource,
                            "resourceKey"));

            final NodeList nodeListResourceString = elementResource
                    .getElementsByTagName("resourceString");
            if (nodeListResourceString == null
                    || nodeListResourceString.getLength() == 0) {
                // 一件も無い場合にはスキップします。
                continue;
            }

            checkMessageFormat(structure.getName(), structure.getDescription(),
                    mapBundle, fieldResourceId, nodeListResourceString,
                    fIsFailOnMessageFormatError);
        }
    }

    /**
     * ロケールの重複が存在しないかどうかをチェックします。
     * 
     * @param argBaseName
     * @param argDescription
     * @param argListKnownLocale
     * @param argListCommonList
     */
    private void checkLocaleDup(final String argBaseName,
            final String argDescription,
            final List<java.lang.String> argListKnownLocale,
            final NodeList argListCommonList) {
        // ロケールの重複チェックを行います。
        final NodeList listLocale = ((Element) argListCommonList.item(0))
                .getElementsByTagName("locale");
        if (listLocale == null || listLocale.getLength() == 0) {
            return;
        }

        final int sizeListLocale = listLocale.getLength();
        if (sizeListLocale > 0) {
            final Map<java.lang.String, java.lang.String> mapExistLocale = new HashMap<java.lang.String, java.lang.String>();
            for (int indexLocale = 0; indexLocale < sizeListLocale; indexLocale++) {
                final Element elementLocale = (Element) listLocale
                        .item(indexLocale);
                final String locale = BlancoStringUtil.null2Blank(BlancoXmlUtil
                        .getTextContent(elementLocale));
                if (mapExistLocale.get(locale) != null) {
                    // ロケールの重複が発見されました。
                    throw new IllegalArgumentException(fMsg.getMbrbi006(
                            argBaseName
                                    + (argDescription == null ? "" : "/"
                                            + argDescription), locale));
                }
                argListKnownLocale.add(locale);
                mapExistLocale.put(locale, locale);
            }
        }
    }

    /**
     * メッセージフォーマットのパース結果がロケール間において妥当な状態であるかどうかをチェックします。
     * 
     * ロケール間で相違がある場合には例外で処理中断します。
     * 
     * @param argBaseName
     *            基準名。
     * @param argDescription
     *            説明。例外発生時に利用されます。
     * @param argMapBundle
     * @param argFieldResourceId
     *            リソースID。
     * @param argNodeListResourceString
     * @param argIsFailOnMessageFormatError
     *            MessageFormatによるパースの結果として例外が発生した場合に処理中断するかどうか。
     */
    private void checkMessageFormat(final String argBaseName,
            final String argDescription,
            final Map<java.lang.String, java.lang.String> argMapBundle,
            final String argFieldResourceId,
            final NodeList argNodeListResourceString,
            final boolean argIsFailOnMessageFormatError) {
        final Map<java.lang.String, java.lang.String> mapProcessedLocale = new HashMap<java.lang.String, java.lang.String>();
        Format[] previousFormatList = null;

        final int nodeListResourceStringSize = argNodeListResourceString
                .getLength();
        for (int indexResourceString = 0; indexResourceString < nodeListResourceStringSize; indexResourceString++) {
            if (argNodeListResourceString.item(indexResourceString) instanceof Element == false) {
                continue;
            }

            final Element elementResourceString = (Element) argNodeListResourceString
                    .item(indexResourceString);
            final String resourceString = BlancoStringUtil
                    .null2Blank(BlancoXmlUtil
                            .getTextContent(elementResourceString));
            final String locale = BlancoStringUtil
                    .null2Blank(elementResourceString.getAttribute("locale"));
            if (mapProcessedLocale.get(locale) != null) {
                // 既に処理済のロケールであればリソースIDが重複しているエラーであると判断します。
                throw new IllegalArgumentException(fMsg.getMbrbi007(argBaseName
                        + (argDescription == null ? "" : "/" + argDescription),
                        locale, argFieldResourceId));
            }

            // 新たに処理対象とするロケールとして記憶します。
            mapProcessedLocale.put(locale, locale);
            if (argMapBundle.get(argFieldResourceId) == null) {
                // リソースバンドルのマップに記憶します。
                argMapBundle.put(argFieldResourceId, resourceString);
            }

            Format[] formatList = null;
            try {
                formatList = BlancoResourceBundleUtil
                        .getFormatsByArgumentIndex(resourceString,
                                argIsFailOnMessageFormatError);
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException(fMsg.getMbrbi008(
                        argBaseName, locale, argFieldResourceId,
                        BlancoJavaSourceUtil
                                .escapeStringAsJavaSource(resourceString))
                        + ex.toString());
            }

            if (indexResourceString == 0) {
                // 初回は比較を行いません。
            } else {
                if (previousFormatList == null && formatList == null) {
                    // 一致しています。問題ありません。
                } else if (previousFormatList == null && formatList != null) {
                    throw new IllegalArgumentException(fMsg.getMbrbi009(
                            argBaseName
                                    + (argDescription == null ? "" : "/"
                                            + argDescription), locale,
                            argFieldResourceId, String
                                    .valueOf(formatList.length)));
                } else if (previousFormatList != null && formatList == null) {
                    throw new IllegalArgumentException(fMsg.getMbrbi010(
                            argBaseName
                                    + (argDescription == null ? "" : "/"
                                            + argDescription), locale,
                            argFieldResourceId, String
                                    .valueOf(previousFormatList.length)));
                } else {
                    if (previousFormatList.length != formatList.length) {
                        throw new IllegalArgumentException(fMsg.getMbrbi011(
                                argBaseName
                                        + (argDescription == null ? "" : "/"
                                                + argDescription), locale,
                                argFieldResourceId, String
                                        .valueOf(formatList.length), String
                                        .valueOf(previousFormatList.length)));
                    }
                    for (int indexFormat = 0; indexFormat < formatList.length; indexFormat++) {
                        final String previousFormatClass = (previousFormatList[indexFormat] == null ? fBundle
                                .getExpandresourceSrc051()
                                : previousFormatList[indexFormat].getClass()
                                        .getName());
                        final String formatClass = (formatList[indexFormat] == null ? fBundle
                                .getExpandresourceSrc051()
                                : formatList[indexFormat].getClass().getName());
                        if (formatClass.equals(previousFormatClass) == false) {
                            throw new IllegalArgumentException(fMsg
                                    .getMbrbi012(argBaseName
                                            + (argDescription == null ? ""
                                                    : "/" + argDescription),
                                            locale, argFieldResourceId,
                                            formatClass, previousFormatClass));
                        }
                    }
                }
            }
            // 前回のリストとして記憶します。
            // nullだろうが何だろうが記憶する点がポイントです。
            previousFormatList = formatList;
        }
    }
}