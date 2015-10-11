/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.resourcebundle.resourcebundle;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * BlancoResourceBundle CSP (Collection of Small Programs) のリソースバンドル定義です。
 *
 * リソースバンドル定義: [BlancoResourceBundle]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
 * </UL>
 */
public class BlancoResourceBundleResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoResourceBundleResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoResourceBundle]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public BlancoResourceBundleResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/resourcebundle/resourcebundle/BlancoResourceBundle");
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
    }

    /**
     * BlancoResourceBundleResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoResourceBundle]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public BlancoResourceBundleResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/resourcebundle/resourcebundle/BlancoResourceBundle", locale);
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、ロケール[" + locale.toString() + "]、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
    }

    /**
     * BlancoResourceBundleResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoResourceBundle]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public BlancoResourceBundleResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/resourcebundle/resourcebundle/BlancoResourceBundle", locale, loader);
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、ロケール[" + locale.toString() + "]、指定のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
    }

    /**
     * 内部的に保持しているリソースバンドルオブジェクトを取得します。
     *
     * @return 内部的に保持しているリソースバンドルオブジェクト。
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoResourceBundle], key[METAFILE_DISPLAYNAME]
     *
     * [リソースバンドル定義書] (ja)<br>
     *
     * @return key[METAFILE_DISPLAYNAME]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMetafileDisplayname() {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義書";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("METAFILE_DISPLAYNAME");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[METAFILE_DISPLAYNAME]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[META2XML.ELEMENT_COMMON]
     *
     * [blancoresourcebundle-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommon() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancoresourcebundle-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[META2XML.ELEMENT_COMMON]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[META2XML.ELEMENT_LIST]
     *
     * [blancoresourcebundle-resourceList] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_LIST]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementList() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancoresourcebundle-resourceList";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_LIST");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[META2XML.ELEMENT_LIST]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[KEY_PREFIX]
     *
     * [] (ja)<br>
     *
     * @return key[KEY_PREFIX]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getKeyPrefix() {
        // 初期値として定義書の値を利用します。
        String strFormat = "";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("KEY_PREFIX");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[KEY_PREFIX]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[GENERATE_BUNDLE_SOURCE]
     *
     * [true] (ja)<br>
     *
     * @return key[GENERATE_BUNDLE_SOURCE]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getGenerateBundleSource() {
        // 初期値として定義書の値を利用します。
        String strFormat = "true";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("GENERATE_BUNDLE_SOURCE");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[GENERATE_BUNDLE_SOURCE]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[GENERATE_CONSTANTS_SOURCE]
     *
     * [false] (ja)<br>
     *
     * @return key[GENERATE_CONSTANTS_SOURCE]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getGenerateConstantsSource() {
        // 初期値として定義書の値を利用します。
        String strFormat = "false";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("GENERATE_CONSTANTS_SOURCE");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[GENERATE_CONSTANTS_SOURCE]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC011]
     *
     * [リソースバンドル定義: [{0}]。&lt;BR&gt;] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC011]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc011(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義: [{0}]。<BR>";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC011");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC011]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC012]
     *
     * [このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。&lt;BR&gt;] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC012]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc012() {
        // 初期値として定義書の値を利用します。
        String strFormat = "このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC012");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC012]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC013]
     *
     * [既知のロケール&lt;BR&gt;] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC013]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc013() {
        // 初期値として定義書の値を利用します。
        String strFormat = "既知のロケール<BR>";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC013");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC013]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC014]
     *
     * [リソースバンドルオブジェクト。] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC014]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc014() {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドルオブジェクト。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC014");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC014]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC015]
     *
     * [内部的に実際に入力を行うリソースバンドルを記憶します。] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC015]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc015() {
        // 初期値として定義書の値を利用します。
        String strFormat = "内部的に実際に入力を行うリソースバンドルを記憶します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC015");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC015]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC021]
     *
     * [{0}クラスのコンストラクタ。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC021]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc021(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "{0}クラスのコンストラクタ。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC021");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC021]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC022]
     *
     * [基底名[{0}]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC022]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc022(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC022");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC022]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC023]
     *
     * [基底名[{0}]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC023]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc023(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC023");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC023]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC031]
     *
     * [{0}クラスのコンストラクタ。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC031]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc031(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "{0}クラスのコンストラクタ。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC031");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC031]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC032]
     *
     * [基底名[{0}]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC032]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc032(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC032");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC032]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC033]
     *
     * [ロケールの指定] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC033]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc033() {
        // 初期値として定義書の値を利用します。
        String strFormat = "ロケールの指定";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC033");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC033]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC034]
     *
     * [基底名[{0}]、ロケール[&quot; + locale.toString() + &quot;]、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC034]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc034(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、ロケール[\" + locale.toString() + \"]、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC034");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC034]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC041]
     *
     * [{0}クラスのコンストラクタ。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC041]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc041(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "{0}クラスのコンストラクタ。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC041");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC041]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC042]
     *
     * [基底名[{0}]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC042]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc042(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC042");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC042]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC043]
     *
     * [ロケールの指定] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC043]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc043() {
        // 初期値として定義書の値を利用します。
        String strFormat = "ロケールの指定";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC043");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC043]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC044]
     *
     * [クラスローダの指定] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC044]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc044() {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラスローダの指定";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC044");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC044]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC045]
     *
     * [基底名[{0}]、ロケール[&quot; + locale.toString() + &quot;]、指定のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC045]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc045(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、ロケール[\" + locale.toString() + \"]、指定のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC045");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC045]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC051]
     *
     * [指定なし] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC051]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc051() {
        // 初期値として定義書の値を利用します。
        String strFormat = "指定なし";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC051");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC051]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC101]
     *
     * [置換文字列'{'{0,number}'}'を置換する値。{1}型を与えてください。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.math.BigDecimal型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC101]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc101(final BigDecimal arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "置換文字列'{'{0,number}'}'を置換する値。{1}型を与えてください。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC101");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC101]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC102]
     *
     * [key[{0}]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC102]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc102(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "key[{0}]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC102");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC102]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC103]
     *
     * [TODO: 注意: ロケール({0})は設定されていません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC103]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc103(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "TODO: 注意: ロケール({0})は設定されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC103");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC103]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC104]
     *
     * [初期値として定義書の値を利用します。] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC104]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc104() {
        // 初期値として定義書の値を利用します。
        String strFormat = "初期値として定義書の値を利用します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC104");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC104]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC105]
     *
     * [基底名[{0}]、キー[{1}]の定義が取得できませんでした。定義書の値を利用して処理続行します。:] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[EXPANDRESOURCE.SRC105]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc105(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}]、キー[{1}]の定義が取得できませんでした。定義書の値を利用して処理続行します。:";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC105");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC105]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC106]
     *
     * [与えられた引数を元に置換文字列を置き換えます。] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC106]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc106() {
        // 初期値として定義書の値を利用します。
        String strFormat = "与えられた引数を元に置換文字列を置き換えます。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC106");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC106]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoResourceBundle], key[EXPANDRESOURCE.SRC107]
     *
     * [置換文字列はひとつもありません。] (ja)<br>
     *
     * @return key[EXPANDRESOURCE.SRC107]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getExpandresourceSrc107() {
        // 初期値として定義書の値を利用します。
        String strFormat = "置換文字列はひとつもありません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("EXPANDRESOURCE.SRC107");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[BlancoResourceBundle]、キー[EXPANDRESOURCE.SRC107]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.resourcebundle.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}
