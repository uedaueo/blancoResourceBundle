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

import blanco.commons.util.BlancoStringUtil;
import blanco.resourcebundle.concretesax.BlancoResourceBundleXmlHandler;
import blanco.resourcebundle.concretesax.BlancoResourceBundleXmlSerializer;
import blanco.resourcebundle.message.BlancoResourceBundleMessage;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 中間XMLファイルから 集約された中間XMLファイルを生成します。
 *
 * このソースコードはblancoResourceBundleの一部です。<br>
 *
 * @author IGA Tosiki
 */
public class BlancoResourceBundleXml2CombinedXml {
    /**
     * メッセージ。
     */
    private final BlancoResourceBundleMessage fMsg = new BlancoResourceBundleMessage();

    /**
     * 中間XMLファイルから 集約された中間XMLファイルを生成します。
     *
     * @param argFileXmlSource
     *            入力となる中間XMLファイル。
     * @param argFileCombinedXmlTarget
     *            出力となる集約後中間XMLファイル。
     * @throws IOException
     *             入出力例外が発生した場合。
     * @throws TransformerException
     *             XML変換例外が発生した場合。
     */
    public void process(final File argFileXmlSource,
            final File argFileCombinedXmlTarget) throws IOException,
            TransformerException {
        // TODO このSAXライターを削除するためには、まず XmlSerializerを実装する必要があります！
        SAXResult result = new SAXResult(new BlancoResourceBundleXmlHandler() {
            private BlancoResourceBundleBundleStructure resourceBase = null;

            private List<BlancoResourceBundleBundleStructure> resourceBaseList = new ArrayList<BlancoResourceBundleBundleStructure>();

            public void startDocument() throws SAXException {
            }

            public void endDocument() throws SAXException {
            }

            public void startElementWorkbook(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementWorkbook(String uri, String localName,
                    String qName) throws SAXException {
                // この場所でCombinedXMLを生成します。
                OutputStream outStream = null;
                try {
                    outStream = new BufferedOutputStream(new FileOutputStream(
                            argFileCombinedXmlTarget));
                    final BlancoResourceBundleXmlSerializer serializer = new BlancoResourceBundleXmlSerializer(
                            outStream);
                    serializer.startDocument();
                    serializer.startElementWorkbook();
                    serializer.characters("\n");

                    for (int indexBase = 0; indexBase < resourceBaseList.size(); indexBase++) {
                        BlancoResourceBundleBundleStructure resourceBaseCurrent = (BlancoResourceBundleBundleStructure) resourceBaseList
                                .get(indexBase);
                        if (resourceBaseCurrent.getName() == null) {
                            continue;
                        }
                        if (resourceBaseCurrent.getPackage() == null) {
                            // パッケージ名が無い場合にはエラーとして扱います。
                            throw new SAXException(
                                    new IllegalArgumentException(fMsg
                                            .getMbrbi001(resourceBaseCurrent
                                                    .getName())));
                        }
                        if (resourceBaseCurrent.getSuffix() == null) {
                            resourceBaseCurrent.setSuffix("");
                        }

                        serializer.characters("  ");
                        serializer.startElementSheet(resourceBaseCurrent
                                .getName());
                        serializer.characters("\n");
                        serializer.characters("    ");
                        serializer.startElementBlancoresourcebundleCommon();
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.startElementBaseName();
                        serializer.characters(resourceBaseCurrent.getName());
                        serializer.endElementBaseName();
                        serializer.characters("\n");
                        serializer.characters("      ");
                        for (int index = 0; index < resourceBaseCurrent
                                .getListLocale().size(); index++) {
                            serializer.startElementLocale();
                            serializer.characters((String) resourceBaseCurrent
                                    .getListLocale().get(index));
                            serializer.endElementLocale();
                        }
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.startElementPackageName();
                        serializer.characters(resourceBaseCurrent.getPackage());
                        serializer.endElementPackageName();
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.startElementDescription();
                        serializer.characters(resourceBaseCurrent
                                .getDescription());
                        serializer.endElementDescription();
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.startElementSuffix();
                        serializer.characters(resourceBaseCurrent.getSuffix());
                        serializer.endElementSuffix();
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.startElementAnnotation();
                        serializer.characters(resourceBaseCurrent.getAnnotation());
                        serializer.endElementAnnotation();
                        serializer.characters("\n");
                        serializer.characters("    ");
                        serializer.endElementBlancoresourcebundleCommon();
                        serializer.characters("\n");
                        serializer.characters("    ");
                        serializer.startElementBlancoresourcebundleImport();
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.startElementImport();
                        for (int index = 0; index < resourceBaseCurrent.getImportList().size(); index++) {
                            serializer.characters("\n");
                            serializer.characters("    ");
                            serializer.characters("    ");
                            serializer.startElementNo();
                            serializer.characters(String.valueOf(index + 1));
                            serializer.endElementNo();
                            serializer.characters("\n");
                            serializer.characters("    ");
                            serializer.characters("    ");
                            serializer.startElementName();
                            serializer.characters(resourceBaseCurrent.getImportList().get(index));
                            serializer.endElementName();
                        }
                        serializer.characters("\n");
                        serializer.characters("      ");
                        serializer.endElementImport();
                        serializer.characters("\n");
                        serializer.characters("    ");
                        serializer.endElementBlancoresourcebundleImport();
                        serializer.characters("\n");
                        serializer.characters("  ");
                        serializer.startElementBlancoresourcebundleResourceList();
                        serializer.characters("\n");
                        for (int index = 0; index < resourceBaseCurrent
                                .getItemList().size(); index++) {
                            BlancoResourceBundleBundleItemStructure resourceItem = (BlancoResourceBundleBundleItemStructure) resourceBaseCurrent
                                    .getItemList().get(index);
                            if (resourceItem == null
                                    || resourceItem.getKey() == null) {
                                // キーがない場合にはスキップします。
                                continue;
                            }

                            serializer.characters("      ");
                            serializer.startElementResource();
                            serializer.characters("\n");
                            if (resourceItem.getNo() != null) {
                                serializer.characters("        ");
                                serializer.startElementNo();
                                serializer.characters(resourceItem.getNo());
                                serializer.endElementNo();
                                serializer.characters("\n");
                            }
                            serializer.characters("        ");
                            serializer.startElementResourceKey();
                            serializer.characters(resourceItem.getKey());
                            serializer.endElementResourceKey();
                            serializer.characters("\n");
                            for (int indexLocale = 0; indexLocale < resourceItem
                                    .getResourceStringList().size(); indexLocale++) {
                                BlancoResourceBundleBundleResourceStringStructure messageStructure = (BlancoResourceBundleBundleResourceStringStructure) resourceItem
                                        .getResourceStringList().get(
                                                indexLocale);
                                serializer.characters("        ");
                                serializer
                                        .startElementResourceString(messageStructure
                                                .getLocale());
                                serializer.characters(messageStructure
                                        .getResourceString());
                                serializer.endElementResourceString();
                                serializer.characters("\n");
                            }
                            serializer.characters("      ");
                            serializer.endElementResource();
                            serializer.characters("\n");
                        }
                        serializer.characters("    ");
                        serializer.endElementBlancoresourcebundleResourceList();
                        serializer.characters("\n");
                        serializer.characters("  ");
                        serializer.endElementSheet();
                        serializer.characters("\n");
                    }

                    serializer.endElementWorkbook();
                    serializer.endDocument();
                    outStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    new SAXException(e);
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                    new SAXException(e);
                } finally {
                    try {
                        if (outStream != null) {
                            outStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        new SAXException(e);
                    }
                }
            }

            public void charactersWorkbook(char[] ch, int start, int length)
                    throws SAXException {
            }

            public void ignorableWhitespaceWorkbook(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementSheet(String uri, String localName,
                    String qName, String attrName) throws SAXException {
            }

            public void endElementSheet(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersSheet(char[] ch, int start, int length)
                    throws SAXException {
            }

            public void ignorableWhitespaceSheet(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementBlancoresourcebundleCommon(String uri,
                    String localName, String qName) throws SAXException {
            }

            public void endElementBlancoresourcebundleCommon(String uri,
                    String localName, String qName) throws SAXException {
            }

            public void charactersBlancoresourcebundleCommon(char[] ch,
                    int start, int length) throws SAXException {
            }

            public void ignorableWhitespaceBlancoresourcebundleCommon(
                    char[] ch, int start, int length) throws SAXException {
            }

            public void startElementBaseName(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementBaseName(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersBaseName(char[] ch, int start, int length)
                    throws SAXException {
                BlancoResourceBundleBundleStructure resourceBaseFound = null;
                for (int index = 0; index < resourceBaseList.size(); index++) {
                    final BlancoResourceBundleBundleStructure resourceBaseLook = (BlancoResourceBundleBundleStructure) resourceBaseList
                            .get(index);
                    if (resourceBaseLook.getName().equals(
                            new String(ch, start, length))) {
                        resourceBaseFound = resourceBaseLook;
                        break;
                    }
                }
                if (resourceBaseFound == null) {
                    resourceBase = new BlancoResourceBundleBundleStructure();
                    resourceBase.setName(new String(ch, start, length));
                    resourceBaseList.add(resourceBase);
                }
            }

            public void ignorableWhitespaceBaseName(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementLocale(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementLocale(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersLocale(char[] ch, int start, int length)
                    throws SAXException {
                try {
                    if (resourceBase != null) {
                        resourceBase.getListLocale().add(
                                new String(ch, start, length));
                        resourceBase.setCurrentLocale(new String(ch, start,
                                length));
                    }
                } catch (Exception ex) {
                    throw new SAXException(ex);
                }
            }

            public void ignorableWhitespaceLocale(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementPackageName(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementPackageName(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersPackageName(char[] ch, int start, int length)
                    throws SAXException {
                if (resourceBase != null) {
                    if (resourceBase.getPackage() != null
                            && resourceBase.getPackage().equals(
                                    new String(ch, start, length)) == false) {
                        throw new SAXException(new IllegalArgumentException(
                                fMsg.getMbrbi002(resourceBase.getName(),
                                        resourceBase.getPackage(), new String(
                                                ch, start, length))));
                    }
                    resourceBase.setPackage(new String(ch, start, length));
                }
            }

            public void ignorableWhitespacePackageName(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementSuffix(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementSuffix(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersSuffix(char[] ch, int start, int length)
                    throws SAXException {
                if (resourceBase != null) {
                    if (resourceBase.getSuffix() != null
                            && resourceBase.getSuffix().equals(
                                    new String(ch, start, length)) == false) {
                        throw new SAXException(new IllegalArgumentException(
                                fMsg.getMbrbi003(resourceBase.getSuffix(),
                                        new String(ch, start, length))));
                    }
                    resourceBase.setSuffix(new String(ch, start, length));
                }
            }

            public void ignorableWhitespaceSuffix(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementAnnotation(String uri, String localName, String qName) throws SAXException {
            }

            public void endElementAnnotation(String uri, String localName, String qName) throws SAXException {
            }

            public void charactersAnnotation(char[] ch, int start, int length) throws SAXException {
                if (resourceBase != null) {
                    resourceBase.setAnnotation(new String(ch, start, length));
                }
            }

            public void ignorableWhitespaceAnnotation(char[] ch, int start, int length) throws SAXException {
            }

            public void startElementBlancoresourcebundleImport(
                    String uri, String localName, String qName)
                    throws SAXException {
            }

            public void endElementBlancoresourcebundleImport(String uri, String localName, String qName) throws SAXException {
            }

            public void charactersBlancoresourcebundleImport(char[] ch, int start, int length) throws SAXException {
            }

            public void ignorableWhitespaceBlancoresourcebundleImport(char[] ch, int start, int length) throws SAXException {
            }

            public void startElementImport(String uri, String localName, String qName) throws SAXException {
            }

            public void endElementImport(String uri, String localName, String qName) throws SAXException {
            }

            public void charactersImport(char[] ch, int start, int length) throws SAXException {
            }

            public void ignorableWhitespaceImport(char[] ch, int start, int length) throws SAXException {
            }

            /**
             * startElementが接頭辞付きの修飾名[name]で呼び出されました。<br>
             * ※接頭辞付きの修飾名はメソッド名に含まれるものと同等のものが与えられます。
             *
             * @param uri       名前空間URI
             * @param localName ローカル名
             * @param qName
             */
            @Override
            public void startElementName(String uri, String localName, String qName) throws SAXException {

            }

            /**
             * endElementが接頭辞付きの修飾名[name]で呼び出されました。<br>
             * ※接頭辞付きの修飾名はメソッド名に含まれるものと同等のものが与えられます。
             *
             * @param uri       名前空間URI
             * @param localName ローカル名
             * @param qName
             */
            @Override
            public void endElementName(String uri, String localName, String qName) throws SAXException {

            }

            /**
             * charactersが接頭辞付きの修飾名[name]で呼び出されました。<br>
             * もとのcharactersメソッドを集約した上でメソッドが呼び出されます。
             *
             * @param ch     XML文書の文字
             * @param start  配列内の開始位置
             * @param length
             */
            @Override
            public void charactersName(char[] ch, int start, int length) throws SAXException {
                if (resourceBase != null
                        && resourceBase.getImportList() != null) {
                    resourceBase.getImportList().add(new String(ch, start, length));
                }
            }

            /**
             * ignorableWhitespaceが接頭辞付きの修飾名[name]で呼び出されました。<br>
             * もとのcharactersメソッドを集約した上でメソッドが呼び出されます。
             *
             * @param ch     XML文書の文字
             * @param start  配列内の開始位置
             * @param length
             */
            @Override
            public void ignorableWhitespaceName(char[] ch, int start, int length) throws SAXException {

            }

            public void startElementBlancoresourcebundleResourceList(
                    String uri, String localName, String qName)
                    throws SAXException {
            }

            public void endElementBlancoresourcebundleResourceList(String uri,
                    String localName, String qName) throws SAXException {
            }

            public void charactersBlancoresourcebundleResourceList(char[] ch,
                    int start, int length) throws SAXException {
            }

            public void ignorableWhitespaceBlancoresourcebundleResourceList(
                    char[] ch, int start, int length) throws SAXException {
            }

            public void startElementResource(String uri, String localName,
                    String qName) throws SAXException {
                if (resourceBase != null) {
                    resourceBase
                            .setResourceItem(new BlancoResourceBundleBundleItemStructure());
                }
            }

            public void endElementResource(String uri, String localName,
                    String qName) throws SAXException {
                try {
                    if (resourceBase != null) {
                        if (BlancoStringUtil.null2Blank(
                                resourceBase.getCurrentLocale()).length() == 0) {
                            // ロケールの指定がありません。エラーと扱います。
                            throw new IllegalArgumentException(fMsg
                                    .getMbrbi004(resourceBase.getName()));
                        }
                        if (resourceBase.getItemList() != null) {
                            if (resourceBase.getCurrentResourceString() == null) {
                                // 値が何も入っていない場合(NULLのまま)だとあとで困るので、空文字列をセットします。
                                // リソース文字列は必ず値が入っていることになります。
                                resourceBase.setCurrentResourceString("");
                            }
                            BlancoResourceBundleBundleItemStructure foundItem = null;
                            for (int index = 0; index < resourceBase
                                    .getItemList().size(); index++) {
                                BlancoResourceBundleBundleItemStructure itemLook = (BlancoResourceBundleBundleItemStructure) resourceBase
                                        .getItemList().get(index);
                                if (itemLook.getKey() == null) {
                                    // XMLのコンバインとしては、これを読み飛ばします。
                                    // プロパティファイルのコメントは、これとは別の経路から情報取得します。
                                    continue;
                                }
                                if (itemLook.getKey()
                                        .equals(
                                                resourceBase.getResourceItem()
                                                        .getKey())) {
                                    foundItem = itemLook;
                                    break;
                                }
                            }
                            if (foundItem == null) {
                                resourceBase.getItemList().add(
                                        resourceBase.getResourceItem());
                                final BlancoResourceBundleBundleResourceStringStructure item = new BlancoResourceBundleBundleResourceStringStructure();
                                item.setLocale(resourceBase.getCurrentLocale());
                                item.setResourceString(resourceBase
                                        .getCurrentResourceString());
                                resourceBase.getResourceItem()
                                        .getResourceStringList().add(item);
                            } else {
                                final BlancoResourceBundleBundleResourceStringStructure item = new BlancoResourceBundleBundleResourceStringStructure();
                                item.setLocale(resourceBase.getCurrentLocale());
                                item.setResourceString(resourceBase
                                        .getCurrentResourceString());
                                foundItem.getResourceStringList().add(item);
                            }
                        }
                        // リソース文字列はもう利用済みなので これをクリアします。
                        resourceBase.setCurrentResourceString(null);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new SAXException(ex);
                }
            }

            public void charactersResource(char[] ch, int start, int length)
                    throws SAXException {
            }

            public void ignorableWhitespaceResource(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementNo(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementNo(String uri, String localName, String qName)
                    throws SAXException {
            }

            public void charactersNo(char[] ch, int start, int length)
                    throws SAXException {
                if (resourceBase != null
                        && resourceBase.getResourceItem() != null) {
                    resourceBase.getResourceItem().setNo(
                            new String(ch, start, length));
                }
            }

            public void ignorableWhitespaceNo(char[] ch, int start, int length)
                    throws SAXException {
            }

            public void startElementResourceKey(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementResourceKey(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersResourceKey(char[] ch, int start, int length)
                    throws SAXException {
                try {
                    if (resourceBase != null
                            && resourceBase.getResourceItem() != null) {
                        resourceBase.getResourceItem().setKey(
                                new String(ch, start, length));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new SAXException(ex);
                }
            }

            public void ignorableWhitespaceResourceKey(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementResourceString(String uri,
                    String localName, String qName, String attrLocale)
                    throws SAXException {
            }

            public void endElementResourceString(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersResourceString(char[] ch, int start,
                    int length) throws SAXException {
                if (resourceBase != null) {
                    resourceBase.setCurrentResourceString(new String(ch, start,
                            length));
                }
            }

            public void ignorableWhitespaceResourceString(char[] ch, int start,
                    int length) throws SAXException {
            }

            public void startElementDescription(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void endElementDescription(String uri, String localName,
                    String qName) throws SAXException {
            }

            public void charactersDescription(char[] ch, int start, int length)
                    throws SAXException {
                if (resourceBase != null) {
                    resourceBase.setDescription(new String(ch, start, length));
                }
            }

            public void ignorableWhitespaceDescription(char[] ch, int start,
                    int length) throws SAXException {
            }

        });

        InputStream inStream = null;
        try {
            inStream = new BufferedInputStream(new FileInputStream(
                    argFileXmlSource));
            final TransformerFactory tf = TransformerFactory.newInstance();
            final Transformer transformer = tf.newTransformer();
            transformer.transform(new StreamSource(inStream), result);
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
    }
}
