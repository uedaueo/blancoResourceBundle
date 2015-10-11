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

import java.text.Format;
import java.text.MessageFormat;

public class BlancoResourceBundleUtil {
    /**
     * MessageFormatからフォーマット情報を取得します。
     * 
     * このメソッドは blancoResourceBundle以外に blancoMessageから利用されています。
     * 
     * @param argResourceString
     *            リソース文字列
     * @param argIsFailOnMessageFormatError
     *            MessageFormatとしてパースした場合にエラーとして扱うかどうか。
     * @return 解析後のフォーマット配列。
     */
    public static final Format[] getFormatsByArgumentIndex(
            final String argResourceString,
            final boolean argIsFailOnMessageFormatError) {
        try {
            final MessageFormat messageFormat = new MessageFormat(
                    argResourceString);
            return messageFormat.getFormatsByArgumentIndex();

        } catch (IllegalArgumentException ex) {
            if (argIsFailOnMessageFormatError) {
                throw ex;
            }

            // エラーを無視して、何事もなかったかのごとく振舞います。
            return new Format[0];
        }
    }
}
