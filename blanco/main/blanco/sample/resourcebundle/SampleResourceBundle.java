/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.sample.resourcebundle;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Sample of blancoResourceBundle. This class is only for sample. It do not affect.
 *
 * リソースバンドル定義: [Sample]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
 * <LI>en
 * </UL>
 */
public class SampleResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * SampleResourceBundleクラスのコンストラクタ。
     *
     * 基底名[Sample]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public SampleResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/sample/resourcebundle/Sample");
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
    }

    /**
     * SampleResourceBundleクラスのコンストラクタ。
     *
     * 基底名[Sample]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public SampleResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/sample/resourcebundle/Sample", locale);
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、ロケール[" + locale.toString() + "]、呼び出し側のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
    }

    /**
     * SampleResourceBundleクラスのコンストラクタ。
     *
     * 基底名[Sample]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public SampleResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/sample/resourcebundle/Sample", locale, loader);
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、ロケール[" + locale.toString() + "]、指定のクラスローダを使用して、リソースバンドルの取得を試みましたが失敗しました。定義書の設定値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
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
     * bundle[Sample], key[MESSAGE001]
     *
     * [メッセージのサンプル。その１。] (ja)<br>
     * [Sample of message. No1.] (en)<br>
     *
     * @return key[MESSAGE001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage001() {
        // 初期値として定義書の値を利用します。
        String strFormat = "メッセージのサンプル。その１。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE001");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE001]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[Sample], key[MESSAGE002]
     *
     * [メッセージ置換文字[{0}]が置換されます。] (ja)<br>
     * [Replace message here [{0}].] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[MESSAGE002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage002(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "メッセージ置換文字[{0}]が置換されます。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE002");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE002]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE003]
     *
     * [メッセージ置換文字[{0}]に加え、もうひとつ[{1}]が置換されます。] (ja)<br>
     * [Replace message [{0}] and next message[{1}].] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[MESSAGE003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage003(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "メッセージ置換文字[{0}]に加え、もうひとつ[{1}]が置換されます。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE003");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE003]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE004]
     *
     * [{0}先頭から置換文字列がある例。] (ja)<br>
     * [{0}replace message from begin.] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[MESSAGE004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage004(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "{0}先頭から置換文字列がある例。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE004");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE004]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE005]
     *
     * [最後が置換文字列の例。{0}] (ja)<br>
     * [Replace message from last.{0}] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[MESSAGE005]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage005(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "最後が置換文字列の例。{0}";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE005");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE005]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE006]
     *
     * [何度も現れる置換文字{0}{1}{0}{1}{2}{1}{0}] (ja)<br>
     * [Many replace messages.{0}{1}{0}{1}{2}{1}{0}] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @return key[MESSAGE006]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage006(final String arg0, final String arg1, final String arg2) {
        // 初期値として定義書の値を利用します。
        String strFormat = "何度も現れる置換文字{0}{1}{0}{1}{2}{1}{0}";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE006");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE006]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE007]
     *
     * [たくさんの置換文字。{11}{10}{9}{8}{7}{6}{5}{4}{3}{2}{1}{0}と12個。] (ja)<br>
     * [Many replace messages.{11}{10}{9}{8}{7}{6}{5}{4}{3}{2}{1}{0} up to 12.] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @param arg4 置換文字列{4}を置換する値。java.lang.String型を与えてください。
     * @param arg5 置換文字列{5}を置換する値。java.lang.String型を与えてください。
     * @param arg6 置換文字列{6}を置換する値。java.lang.String型を与えてください。
     * @param arg7 置換文字列{7}を置換する値。java.lang.String型を与えてください。
     * @param arg8 置換文字列{8}を置換する値。java.lang.String型を与えてください。
     * @param arg9 置換文字列{9}を置換する値。java.lang.String型を与えてください。
     * @param arg10 置換文字列{10}を置換する値。java.lang.String型を与えてください。
     * @param arg11 置換文字列{11}を置換する値。java.lang.String型を与えてください。
     * @return key[MESSAGE007]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage007(final String arg0, final String arg1, final String arg2, final String arg3, final String arg4, final String arg5, final String arg6, final String arg7, final String arg8, final String arg9, final String arg10, final String arg11) {
        // 初期値として定義書の値を利用します。
        String strFormat = "たくさんの置換文字。{11}{10}{9}{8}{7}{6}{5}{4}{3}{2}{1}{0}と12個。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE007");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE007]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE008]
     *
     * [エスケープ処理の確認。ダブルクオーテーション&quot;、シングルクオーテーション'、エンマーク\。] (ja)<br>
     * [Check for escape string. Double &quot;, Single ', Yen \。] (en)<br>
     *
     * @return key[MESSAGE008]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage008() {
        // 初期値として定義書の値を利用します。
        String strFormat = "エスケープ処理の確認。ダブルクオーテーション\"、シングルクオーテーション'、エンマーク\\。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE008");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE008]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[Sample], key[MESSAGE009]
     *
     * [×] (ja)<br>
     * [X] (en)<br>
     *
     * @return key[MESSAGE009]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage009() {
        // 初期値として定義書の値を利用します。
        String strFormat = "×";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE009");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE009]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[Sample], key[MESSAGE010]
     *
     * [数値のメッセージ置換文字[{0,number}]の例。] (ja)<br>
     * [Number replace message[{0,number}] sample.] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.math.BigDecimal型を与えてください。
     * @return key[MESSAGE010]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage010(final BigDecimal arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "数値のメッセージ置換文字[{0,number}]の例。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE010");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE010]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[Sample], key[MESSAGE011]
     *
     * [日本語のみ定義されたりソース。] (ja)<br>
     * TODO: 注意: ロケール(en)は設定されていません。
     *
     * @return key[MESSAGE011]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage011() {
        // 初期値として定義書の値を利用します。
        String strFormat = "日本語のみ定義されたりソース。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE011");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE011]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[Sample], key[MESSAGE013]
     *
     * [] (ja)<br>
     * TODO: 注意: ロケール(en)は設定されていません。
     *
     * @return key[MESSAGE013]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage013() {
        // 初期値として定義書の値を利用します。
        String strFormat = "";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE013");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE013]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[Sample], key[MESSAGE012]
     *
     * [Resource for en locale only.] (en)<br>
     * TODO: 注意: ロケール(ja)は設定されていません。
     *
     * @return key[MESSAGE012]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMessage012() {
        // 初期値として定義書の値を利用します。
        String strFormat = "Resource for en locale only.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MESSAGE012");
            }
        } catch (MissingResourceException ex) {
            final String message = "基底名[Sample]、キー[MESSAGE012]の定義が取得できませんでした。定義書の値を利用して処理続行します。:" + ex.toString();
            Logger.getLogger("blanco.sample.resourcebundle").fine(message);
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}
