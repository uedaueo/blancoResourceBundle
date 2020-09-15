package blanco.resourcebundle.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * メッセージ定義[BlancoResourceBundle]が内部的に利用するリソースバンドルクラス。
 *
 * リソースバンドル定義: [BlancoResourceBundleMessage]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 */
class BlancoResourceBundleMessageResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoResourceBundleMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoResourceBundleMessage]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public BlancoResourceBundleMessageResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/resourcebundle/message/BlancoResourceBundleMessage");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoResourceBundleMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoResourceBundleMessage]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public BlancoResourceBundleMessageResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/resourcebundle/message/BlancoResourceBundleMessage", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoResourceBundleMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoResourceBundleMessage]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public BlancoResourceBundleMessageResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/resourcebundle/message/BlancoResourceBundleMessage", locale, loader);
        } catch (MissingResourceException ex) {
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
     * bundle[BlancoResourceBundleMessage], key[MBRBI001]
     *
     * [リソース定義[{0}]のパッケージの指定が見つかりません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi001(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソース定義[{0}]のパッケージの指定が見つかりません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI001");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI002]
     *
     * [リソース定義[{0}]に異なるパッケージの指定[{1}]と[{2}]が見つかりました。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi002(final String arg0, final String arg1, final String arg2) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソース定義[{0}]に異なるパッケージの指定[{1}]と[{2}]が見つかりました。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI002");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI003]
     *
     * [異なるサフィックス[{0}]と[{1}]が同一の設定ファイル上に見つかりました。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi003(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "異なるサフィックス[{0}]と[{1}]が同一の設定ファイル上に見つかりました。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI003");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI004]
     *
     * [リソース定義[{0}]のロケールの指定が見つかりません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi004(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソース定義[{0}]のロケールの指定が見つかりません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI004");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI005]
     *
     * [基底名[{0}] は既にロケール[{1}]で処理されています。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI005]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi005(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}] は既にロケール[{1}]で処理されています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI005");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI006]
     *
     * [リソースバンドル定義[{0}]のロケール[{1}]が重複して定義されています。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI006]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi006(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義[{0}]のロケール[{1}]が重複して定義されています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI006");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI007]
     *
     * [リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]が重複して定義されています。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI007]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi007(final String arg0, final String arg1, final String arg2) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]が重複して定義されています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI007");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI008]
     *
     * [基底名[{0}] ロケール[{1}] キー[{2}] 文字列[{3}]の解析に失敗しました。文字列が不正である可能性があります。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI008]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi008(final String arg0, final String arg1, final String arg2, final String arg3) {
        // 初期値として定義書の値を利用します。
        String strFormat = "基底名[{0}] ロケール[{1}] キー[{2}] 文字列[{3}]の解析に失敗しました。文字列が不正である可能性があります。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI008");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI009]
     *
     * [リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内においてパラメータの指定が({3})個ありますが、これまで現れていた文字列にはパラメータの指定がありませんでした。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI009]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi009(final String arg0, final String arg1, final String arg2, final String arg3) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内においてパラメータの指定が({3})個ありますが、これまで現れていた文字列にはパラメータの指定がありませんでした。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI009");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI010]
     *
     * [リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内においてパラメータの指定がありませんが、これまで現れていた文字列には({3})個のパラメータの指定がありました。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI010]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi010(final String arg0, final String arg1, final String arg2, final String arg3) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内においてパラメータの指定がありませんが、これまで現れていた文字列には({3})個のパラメータの指定がありました。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI010");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI011]
     *
     * [リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内におけるパラメータの数({3})が、これまで現れていたパラメータの数({4})と一致しません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @param arg4 置換文字列{4}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI011]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi011(final String arg0, final String arg1, final String arg2, final String arg3, final String arg4) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内におけるパラメータの数({3})が、これまで現れていたパラメータの数({4})と一致しません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI011");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3, arg4}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBI012]
     *
     * [リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内におけるパラメータの型({3})が、これまで現れていたパラメータの型({4})と一致しません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @param arg4 置換文字列{4}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBI012]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrbi012(final String arg0, final String arg1, final String arg2, final String arg3, final String arg4) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リソースバンドル定義[{0}]のロケール[{1}]のリソースID[{2}]のメッセージ内におけるパラメータの型({3})が、これまで現れていたパラメータの型({4})と一致しません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBI012");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3, arg4}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoResourceBundleMessage], key[MBRBA001]
     *
     * [指定のmetadir[{0}]が見つかりません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[MBRBA001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMbrba001(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "指定のmetadir[{0}]が見つかりません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MBRBA001");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }
}
