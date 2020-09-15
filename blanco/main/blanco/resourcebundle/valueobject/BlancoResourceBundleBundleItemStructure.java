package blanco.resourcebundle.valueobject;

import java.util.List;

/**
 * リソースバンドルのキー＋値をあらわす構造体クラス。キー値と文字列を含みます。
 */
public class BlancoResourceBundleBundleItemStructure {
    /**
     * 項目番号。
     *
     * フィールド: [no]。
     */
    private String fNo;

    /**
     * リソースバンドル上のキー値。
     *
     * フィールド: [key]。
     */
    private String fKey;

    /**
     * リソース文字列のリスト。BlancoResourceBundleBundleResourceStringStructureクラスのインスタンスがリストで格納されます。非Combineの場合には、MAX１件が含まれます。Combineの場合には、ロケールごとに１件。
     *
     * フィールド: [resourceStringList]。
     * デフォルト: [new java.util.ArrayList&lt;blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure&gt;()]。
     */
    private List<blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure> fResourceStringList = new java.util.ArrayList<blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure>();

    /**
     * フィールド [no] の値を設定します。
     *
     * フィールドの説明: [項目番号。]。
     *
     * @param argNo フィールド[no]に設定する値。
     */
    public void setNo(final String argNo) {
        fNo = argNo;
    }

    /**
     * フィールド [no] の値を取得します。
     *
     * フィールドの説明: [項目番号。]。
     *
     * @return フィールド[no]から取得した値。
     */
    public String getNo() {
        return fNo;
    }

    /**
     * フィールド [key] の値を設定します。
     *
     * フィールドの説明: [リソースバンドル上のキー値。]。
     *
     * @param argKey フィールド[key]に設定する値。
     */
    public void setKey(final String argKey) {
        fKey = argKey;
    }

    /**
     * フィールド [key] の値を取得します。
     *
     * フィールドの説明: [リソースバンドル上のキー値。]。
     *
     * @return フィールド[key]から取得した値。
     */
    public String getKey() {
        return fKey;
    }

    /**
     * フィールド [resourceStringList] の値を設定します。
     *
     * フィールドの説明: [リソース文字列のリスト。BlancoResourceBundleBundleResourceStringStructureクラスのインスタンスがリストで格納されます。非Combineの場合には、MAX１件が含まれます。Combineの場合には、ロケールごとに１件。]。
     *
     * @param argResourceStringList フィールド[resourceStringList]に設定する値。
     */
    public void setResourceStringList(final List<blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure> argResourceStringList) {
        fResourceStringList = argResourceStringList;
    }

    /**
     * フィールド [resourceStringList] の値を取得します。
     *
     * フィールドの説明: [リソース文字列のリスト。BlancoResourceBundleBundleResourceStringStructureクラスのインスタンスがリストで格納されます。非Combineの場合には、MAX１件が含まれます。Combineの場合には、ロケールごとに１件。]。
     * デフォルト: [new java.util.ArrayList&lt;blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure&gt;()]。
     *
     * @return フィールド[resourceStringList]から取得した値。
     */
    public List<blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure> getResourceStringList() {
        return fResourceStringList;
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
        buf.append("blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure[");
        buf.append("no=" + fNo);
        buf.append(",key=" + fKey);
        buf.append(",resourceStringList=" + fResourceStringList);
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
    public void copyTo(final BlancoResourceBundleBundleItemStructure target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: BlancoResourceBundleBundleItemStructure#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fNo
        // Type: java.lang.String
        target.fNo = this.fNo;
        // Name: fKey
        // Type: java.lang.String
        target.fKey = this.fKey;
        // Name: fResourceStringList
        // Type: java.util.List
        if (this.fResourceStringList != null) {
            final java.util.Iterator<blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure> iterator = this.fResourceStringList.iterator();
            for (; iterator.hasNext();) {
                blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure loopSource = iterator.next();
                blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure loopTarget = null;
                // フィールド[generics]はサポート外の型[blanco.resourcebundle.valueobject.BlancoResourceBundleBundleResourceStringStructure]です。
                target.fResourceStringList.add(loopTarget);
            }
        }
    }
}
