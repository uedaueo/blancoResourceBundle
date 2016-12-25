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
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoXmlUtil;
import blanco.resourcebundle.resourcebundle.BlancoResourceBundleResourceBundle;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;

/**
 * 中間XMLファイルから プロパティファイルのキー部分のみの定数クラスを生成します。
 * 
 * このソースコードはblancoResourceBundleの一部です。<br>
 * 内部的には blancoConstants用のXMLファイルを生成します。
 * 
 * @author IGA Tosiki
 */
public class BlancoResourceBundleXml2ConstantsXml {
    /**
     * リソースバンドルアクセサのインスタンス。
     */
    private final BlancoResourceBundleResourceBundle fBundle = new BlancoResourceBundleResourceBundle();

    /**
     * 中間XMLファイルから プロパティファイルのキー部分のみの定数クラスを生成します。
     * 
     * @param argFileSource
     *            入力となる中間XMLファイル。
     * @param argTmpResourceBundleDirectory
     *            blancoConstants用の中間XMLファイルを出力する出力先ディレクトリ。
     */
    public void process(final File argFileSource,
            final File argTmpResourceBundleDirectory) {
        final DOMResult result = BlancoXmlUtil.transformFile2Dom(argFileSource);

        final Node rootNode = result.getNode();
        if (rootNode instanceof Document) {
            // これが正常系。ドキュメントルートを取得
            final Document rootDocument = (Document) rootNode;
            final NodeList listSheet = rootDocument
                    .getElementsByTagName("sheet");
            final int sizeListSheet = listSheet.getLength();
            for (int index = 0; index < sizeListSheet; index++) {
                final Element elementSheet = (Element) listSheet.item(index);
                // System.out.println("シート[" + elementSheet.getAttribute("name")
                // + "]を処理中。");

                final NodeList listCommon = elementSheet
                        .getElementsByTagName(fBundle
                                .getMeta2xmlElementCommon());
                if (listCommon.getLength() == 0) {
                    // commonが無い場合にはスキップします。
                    continue;
                }

                final Element elementCommon = (Element) listCommon.item(0);
                final String baseName = BlancoXmlUtil.getTextContent(
                        elementCommon, "baseName");
                if (baseName == null) {
                    continue;
                }

                if (BlancoXmlUtil.getTextContent(elementCommon, "packageName") == null) {
                    continue;
                }

                final List<java.lang.String> listLocale = new ArrayList<java.lang.String>();
                final NodeList nodeListCommon = elementCommon
                        .getElementsByTagName("locale");
                for (int indexLocale = 0; indexLocale < nodeListCommon
                        .getLength(); indexLocale++) {
                    final Node nodeLook = nodeListCommon.item(indexLocale);
                    if (nodeLook instanceof Element) {
                        final Element elementLook = (Element) nodeLook;
                        final NodeList nodeChields = elementLook
                                .getChildNodes();
                        for (int indexChild = 0; indexChild < nodeChields
                                .getLength(); indexChild++) {
                            final Node nodeChild = nodeChields.item(indexChild);
                            if (nodeChild instanceof Text) {
                                listLocale.add(((Text) nodeChild)
                                        .getNodeValue());
                            }
                        }
                    }
                }
                if (listLocale.size() == 0) {
                    continue;
                }

                expandSheet(elementSheet, elementCommon,
                        argTmpResourceBundleDirectory);
            }
        }
    }

    /**
     * シートのノードを展開します。
     * 
     * @param argElementSheet
     *            シートエレメント。
     * @param argElementCommon
     *            共通エレメント。
     * @param argTmpResourceBundleDirectory
     *            blancoConstants用の中間XMLファイルを出力する出力先ディレクトリ。
     */
    private void expandSheet(final Element argElementSheet,
            final Element argElementCommon,
            final File argTmpResourceBundleDirectory) {
        final BlancoResourceBundleBundleStructure structure = new BlancoResourceBundleBundleStructure();
        structure.setName(BlancoXmlUtil.getTextContent(argElementCommon,
                "baseName"));
        // クラス名は名前変形させます。
        final String className = BlancoNameAdjuster.toClassName(structure
                .getName())
                + "Constants";
        structure.setPackage(BlancoXmlUtil.getTextContent(argElementCommon,
                "packageName"));
        structure.setDescription(BlancoXmlUtil.getTextContent(argElementCommon,
                "description"));

        final NodeList listResourceList = argElementSheet
                .getElementsByTagName(fBundle.getMeta2xmlElementList());
        if (listResourceList.getLength() == 0) {
            // commonが無い場合にはスキップします。
            return;
        }

        new File(argTmpResourceBundleDirectory.getAbsolutePath() + "/constants")
                .mkdirs();

        final Document document = BlancoXmlUtil.newDocument();
        final Element eleWorkbook = document.createElement("workbook");
        document.appendChild(eleWorkbook);

        final Element eleSheet = document.createElement("sheet");
        eleWorkbook.appendChild(eleSheet);

        final Element eleCommon = document
                .createElement("blancoconstants-common");
        eleSheet.appendChild(eleCommon);

        BlancoXmlUtil.addChildElement(document, eleCommon, "name", className);
        BlancoXmlUtil.addChildElement(document, eleCommon, "package", structure
                .getPackage());
        BlancoXmlUtil.addChildElement(document, eleCommon, "description",
                structure.getDescription());
        BlancoXmlUtil.addChildElement(document, eleCommon, "fileDescription",
                structure.getDescription());

        final Element eleList = document.createElement("blancoconstants-list");
        eleSheet.appendChild(eleList);

        final NodeList listResource = ((Element) listResourceList.item(0))
                .getElementsByTagName("resource");
        final int sizeListResource = listResource.getLength();
        for (int indexResource = 0; indexResource < sizeListResource; indexResource++) {
            final Element elementResource = (Element) listResource
                    .item(indexResource);

            final Element eleField = document.createElement("field");
            eleList.appendChild(eleField);

            final String fieldResourceId = BlancoXmlUtil.getTextContent(
                    elementResource, "resourceKey");

            // noはあえて出力しません。

            BlancoXmlUtil.addChildElement(document, eleField, "name",
                    fieldResourceId.replaceAll("[.]", "_"));
            BlancoXmlUtil.addChildElement(document, eleField, "type",
                    "java.lang.String");
            BlancoXmlUtil.addChildElement(document, eleField, "value",
                    fieldResourceId);

            String allDescription = "";
            final NodeList nodeListResourceString = elementResource
                    .getElementsByTagName("resourceString");
            for (int indexResourceString = 0; indexResourceString < nodeListResourceString
                    .getLength(); indexResourceString++) {
                if (nodeListResourceString.item(indexResourceString) instanceof Element) {
                    final Element elementResourceString = (Element) nodeListResourceString
                            .item(indexResourceString);
                    final String resourceString = BlancoXmlUtil
                            .getTextContent(elementResourceString);
                    if (resourceString != null) {
                        if (allDescription.length() != 0) {
                            allDescription += "\n";
                        }
                        allDescription += resourceString;
                    }
                }
            }

            // 実際のキーの内容をJavaDocに記載します。
            BlancoXmlUtil.addChildElement(document, eleField, "description",
                    "内容: " + allDescription + " (キー: " + fieldResourceId + ")");
        }
        BlancoXmlUtil.transformDom2File(document, new File(
                argTmpResourceBundleDirectory.getAbsolutePath() + "/constants/"
                        + className + ".constantsxml"));
    }
}