/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.resourcebundle.task.valueobject;

/**
 * 処理クラス [BlancoResourceBundleProcess]の入力バリューオブジェクトクラスです。
 */
public class BlancoResourceBundleProcessInput {
    /**
     * verboseモードで動作させるかどうか。
     *
     * フィールド: [verbose]。
     * デフォルト: [false]。
     */
    private boolean fVerbose = false;

    /**
     * メタディレクトリ
     *
     * フィールド: [metadir]。
     */
    private String fMetadir;

    /**
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。
     *
     * フィールド: [targetdir]。
     * デフォルト: [blanco]。
     */
    private String fTargetdir = "blanco";

    /**
     * テンポラリフォルダを指定します。無指定の場合には、カレント直下のtmpを用います。
     *
     * フィールド: [tmpdir]。
     * デフォルト: [tmp]。
     */
    private String fTmpdir = "tmp";

    /**
     * 自動生成するソースファイルの文字エンコーディングを指定します。
     *
     * フィールド: [encoding]。
     */
    private String fEncoding;

    /**
     * プロパティファイルの生成時刻について、プロパティファイルのコメントに出力するかどうかフラグ。
     *
     * フィールド: [commenttimestamp]。
     * デフォルト: [true]。
     */
    private boolean fCommenttimestamp = true;

    /**
     * リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグ。trueなら処理中断して例外を発生させます。falseなら処理続行し、置換文字列は無いものとみなします。Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。
     *
     * フィールド: [failonmessageformaterror]。
     * デフォルト: [true]。
     */
    private boolean fFailonmessageformaterror = true;

    /**
     * ログ出力を自動生成されるソースコードに含めるかどうかのフラグ。出力する場合には java.util.logging.Loggerのみに対応。
     *
     * フィールド: [log]。
     * デフォルト: [false]。
     */
    private boolean fLog = false;

    /**
     * プロパティファイルをディレクトリ付きで出力するかどうかのフラグ。
     *
     * フィールド: [propertieswithdirectory]。
     * デフォルト: [true]。
     */
    private boolean fPropertieswithdirectory = true;

    /**
     * フィールド [verbose] の値を設定します。
     *
     * フィールドの説明: [verboseモードで動作させるかどうか。]。
     *
     * @param argVerbose フィールド[verbose]に設定する値。
     */
    public void setVerbose(final boolean argVerbose) {
        fVerbose = argVerbose;
    }

    /**
     * フィールド [verbose] の値を取得します。
     *
     * フィールドの説明: [verboseモードで動作させるかどうか。]。
     * デフォルト: [false]。
     *
     * @return フィールド[verbose]から取得した値。
     */
    public boolean getVerbose() {
        return fVerbose;
    }

    /**
     * フィールド [metadir] の値を設定します。
     *
     * フィールドの説明: [メタディレクトリ]。
     *
     * @param argMetadir フィールド[metadir]に設定する値。
     */
    public void setMetadir(final String argMetadir) {
        fMetadir = argMetadir;
    }

    /**
     * フィールド [metadir] の値を取得します。
     *
     * フィールドの説明: [メタディレクトリ]。
     *
     * @return フィールド[metadir]から取得した値。
     */
    public String getMetadir() {
        return fMetadir;
    }

    /**
     * フィールド [targetdir] の値を設定します。
     *
     * フィールドの説明: [出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。]。
     *
     * @param argTargetdir フィールド[targetdir]に設定する値。
     */
    public void setTargetdir(final String argTargetdir) {
        fTargetdir = argTargetdir;
    }

    /**
     * フィールド [targetdir] の値を取得します。
     *
     * フィールドの説明: [出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。]。
     * デフォルト: [blanco]。
     *
     * @return フィールド[targetdir]から取得した値。
     */
    public String getTargetdir() {
        return fTargetdir;
    }

    /**
     * フィールド [tmpdir] の値を設定します。
     *
     * フィールドの説明: [テンポラリフォルダを指定します。無指定の場合には、カレント直下のtmpを用います。]。
     *
     * @param argTmpdir フィールド[tmpdir]に設定する値。
     */
    public void setTmpdir(final String argTmpdir) {
        fTmpdir = argTmpdir;
    }

    /**
     * フィールド [tmpdir] の値を取得します。
     *
     * フィールドの説明: [テンポラリフォルダを指定します。無指定の場合には、カレント直下のtmpを用います。]。
     * デフォルト: [tmp]。
     *
     * @return フィールド[tmpdir]から取得した値。
     */
    public String getTmpdir() {
        return fTmpdir;
    }

    /**
     * フィールド [encoding] の値を設定します。
     *
     * フィールドの説明: [自動生成するソースファイルの文字エンコーディングを指定します。]。
     *
     * @param argEncoding フィールド[encoding]に設定する値。
     */
    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    /**
     * フィールド [encoding] の値を取得します。
     *
     * フィールドの説明: [自動生成するソースファイルの文字エンコーディングを指定します。]。
     *
     * @return フィールド[encoding]から取得した値。
     */
    public String getEncoding() {
        return fEncoding;
    }

    /**
     * フィールド [commenttimestamp] の値を設定します。
     *
     * フィールドの説明: [プロパティファイルの生成時刻について、プロパティファイルのコメントに出力するかどうかフラグ。]。
     *
     * @param argCommenttimestamp フィールド[commenttimestamp]に設定する値。
     */
    public void setCommenttimestamp(final boolean argCommenttimestamp) {
        fCommenttimestamp = argCommenttimestamp;
    }

    /**
     * フィールド [commenttimestamp] の値を取得します。
     *
     * フィールドの説明: [プロパティファイルの生成時刻について、プロパティファイルのコメントに出力するかどうかフラグ。]。
     * デフォルト: [true]。
     *
     * @return フィールド[commenttimestamp]から取得した値。
     */
    public boolean getCommenttimestamp() {
        return fCommenttimestamp;
    }

    /**
     * フィールド [failonmessageformaterror] の値を設定します。
     *
     * フィールドの説明: [リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグ。trueなら処理中断して例外を発生させます。falseなら処理続行し、置換文字列は無いものとみなします。Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。]。
     *
     * @param argFailonmessageformaterror フィールド[failonmessageformaterror]に設定する値。
     */
    public void setFailonmessageformaterror(final boolean argFailonmessageformaterror) {
        fFailonmessageformaterror = argFailonmessageformaterror;
    }

    /**
     * フィールド [failonmessageformaterror] の値を取得します。
     *
     * フィールドの説明: [リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグ。trueなら処理中断して例外を発生させます。falseなら処理続行し、置換文字列は無いものとみなします。Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。]。
     * デフォルト: [true]。
     *
     * @return フィールド[failonmessageformaterror]から取得した値。
     */
    public boolean getFailonmessageformaterror() {
        return fFailonmessageformaterror;
    }

    /**
     * フィールド [log] の値を設定します。
     *
     * フィールドの説明: [ログ出力を自動生成されるソースコードに含めるかどうかのフラグ。出力する場合には java.util.logging.Loggerのみに対応。]。
     *
     * @param argLog フィールド[log]に設定する値。
     */
    public void setLog(final boolean argLog) {
        fLog = argLog;
    }

    /**
     * フィールド [log] の値を取得します。
     *
     * フィールドの説明: [ログ出力を自動生成されるソースコードに含めるかどうかのフラグ。出力する場合には java.util.logging.Loggerのみに対応。]。
     * デフォルト: [false]。
     *
     * @return フィールド[log]から取得した値。
     */
    public boolean getLog() {
        return fLog;
    }

    /**
     * フィールド [propertieswithdirectory] の値を設定します。
     *
     * フィールドの説明: [プロパティファイルをディレクトリ付きで出力するかどうかのフラグ。]。
     *
     * @param argPropertieswithdirectory フィールド[propertieswithdirectory]に設定する値。
     */
    public void setPropertieswithdirectory(final boolean argPropertieswithdirectory) {
        fPropertieswithdirectory = argPropertieswithdirectory;
    }

    /**
     * フィールド [propertieswithdirectory] の値を取得します。
     *
     * フィールドの説明: [プロパティファイルをディレクトリ付きで出力するかどうかのフラグ。]。
     * デフォルト: [true]。
     *
     * @return フィールド[propertieswithdirectory]から取得した値。
     */
    public boolean getPropertieswithdirectory() {
        return fPropertieswithdirectory;
    }

    /**
     * このバリューオブジェクトの文字列表現を取得します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ文字列化の処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @return バリューオブジェクトの文字列表現。
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.resourcebundle.task.valueobject.BlancoResourceBundleProcessInput[");
        buf.append("verbose=" + fVerbose);
        buf.append(",metadir=" + fMetadir);
        buf.append(",targetdir=" + fTargetdir);
        buf.append(",tmpdir=" + fTmpdir);
        buf.append(",encoding=" + fEncoding);
        buf.append(",commenttimestamp=" + fCommenttimestamp);
        buf.append(",failonmessageformaterror=" + fFailonmessageformaterror);
        buf.append(",log=" + fLog);
        buf.append(",propertieswithdirectory=" + fPropertieswithdirectory);
        buf.append("]");
        return buf.toString();
    }
}
