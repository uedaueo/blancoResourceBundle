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

import blanco.commons.util.BlancoStringUtil;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;
import blanco.xml.bind.BlancoXmlBindingUtil;
import blanco.xml.bind.BlancoXmlUnmarshaller;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlElement;

/**
 * blancoResourceBundleの 中間XMLファイル形式をパース(読み書き)するクラス。
 * 
 * 注意: 2007.09.19時点では、プロパティファイル生成のみで このクラスを利用しています。
 * 外部のプロダクトがリソースバンドルの中間ファイルにアクセスする際にも、このクラスを利用することを想定しています。
 * 
 * @author IGA Tosiki
 */
public class BlancoResourceBundleXmlParser {
    /**
     * 中間XMLファイルのXMLドキュメントをパースして、バリューオブジェクト情報の配列を取得します。
     * 
     * @param argMetaXmlSourceFile
     *            中間XMLファイル。
     * @return パースの結果得られたバリューオブジェクト情報の配列。
     */
    public BlancoResourceBundleBundleStructure[] parse(
            final File argMetaXmlSourceFile) {
        final BlancoXmlDocument documentMeta = new BlancoXmlUnmarshaller()
                .unmarshal(argMetaXmlSourceFile);
        if (documentMeta == null) {
            return null;
        }

        return parse(documentMeta);
    }

    /**
     * 中間XMLファイル形式のXMLドキュメントをパースして、バリューオブジェクト情報の配列を取得します。
     * 
     * @param argXmlDocument
     *            中間XMLファイルのXMLドキュメント。
     * @return パースの結果得られたバリューオブジェクト情報の配列。
     */
    public BlancoResourceBundleBundleStructure[] parse(
            final BlancoXmlDocument argXmlDocument) {
        final List<BlancoResourceBundleBundleStructure> listStructure = new ArrayList<BlancoResourceBundleBundleStructure>();

        // ルートエレメントを取得します。
        final BlancoXmlElement elementRoot = BlancoXmlBindingUtil
                .getDocumentElement(argXmlDocument);
        if (elementRoot == null) {
            // ルートエレメントが無い場合には処理中断します。
            return null;
        }

        // sheet(Excelシート)のリストを取得します。
        final List<BlancoXmlElement> listSheet = BlancoXmlBindingUtil
                .getElementsByTagName(elementRoot, "sheet");

        final int sizeListSheet = listSheet.size();
        for (int index = 0; index < sizeListSheet; index++) {
            final BlancoXmlElement elementSheet = listSheet.get(index);

            final BlancoResourceBundleBundleStructure objResourceBaseStructure = parseElementSheet(elementSheet);
            if (objResourceBaseStructure != null) {
                // 得られた情報を記憶します。
                listStructure.add(objResourceBaseStructure);
            }
        }

        final BlancoResourceBundleBundleStructure[] result = new BlancoResourceBundleBundleStructure[listStructure
                .size()];
        listStructure.toArray(result);
        return result;
    }

    /**
     * 中間XMLファイル形式の「sheet」XMLエレメントをパースして、バリューオブジェクト情報を取得します。
     * 
     * @param argElementSheet
     *            中間XMLファイルの「sheet」XMLエレメント。
     * @return パースの結果得られたバリューオブジェクト情報。「name」が見つからなかった場合には nullを戻します。
     */
    public BlancoResourceBundleBundleStructure parseElementSheet(
            final BlancoXmlElement argElementSheet) {
        final BlancoResourceBundleBundleStructure resourceBaseStructure = new BlancoResourceBundleBundleStructure();
        final List<BlancoXmlElement> listCommon = BlancoXmlBindingUtil
                .getElementsByTagName(argElementSheet,
                        "blancoresourcebundle-common");
        if (listCommon == null || listCommon.size() == 0) {
            // commonが無い場合にはスキップします。
            return null;
        }

        final BlancoXmlElement elementCommon = listCommon.get(0);
        resourceBaseStructure.setName(BlancoXmlBindingUtil.getTextContent(
                elementCommon, "baseName"));

        // カレントロケールを記憶します。
        resourceBaseStructure.setCurrentLocale(BlancoXmlBindingUtil
                .getTextContent(elementCommon, "locale"));

        final List<BlancoXmlElement> localeList = BlancoXmlBindingUtil
                .getElementsByTagName(elementCommon, "locale");
        for (int indexLocale = 0; indexLocale < localeList.size(); indexLocale++) {
            final BlancoXmlElement elementLocale = localeList.get(indexLocale);
            // Combine後の中間XML上では、localeは複数回登場します。
            resourceBaseStructure.getListLocale().add(
                    BlancoXmlBindingUtil.getTextContent(elementLocale));
        }

        resourceBaseStructure.setPackage(BlancoXmlBindingUtil.getTextContent(
                elementCommon, "packageName"));
        resourceBaseStructure.setSuffix(BlancoXmlBindingUtil.getTextContent(
                elementCommon, "suffix"));
        resourceBaseStructure.setDescription(BlancoXmlBindingUtil
                .getTextContent(elementCommon, "description"));

        if (BlancoStringUtil.null2Blank(resourceBaseStructure.getName()).trim()
                .length() == 0) {
            return null;
        }
        if (BlancoStringUtil.null2Blank(resourceBaseStructure.getPackage())
                .trim().length() == 0) {
            return null;
        }
        if (resourceBaseStructure.getListLocale().size() == 0) {
            return null;
        }

        final List<BlancoXmlElement> listList = BlancoXmlBindingUtil
                .getElementsByTagName(argElementSheet,
                        "blancoresourcebundle-resourceList");
        final BlancoXmlElement elementListRoot = listList.get(0);
        final List<BlancoXmlElement> listChildNodes = BlancoXmlBindingUtil
                .getElementsByTagName(elementListRoot, "resource");
        for (int index = 0; index < listChildNodes.size(); index++) {
            final BlancoXmlElement elementList = listChildNodes.get(index);
            final BlancoResourceBundleBundleItemStructure resourceItemStructure = new BlancoResourceBundleBundleItemStructure();

            resourceItemStructure.setNo(BlancoXmlBindingUtil.getTextContent(
                    elementList, "no"));
            resourceItemStructure.setKey(BlancoXmlBindingUtil.getTextContent(
                    elementList, "resourceKey"));

            final List<BlancoXmlElement> listResourceString = BlancoXmlBindingUtil
                    .getElementsByTagName(elementList, "resourceString");
            for (int indexString = 0; indexString < listResourceString.size(); indexString++) {
                final BlancoXmlElement eleResourceString = listResourceString
                        .get(indexString);
                final BlancoResourceBundleBundleResourceStringStructure resourceMessageItem = new BlancoResourceBundleBundleResourceStringStructure();
                resourceMessageItem.setLocale(BlancoXmlBindingUtil
                        .getAttribute(eleResourceString, "locale"));
                resourceMessageItem.setResourceString(BlancoXmlBindingUtil
                        .getTextContent(eleResourceString));

                resourceItemStructure.getResourceStringList().add(
                        resourceMessageItem);
            }

            // ResourceKey がnullであっても追加します。
            // それはコメント欄を表現するものです。

            resourceBaseStructure.getItemList().add(resourceItemStructure);
        }

        return resourceBaseStructure;
    }
}
