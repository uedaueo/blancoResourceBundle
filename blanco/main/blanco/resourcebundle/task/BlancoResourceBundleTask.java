/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.resourcebundle.task;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import blanco.resourcebundle.task.valueobject.BlancoResourceBundleProcessInput;

/**
 * Apache Antタスク [BlancoResourceBundle]のクラス。
 *
 * BlancoResourceBundleのAntTaskです。<br>
 * このクラスでは、Apache Antタスクで一般的に必要なチェックなどのコーディングを肩代わりします。
 * 実際の処理は パッケージ[blanco.resourcebundle.task]にBlancoResourceBundleBatchProcessクラスを作成して記述してください。<br>
 * <br>
 * Antタスクへの組み込み例<br>
 * <pre>
 * &lt;taskdef name=&quot;blancoresourcebundle&quot; classname=&quot;blanco.resourcebundle.task.BlancoResourceBundleTask">
 *     &lt;classpath&gt;
 *         &lt;fileset dir=&quot;lib&quot; includes=&quot;*.jar&quot; /&gt;
 *         &lt;fileset dir=&quot;lib.ant&quot; includes=&quot;*.jar&quot; /&gt;
 *     &lt;/classpath&gt;
 * &lt;/taskdef&gt;
 * </pre>
 */
public class BlancoResourceBundleTask extends Task {
    /**
     * BlancoResourceBundleのAntTaskです。
     */
    protected BlancoResourceBundleProcessInput fInput = new BlancoResourceBundleProcessInput();

    /**
     * フィールド [metadir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldMetadirProcessed = false;

    /**
     * フィールド [targetdir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTargetdirProcessed = false;

    /**
     * フィールド [tmpdir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTmpdirProcessed = false;

    /**
     * フィールド [encoding] に値がセットされたかどうか。
     */
    protected boolean fIsFieldEncodingProcessed = false;

    /**
     * フィールド [commenttimestamp] に値がセットされたかどうか。
     */
    protected boolean fIsFieldCommenttimestampProcessed = false;

    /**
     * フィールド [failonmessageformaterror] に値がセットされたかどうか。
     */
    protected boolean fIsFieldFailonmessageformaterrorProcessed = false;

    /**
     * フィールド [log] に値がセットされたかどうか。
     */
    protected boolean fIsFieldLogProcessed = false;

    /**
     * フィールド [propertieswithdirectory] に値がセットされたかどうか。
     */
    protected boolean fIsFieldPropertieswithdirectoryProcessed = false;

    /**
     * verboseモードで動作させるかどうか。
     *
     * @param arg verboseモードで動作させるかどうか。
     */
    public void setVerbose(final boolean arg) {
        fInput.setVerbose(arg);
    }

    /**
     * verboseモードで動作させるかどうか。
     *
     * @return verboseモードで動作させるかどうか。
     */
    public boolean getVerbose() {
        return fInput.getVerbose();
    }

    /**
     * Antタスクの[metadir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 1<br>
     * メタディレクトリ<br>
     *
     * @param arg セットしたい値
     */
    public void setMetadir(final String arg) {
        fInput.setMetadir(arg);
        fIsFieldMetadirProcessed = true;
    }

    /**
     * Antタスクの[metadir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 1<br>
     * メタディレクトリ<br>
     * 必須アトリビュートです。Apache Antタスク上で必ず値が指定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getMetadir() {
        return fInput.getMetadir();
    }

    /**
     * Antタスクの[targetdir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 2<br>
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。<br>
     *
     * @param arg セットしたい値
     */
    public void setTargetdir(final String arg) {
        fInput.setTargetdir(arg);
        fIsFieldTargetdirProcessed = true;
    }

    /**
     * Antタスクの[targetdir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 2<br>
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。<br>
     * デフォルト値[blanco]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTargetdir() {
        return fInput.getTargetdir();
    }

    /**
     * Antタスクの[tmpdir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 3<br>
     * テンポラリフォルダを指定します。無指定の場合には、カレント直下のtmpを用います。<br>
     *
     * @param arg セットしたい値
     */
    public void setTmpdir(final String arg) {
        fInput.setTmpdir(arg);
        fIsFieldTmpdirProcessed = true;
    }

    /**
     * Antタスクの[tmpdir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 3<br>
     * テンポラリフォルダを指定します。無指定の場合には、カレント直下のtmpを用います。<br>
     * デフォルト値[tmp]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTmpdir() {
        return fInput.getTmpdir();
    }

    /**
     * Antタスクの[encoding]アトリビュートのセッターメソッド。
     *
     * 項目番号: 4<br>
     * 自動生成するソースファイルの文字エンコーディングを指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setEncoding(final String arg) {
        fInput.setEncoding(arg);
        fIsFieldEncodingProcessed = true;
    }

    /**
     * Antタスクの[encoding]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 4<br>
     * 自動生成するソースファイルの文字エンコーディングを指定します。<br>
     *
     * @return このフィールドの値
     */
    public String getEncoding() {
        return fInput.getEncoding();
    }

    /**
     * Antタスクの[commenttimestamp]アトリビュートのセッターメソッド。
     *
     * 項目番号: 5<br>
     * プロパティファイルの生成時刻について、プロパティファイルのコメントに出力するかどうかフラグ。<br>
     *
     * @param arg セットしたい値
     */
    public void setCommenttimestamp(final boolean arg) {
        fInput.setCommenttimestamp(arg);
        fIsFieldCommenttimestampProcessed = true;
    }

    /**
     * Antタスクの[commenttimestamp]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 5<br>
     * プロパティファイルの生成時刻について、プロパティファイルのコメントに出力するかどうかフラグ。<br>
     * デフォルト値[true]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public boolean getCommenttimestamp() {
        return fInput.getCommenttimestamp();
    }

    /**
     * Antタスクの[failonmessageformaterror]アトリビュートのセッターメソッド。
     *
     * 項目番号: 6<br>
     * リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグ。trueなら処理中断して例外を発生させます。falseなら処理続行し、置換文字列は無いものとみなします。Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。<br>
     *
     * @param arg セットしたい値
     */
    public void setFailonmessageformaterror(final boolean arg) {
        fInput.setFailonmessageformaterror(arg);
        fIsFieldFailonmessageformaterrorProcessed = true;
    }

    /**
     * Antタスクの[failonmessageformaterror]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 6<br>
     * リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグ。trueなら処理中断して例外を発生させます。falseなら処理続行し、置換文字列は無いものとみなします。Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。<br>
     * デフォルト値[true]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public boolean getFailonmessageformaterror() {
        return fInput.getFailonmessageformaterror();
    }

    /**
     * Antタスクの[log]アトリビュートのセッターメソッド。
     *
     * 項目番号: 7<br>
     * ログ出力を自動生成されるソースコードに含めるかどうかのフラグ。出力する場合には java.util.logging.Loggerのみに対応。<br>
     *
     * @param arg セットしたい値
     */
    public void setLog(final boolean arg) {
        fInput.setLog(arg);
        fIsFieldLogProcessed = true;
    }

    /**
     * Antタスクの[log]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 7<br>
     * ログ出力を自動生成されるソースコードに含めるかどうかのフラグ。出力する場合には java.util.logging.Loggerのみに対応。<br>
     * デフォルト値[false]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public boolean getLog() {
        return fInput.getLog();
    }

    /**
     * Antタスクの[propertieswithdirectory]アトリビュートのセッターメソッド。
     *
     * 項目番号: 8<br>
     * プロパティファイルをディレクトリ付きで出力するかどうかのフラグ。<br>
     *
     * @param arg セットしたい値
     */
    public void setPropertieswithdirectory(final boolean arg) {
        fInput.setPropertieswithdirectory(arg);
        fIsFieldPropertieswithdirectoryProcessed = true;
    }

    /**
     * Antタスクの[propertieswithdirectory]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 8<br>
     * プロパティファイルをディレクトリ付きで出力するかどうかのフラグ。<br>
     * デフォルト値[true]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public boolean getPropertieswithdirectory() {
        return fInput.getPropertieswithdirectory();
    }

    /**
     * Antタスクのメイン処理。Apache Antから このメソッドが呼び出されます。
     *
     * @throws BuildException タスクとしての例外が発生した場合。
     */
    @Override
    public final void execute() throws BuildException {
        System.out.println("BlancoResourceBundleTask begin.");

        // 項目番号[1]、アトリビュート[metadir]は必須入力です。入力チェックを行います。
        if (fIsFieldMetadirProcessed == false) {
            throw new BuildException("必須アトリビュート[metadir]が設定されていません。処理を中断します。");
        }

        if (getVerbose()) {
            System.out.println("- verbose:[true]");
            System.out.println("- metadir:[" + getMetadir() + "]");
            System.out.println("- targetdir:[" + getTargetdir() + "]");
            System.out.println("- tmpdir:[" + getTmpdir() + "]");
            System.out.println("- encoding:[" + getEncoding() + "]");
            System.out.println("- commenttimestamp:[" + getCommenttimestamp() + "]");
            System.out.println("- failonmessageformaterror:[" + getFailonmessageformaterror() + "]");
            System.out.println("- log:[" + getLog() + "]");
            System.out.println("- propertieswithdirectory:[" + getPropertieswithdirectory() + "]");
        }

        try {
            // 実際のAntタスクの主処理を実行します。
            // この箇所でコンパイルエラーが発生する場合、BlancoResourceBundleProcessインタフェースを実装して blanco.resourcebundle.taskパッケージに BlancoResourceBundleProcessImplクラスを作成することにより解決できる場合があります。
            final BlancoResourceBundleProcess proc = new BlancoResourceBundleProcessImpl();
            if (proc.execute(fInput) != BlancoResourceBundleBatchProcess.END_SUCCESS) {
                throw new BuildException("タスクは異常終了しました。");
            }
        } catch (IllegalArgumentException e) {
            if (getVerbose()) {
                e.printStackTrace();
            }
            throw new BuildException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("タスクを処理中に例外が発生しました。処理を中断します。" + e.toString());
        } catch (Error e) {
            e.printStackTrace();
            throw new BuildException("タスクを処理中にエラーが発生しました。処理を中断します。" + e.toString());
        }
    }
}
