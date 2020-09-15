/*
 * blanco Framework
 * Copyright (C) 2004-2007 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.resourcebundle.expand;

import java.io.File;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoBigDecimalUtil;
import blanco.commons.util.BlancoJavaSourceUtil;
import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoStringUtil;
import blanco.resourcebundle.BlancoResourceBundleUtil;
import blanco.resourcebundle.resourcebundle.BlancoResourceBundleResourceBundle;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;

/**
 * 中間XMLファイルから プロパティファイルを生成する処理の内部処理です。
 *
 * このソースコードはblancoResourceBundleの一部です。<br>
 * XMLのDOMエレメントを入力としてファイルを出力します。 <br>
 *
 * 動作の前提条件:BlancoResourceBundleXmlValidatorクラスで事前にチェックされているものと想定します。
 *
 * @author IGA Tosiki
 */
public class BlancoResourceBundleExpandResourceBundle {
    /**
     * リソースバンドルアクセサのインスタンス。
     */
    private final BlancoResourceBundleResourceBundle fBundle = new BlancoResourceBundleResourceBundle();

    /**
     * 内部的に利用するblancoCg用ファクトリ。
     */
    private BlancoCgObjectFactory fCgFactory = null;

    /**
     * 内部的に利用するblancoCg用ソースファイル情報。
     */
    private BlancoCgSourceFile fCgSourceFile = null;

    /**
     * 内部的に利用するblancoCg用クラス情報。
     */
    private BlancoCgClass fCgClass = null;

    /**
     * ソースコード生成先ディレクトリのスタイル
     */
    private boolean fTargetStyleAdvanced = false;
    public void setTargetStyleAdvanced(boolean argTargetStyleAdvanced) {
        this.fTargetStyleAdvanced = argTargetStyleAdvanced;
    }
    public boolean isTargetStyleAdvanced() {
        return this.fTargetStyleAdvanced;
    }

    /**
     * 指定の情報をソースコードに展開します。
     *
     * ソースコード出力フラグによって、ソースコードを出力するかどうかが切り替わります。
     *
     * @param argStructure
     *            構造。
     * @param argDirectoryTarget
     *            出力先のターゲットディレクトリ。
     * @param argEncoding
     *            生成するソースコードの文字エンコーディング。
     * @param argIsFailOnMessageFormatError
     *            メッセージ文字列をMessageFormatによるパースを行った際の例外が発生したら処理を中断するかどうかのフラグを設定します
     *            。
     * @param argIsLog
     *            ログ出力を自動生成されるソースコードに含めるかどうか。
     * @param argPropertieswithdirectory
     *            プロパティファイルをディレクトリ付きで出力するかどうか。
     */
    public void expand(final BlancoResourceBundleBundleStructure argStructure,
            final File argDirectoryTarget, final String argEncoding,
            final boolean argIsFailOnMessageFormatError,
            final boolean argIsLog, final boolean argPropertieswithdirectory) {
        // クラス名は名前変形させます。
        final String className = BlancoNameAdjuster.toClassName(argStructure
                .getName())
                + (argStructure.getSuffix() == null ? "" : argStructure
                        .getSuffix());

        final List<java.lang.String> listKnownLocale = new ArrayList<java.lang.String>();
        final Map<java.lang.String, java.lang.String> mapBundle = new HashMap<java.lang.String, java.lang.String>();

        /*
         * 出力ディレクトリはant taskのtargetStyel引数で
         * 指定された書式で出力されます。
         * 従来と互換性を保つために、指定がない場合は blanco/main
         * となります。
         * by tueda, 2019/08/30
         */
        String strTarget = argDirectoryTarget
                .getAbsolutePath(); // advanced
        if (!this.isTargetStyleAdvanced()) {
            strTarget += "/main"; // legacy
        }
        final File fileBlancoMain = new File(strTarget);

        fCgFactory = BlancoCgObjectFactory.getInstance();
        fCgSourceFile = fCgFactory.createSourceFile(argStructure.getPackage(),
                null);
        fCgSourceFile.setEncoding(argEncoding);

        fCgClass = fCgFactory.createClass(className, null);
        fCgSourceFile.getClassList().add(fCgClass);

        // アクセスを設定します。
        fCgClass.setAccess(argStructure.getAccess());

        if (argStructure.getDescription() != null) {
            fCgClass.setDescription(argStructure.getDescription());
        }

        fCgClass.getLangDoc().getDescriptionList().add(
                fBundle.getExpandresourceSrc011(argStructure.getName()));

        fCgClass.getLangDoc().getDescriptionList().add(
                fBundle.getExpandresourceSrc012());

        String bundleFullPathName = argStructure.getName();
        if (argPropertieswithdirectory) {
            bundleFullPathName = BlancoStringUtil.replace(argStructure
                    .getPackage(), ".", "/", true)
                    + "/" + bundleFullPathName;
        }

        {
            final int sizeListLocale = argStructure.getListLocale().size();
            if (sizeListLocale > 0) {
                fCgClass.getLangDoc().getDescriptionList().add(
                        fBundle.getExpandresourceSrc013());
                fCgClass.getLangDoc().getDescriptionList().add("<UL>");
                for (int indexLocale = 0; indexLocale < sizeListLocale; indexLocale++) {
                    final String locale = (String) argStructure.getListLocale()
                            .get(indexLocale);
                    listKnownLocale.add(locale);
                    fCgClass.getLangDoc().getDescriptionList().add(
                            "<LI>" + locale);
                }
                fCgClass.getLangDoc().getDescriptionList().add("</UL>");
            }

            final BlancoCgField field1 = fCgFactory.createField(
                    "fResourceBundle", "java.util.ResourceBundle", fBundle
                            .getExpandresourceSrc014());
            fCgClass.getFieldList().add(field1);
            field1.getLangDoc().getDescriptionList().add(
                    fBundle.getExpandresourceSrc015());

            {
                final BlancoCgMethod method = fCgFactory.createMethod(
                        className, fBundle.getExpandresourceSrc021(className));
                fCgClass.getMethodList().add(method);
                method.setConstructor(true);
                method.getLangDoc().getDescriptionList()
                        .add(
                                fBundle.getExpandresourceSrc022(argStructure
                                        .getName()));

                // 常にインポートが必要です。
                fCgSourceFile.getImportList().add(
                        "java.util.MissingResourceException");

                final List<java.lang.String> listLine = method.getLineList();

                listLine.add("try {");
                listLine.add("fResourceBundle = ResourceBundle.getBundle(\""
                        + bundleFullPathName + "\");");
                listLine.add("} catch (MissingResourceException ex) {");
                if (argIsLog) {
                    listLine.add("final String message = \""
                            + fBundle.getExpandresourceSrc023(argStructure
                                    .getName()) + "\" + ex.toString();");
                    fCgSourceFile.getImportList().add(
                            "java.util.logging.Logger");
                    listLine.add("Logger.getLogger(\""
                            + argStructure.getPackage() + "\").fine(message);");
                }
                listLine.add("}");
            }

            {
                final BlancoCgMethod method = fCgFactory.createMethod(
                        className, fBundle.getExpandresourceSrc031(className));
                fCgClass.getMethodList().add(method);
                method.setConstructor(true);
                method.getLangDoc().getDescriptionList()
                        .add(
                                fBundle.getExpandresourceSrc032(argStructure
                                        .getName()));
                method.getParameterList().add(
                        fCgFactory.createParameter("locale",
                                "java.util.Locale", fBundle
                                        .getExpandresourceSrc033()));

                final List<java.lang.String> listLine = method.getLineList();

                listLine.add("try {");
                listLine.add("fResourceBundle = ResourceBundle.getBundle(\""
                        + bundleFullPathName + "\", locale);");
                listLine.add("} catch (MissingResourceException ex) {");
                if (argIsLog) {
                    listLine.add("final String message = \""
                            + fBundle.getExpandresourceSrc034(argStructure
                                    .getName()) + "\" + ex.toString();");
                    fCgSourceFile.getImportList().add(
                            "java.util.logging.Logger");
                    listLine.add("Logger.getLogger(\""
                            + argStructure.getPackage() + "\").fine(message);");
                }
                listLine.add("}");
            }

            {
                final BlancoCgMethod method = fCgFactory.createMethod(
                        className, fBundle.getExpandresourceSrc041(className));
                fCgClass.getMethodList().add(method);
                method.setConstructor(true);
                method.getLangDoc().getDescriptionList()
                        .add(
                                fBundle.getExpandresourceSrc042(argStructure
                                        .getName()));

                method.getParameterList().add(
                        fCgFactory.createParameter("locale",
                                "java.util.Locale", fBundle
                                        .getExpandresourceSrc043()));
                method.getParameterList().add(
                        fCgFactory.createParameter("loader",
                                "java.lang.ClassLoader", fBundle
                                        .getExpandresourceSrc044()));

                final List<java.lang.String> listLine = method.getLineList();

                listLine.add("try {");
                listLine.add("fResourceBundle = ResourceBundle.getBundle(\""
                        + bundleFullPathName + "\", locale, loader);");
                listLine.add("} catch (MissingResourceException ex) {");
                if (argIsLog) {
                    listLine.add("final String message = \""
                            + fBundle.getExpandresourceSrc045(argStructure
                                    .getName()) + "\" + ex.toString();");
                    fCgSourceFile.getImportList().add(
                            "java.util.logging.Logger");
                    listLine.add("Logger.getLogger(\""
                            + argStructure.getPackage() + "\").fine(message);");
                }
                listLine.add("}");
            }

            {
                // getResourceBundleメソッド
                final BlancoCgMethod method = fCgFactory.createMethod(
                        "getResourceBundle", "内部的に保持しているリソースバンドルオブジェクトを取得します。");
                fCgClass.getMethodList().add(method);

                method.setReturn(fCgFactory
                        .createReturn("java.util.ResourceBundle",
                                "内部的に保持しているリソースバンドルオブジェクト。"));

                final List<java.lang.String> listLine = method.getLineList();

                listLine.add("return fResourceBundle;");
            }

            final int sizeListResource = argStructure.getItemList().size();
            for (int indexResource = 0; indexResource < sizeListResource; indexResource++) {
                final BlancoResourceBundleBundleItemStructure itemStructure = (BlancoResourceBundleBundleItemStructure) argStructure
                        .getItemList().get(indexResource);

                final BlancoCgMethod methodGet = fCgFactory.createMethod("get"
                        + BlancoNameAdjuster
                                .toClassName(itemStructure.getKey()), "bundle["
                        + argStructure.getName() + "], key["
                        + itemStructure.getKey() + "]");
                fCgClass.getMethodList().add(methodGet);

                final Map<java.lang.String, java.lang.String> mapProcessedLocale = new HashMap<java.lang.String, java.lang.String>();
                for (int indexResourceString = 0; indexResourceString < itemStructure
                        .getResourceStringList().size(); indexResourceString++) {

                    final BlancoResourceBundleBundleResourceStringStructure resourceStringStructure = (BlancoResourceBundleBundleResourceStringStructure) itemStructure
                            .getResourceStringList().get(indexResourceString);

                    methodGet
                            .getLangDoc()
                            .getDescriptionList()
                            .add(
                                    "["
                                            + BlancoJavaSourceUtil
                                                    .escapeStringAsJavaDoc(BlancoStringUtil
                                                            .null2Blank(resourceStringStructure
                                                                    .getResourceString()))
                                            + "] ("
                                            + resourceStringStructure
                                                    .getLocale() + ")<br>");

                    // 処理済みのロケールであることを記憶します。
                    mapProcessedLocale.put(resourceStringStructure.getLocale(),
                            resourceStringStructure.getLocale());
                    if (mapBundle.get(itemStructure.getKey()) == null) {
                        mapBundle.put(itemStructure.getKey(),
                                resourceStringStructure.getResourceString());
                    }

                    // フォーマット例外は発生することは想定しません。なぜなら事前チェックにより既に解決されているからです。
                    final Format[] formatList = BlancoResourceBundleUtil
                            .getFormatsByArgumentIndex(BlancoStringUtil
                                    .null2Blank(resourceStringStructure
                                            .getResourceString()),
                                    argIsFailOnMessageFormatError);
                    for (int indexFormat = 0; indexFormat < formatList.length; indexFormat++) {
                        String strArgType = "java.lang.String";
                        if (formatList[indexFormat] == null) {
                            // フォーマットなし:
                            // java.lang.Stringへのマップが妥当
                            strArgType = "java.lang.String";
                        } else if (formatList[indexFormat] instanceof java.text.NumberFormat) {
                            // java.math.BigDecimalへのマップが妥当
                            strArgType = "java.math.BigDecimal";
                        } else if (formatList[indexFormat] instanceof java.text.DateFormat) {
                            // java.util.Dateへのマップが妥当
                            strArgType = "java.util.Date";
                        } else if (formatList[indexFormat] instanceof java.text.ChoiceFormat) {
                            // intへのマップが妥当
                            strArgType = "int";
                        } else {
                            strArgType = "java.lang.String";
                        }
                        if (indexResourceString == 0) {
                            // 初回のみメソッド引数を生成
                            methodGet
                                    .getParameterList()
                                    .add(
                                            fCgFactory
                                                    .createParameter(
                                                            "arg" + indexFormat,
                                                            strArgType,
                                                            fBundle
                                                                    .getExpandresourceSrc101(
                                                                            BlancoBigDecimalUtil
                                                                                    .toBigDecimal(indexFormat),
                                                                            strArgType)));
                        }
                    }
                    methodGet.setReturn(fCgFactory.createReturn(
                            "java.lang.String", fBundle
                                    .getExpandresourceSrc102(itemStructure
                                            .getKey())));
                }

                // ロケールが全て揃っているかどうかのチェックを行います。
                for (int indexCheck = 0; indexCheck < listKnownLocale.size(); indexCheck++) {
                    final String localeCheck = (String) listKnownLocale
                            .get(indexCheck);
                    final Object objCheck = mapProcessedLocale.get(localeCheck);
                    if (objCheck == null) {
                        // そろっていない場合であっても、JavaDocへの警告出力にとどめます。
                        methodGet.getLangDoc().getDescriptionList().add(
                                fBundle.getExpandresourceSrc103(localeCheck));
                    }
                }

                final String resourceString = (String) mapBundle
                        .get(itemStructure.getKey());

                final List<java.lang.String> listLine = methodGet.getLineList();

                listLine.add("// " + fBundle.getExpandresourceSrc104());
                listLine.add("String strFormat = \""
                        + BlancoJavaSourceUtil
                                .escapeStringAsJavaSource(BlancoStringUtil
                                        .null2Blank(resourceString)) + "\";");
                listLine.add("try {");
                listLine.add("if (fResourceBundle != null) {");
                listLine.add("strFormat = fResourceBundle.getString(\""
                        + BlancoJavaSourceUtil.escapeStringAsJavaSource(fBundle
                                .getKeyPrefix()
                                + itemStructure.getKey()) + "\");");
                listLine.add("}");
                listLine.add("} catch (MissingResourceException ex) {");
                if (argIsLog) {
                    listLine.add("final String message = \""
                            + fBundle.getExpandresourceSrc105(argStructure
                                    .getName(), fBundle.getKeyPrefix()
                                    + itemStructure.getKey())
                            + "\" + ex.toString();");
                    fCgSourceFile.getImportList().add(
                            "java.util.logging.Logger");
                    listLine.add("Logger.getLogger(\""
                            + argStructure.getPackage() + "\").fine(message);");
                }
                listLine.add("}");

                final Format[] formatList = BlancoResourceBundleUtil
                        .getFormatsByArgumentIndex(BlancoStringUtil
                                .null2Blank(resourceString),
                                argIsFailOnMessageFormatError);
                if (formatList.length > 0) {
                    String strArgForFormat = "";
                    for (int index = 0; index < formatList.length; index++) {
                        if (index != 0) {
                            strArgForFormat += ", ";
                        }
                        strArgForFormat += ("arg" + index);
                    }

                    fCgSourceFile.getImportList()
                            .add("java.text.MessageFormat");

                    listLine
                            .add("final MessageFormat messageFormat = new MessageFormat(strFormat);");
                    listLine
                            .add("final StringBuffer strbuf = new StringBuffer();");
                    listLine.add("// " + fBundle.getExpandresourceSrc106());
                    listLine.add("messageFormat.format(new Object[] {"
                            + strArgForFormat + "}, strbuf, null);");

                    listLine.add("return strbuf.toString();");
                } else {
                    listLine.add("// " + fBundle.getExpandresourceSrc107());
                    listLine.add("return strFormat;");
                }

            }
        }

        // ソースコードを実際に生成します。
        BlancoCgTransformerFactory.getJavaSourceTransformer().transform(
                fCgSourceFile, fileBlancoMain);
    }
}
