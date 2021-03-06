package blanco.resourcebundle.valueobject;

/**
 * リソースバンドルのロケール＋文字列をあらわす構造体クラス。
 */
public class BlancoResourceBundleBundleResourceStringStructure {
    /**
     * ロケール。
     *
     * フィールド: [locale]。
     */
    private String fLocale;

    /**
     * リソース文字列。
     *
     * フィールド: [resourceString]。
     */
    private String fResourceString;

    /**
     * フィールド [locale] の値を設定します。
     *
     * フィールドの説明: [ロケール。]。
     *
     * @param argLocale フィールド[locale]に設定する値。
     */
    public void setLocale(final String argLocale) {
        fLocale = argLocale;
    }

    /**
     * フィールド [locale] の値を取得します。
     *
     * フィールドの説明: [ロケール。]。
     *
     * @return フィールド[locale]から取得した値。
     */
    public String getLocale() {
        return fLocale;
    }

    /**
     * フィールド [resourceString] の値を設定します。
     *
     * フィールドの説明: [リソース文字列。]。
     *
     * @param argResourceString フィールド[resourceString]に設定する値。
     */
    public void setResourceString(final String argResourceString) {
        fResourceString = argResourceString;
    }

    /**
     * フィールド [resourceString] の値を取得します。
     *
     * フィールドの説明: [リソース文字列。]。
     *
     * @return フィールド[resourceString]から取得した値。
     */
    public String getResourceString() {
        return fResourceString;
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
        buf.append("blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure[");
        buf.append("locale=" + fLocale);
        buf.append(",resourceString=" + fResourceString);
        buf.append("]");
        return buf.toString();
    }

    /**
     * このバリューオブジェクトを指定のターゲットに複写します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ複写処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @param target target value object.
     */
    public void copyTo(final BlancoResourceBundleBundleResourceStringStructure target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: BlancoResourceBundleBundleResourceStringStructure#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fLocale
        // Type: java.lang.String
        target.fLocale = this.fLocale;
        // Name: fResourceString
        // Type: java.lang.String
        target.fResourceString = this.fResourceString;
    }
}
