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

import blanco.resourcebundle.expand.BlancoResourceBundleExpandResourceBundle;
import blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure;

/**
 * 中間XMLファイルから プロパティファイルアクセス用のJavaソースコードを生成します。
 * 
 * このソースコードはblancoResourceBundleの一部です。<br>
 * 
 * @author IGA Tosiki
 */
public class BlancoResourceBundleXml2JavaClass {
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
     * ログ出力を自動生成されるソースコードに含めるかどうかのフラグ。現在は標準出力のみに対応。
     */
    private boolean fIsLog = false;

    /**
     * プロパティファイルをディレクトリ付きで出力するかどうか。
     */
    private boolean fPropertieswithdirectory = true;

    /**
     * 自動生成するソースファイルの文字エンコーディング。
     */
    private String fEncoding = null;

    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    /**
     * リソースバンドル文字列をMessageFormatによるパースを行った際に、例外が発生したら処理を中断するかどうかのフラグを設定します。
     * 
     * trueなら処理中断して例外を発生させます。<br>
     * falseなら処理続行し、置換文字列は無いものとみなします。<br>
     * Javaのソースコードを処理する際などに、あえて falseに設定して波括弧を扱うことができるように切り替える場合があります。<br>
     * デフォルト値[true]が設定されています。
     * 
     * @param isFailOnMessageFormatError
     */
    public void setFailOnMessageFormatError(
            final boolean isFailOnMessageFormatError) {
        fIsFailOnMessageFormatError = isFailOnMessageFormatError;
    }

    /**
     * ログ出力を自動生成されるソースコードに含めるかどうかのフラグのセット。
     * 
     * @param argIsLog
     *            ログ出力を自動生成されるソースコードに含めるかどうか。
     */
    public void setLog(final boolean argIsLog) {
        fIsLog = argIsLog;
    }

    /**
     * プロパティファイルをディレクトリ付きで出力するかどうかのフラグをセットします。
     * 
     * @param isPropertieswithdirectory
     *            プロパティファイルをディレクトリ付きで出力するかどうか。
     */
    public void setPropertieswithdirectory(
            final boolean isPropertieswithdirectory) {
        fPropertieswithdirectory = isPropertieswithdirectory;
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
        final BlancoResourceBundleBundleStructure[] structures = new BlancoResourceBundleXmlParser()
                .parse(argFileSource);
        for (int index = 0; index < structures.length; index++) {
            structure2Source(structures[index], argDirectoryTarget);
        }
    }

    /**
     * 指定のシートの記述内容を展開します。
     * 
     * @param argStructure
     *            タスクの構造。
     * @param argDirectoryTarget
     *            出力先ディレクトリ
     */
    public void structure2Source(
            final BlancoResourceBundleBundleStructure argStructure,
            final File argDirectoryTarget) {
        new BlancoResourceBundleExpandResourceBundle().expand(argStructure,
                argDirectoryTarget, fEncoding, fIsFailOnMessageFormatError,
                fIsLog, fPropertieswithdirectory);
    }
}