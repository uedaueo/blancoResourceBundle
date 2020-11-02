package blanco.resourcebundle.valueobject;

import java.util.List;

/**
 * リソースバンドルをあらわす構造体クラス。基底名やパッケージなど基本情報が含まれます。
 */
public class BlancoResourceBundleBundleStructure {
    /**
     * リソースバンドルの基底名。
     *
     * フィールド: [name]。
     */
    private String fName;

    /**
     * このリソースバンドルが対応するロケールの一覧。(Combine後の場合にのみ有効)
     *
     * フィールド: [listLocale]。
     * デフォルト: [new java.util.ArrayList&lt;java.lang.String&gt;()]。
     */
    private List<String> fListLocale = new java.util.ArrayList<java.lang.String>();

    /**
     * パッケージ名。
     *
     * フィールド: [package]。
     */
    private String fPackage;

    /**
     * クラスに付与されるサフィックス。
     *
     * フィールド: [suffix]。
     */
    private String fSuffix;

    /**
     * クラスのアノテーションを指定します。
     *
     * フィールド: [annotationList]。
     * デフォルト: [new java.util.ArrayList&lt;java.lang.String&gt;()]。
     */
    private List<String> fAnnotationList = new java.util.ArrayList<java.lang.String>();

    /**
     * importを指定します。
     *
     * フィールド: [importList]。
     * デフォルト: [new java.util.ArrayList&lt;java.lang.String&gt;()]。
     */
    private List<String> fImportList = new java.util.ArrayList<java.lang.String>();

    /**
     * このリソースバンドルに対する説明。
     *
     * フィールド: [description]。
     */
    private String fDescription;

    /**
     * このクラスのアクセス。基本的には public で利用します。
     *
     * フィールド: [access]。
     * デフォルト: [&quot;public&quot;]。
     */
    private String fAccess = "public";

    /**
     * 各キー＋値の情報。
     *
     * フィールド: [itemList]。
     * デフォルト: [new java.util.ArrayList&lt;blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure&gt;()]。
     */
    private List<BlancoResourceBundleBundleItemStructure> fItemList = new java.util.ArrayList<blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure>();

    /**
     * ワークに利用されるフィールド。
     *
     * フィールド: [resourceItem]。
     */
    private BlancoResourceBundleBundleItemStructure fResourceItem;

    /**
     * 現在処理しているロケールを記憶します。
     *
     * フィールド: [currentLocale]。
     */
    private String fCurrentLocale;

    /**
     * 現在処理しているリソース文字列を記憶します。
     *
     * フィールド: [currentResourceString]。
     */
    private String fCurrentResourceString;

    /**
     * ワークに利用されるフィールド。
     *
     * フィールド: [annotation]。
     * デフォルト: [&quot;&quot;]。
     */
    private String fAnnotation = "";

    /**
     * フィールド [name] の値を設定します。
     *
     * フィールドの説明: [リソースバンドルの基底名。]。
     *
     * @param argName フィールド[name]に設定する値。
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * フィールド [name] の値を取得します。
     *
     * フィールドの説明: [リソースバンドルの基底名。]。
     *
     * @return フィールド[name]から取得した値。
     */
    public String getName() {
        return fName;
    }

    /**
     * フィールド [listLocale] の値を設定します。
     *
     * フィールドの説明: [このリソースバンドルが対応するロケールの一覧。(Combine後の場合にのみ有効)]。
     *
     * @param argListLocale フィールド[listLocale]に設定する値。
     */
    public void setListLocale(final List<String> argListLocale) {
        fListLocale = argListLocale;
    }

    /**
     * フィールド [listLocale] の値を取得します。
     *
     * フィールドの説明: [このリソースバンドルが対応するロケールの一覧。(Combine後の場合にのみ有効)]。
     * デフォルト: [new java.util.ArrayList&lt;java.lang.String&gt;()]。
     *
     * @return フィールド[listLocale]から取得した値。
     */
    public List<String> getListLocale() {
        return fListLocale;
    }

    /**
     * フィールド [package] の値を設定します。
     *
     * フィールドの説明: [パッケージ名。]。
     *
     * @param argPackage フィールド[package]に設定する値。
     */
    public void setPackage(final String argPackage) {
        fPackage = argPackage;
    }

    /**
     * フィールド [package] の値を取得します。
     *
     * フィールドの説明: [パッケージ名。]。
     *
     * @return フィールド[package]から取得した値。
     */
    public String getPackage() {
        return fPackage;
    }

    /**
     * フィールド [suffix] の値を設定します。
     *
     * フィールドの説明: [クラスに付与されるサフィックス。]。
     *
     * @param argSuffix フィールド[suffix]に設定する値。
     */
    public void setSuffix(final String argSuffix) {
        fSuffix = argSuffix;
    }

    /**
     * フィールド [suffix] の値を取得します。
     *
     * フィールドの説明: [クラスに付与されるサフィックス。]。
     *
     * @return フィールド[suffix]から取得した値。
     */
    public String getSuffix() {
        return fSuffix;
    }

    /**
     * フィールド [annotationList] の値を設定します。
     *
     * フィールドの説明: [クラスのアノテーションを指定します。]。
     *
     * @param argAnnotationList フィールド[annotationList]に設定する値。
     */
    public void setAnnotationList(final List<String> argAnnotationList) {
        fAnnotationList = argAnnotationList;
    }

    /**
     * フィールド [annotationList] の値を取得します。
     *
     * フィールドの説明: [クラスのアノテーションを指定します。]。
     * デフォルト: [new java.util.ArrayList&lt;java.lang.String&gt;()]。
     *
     * @return フィールド[annotationList]から取得した値。
     */
    public List<String> getAnnotationList() {
        return fAnnotationList;
    }

    /**
     * フィールド [importList] の値を設定します。
     *
     * フィールドの説明: [importを指定します。]。
     *
     * @param argImportList フィールド[importList]に設定する値。
     */
    public void setImportList(final List<String> argImportList) {
        fImportList = argImportList;
    }

    /**
     * フィールド [importList] の値を取得します。
     *
     * フィールドの説明: [importを指定します。]。
     * デフォルト: [new java.util.ArrayList&lt;java.lang.String&gt;()]。
     *
     * @return フィールド[importList]から取得した値。
     */
    public List<String> getImportList() {
        return fImportList;
    }

    /**
     * フィールド [description] の値を設定します。
     *
     * フィールドの説明: [このリソースバンドルに対する説明。]。
     *
     * @param argDescription フィールド[description]に設定する値。
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * フィールド [description] の値を取得します。
     *
     * フィールドの説明: [このリソースバンドルに対する説明。]。
     *
     * @return フィールド[description]から取得した値。
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * フィールド [access] の値を設定します。
     *
     * フィールドの説明: [このクラスのアクセス。基本的には public で利用します。]。
     *
     * @param argAccess フィールド[access]に設定する値。
     */
    public void setAccess(final String argAccess) {
        fAccess = argAccess;
    }

    /**
     * フィールド [access] の値を取得します。
     *
     * フィールドの説明: [このクラスのアクセス。基本的には public で利用します。]。
     * デフォルト: [&quot;public&quot;]。
     *
     * @return フィールド[access]から取得した値。
     */
    public String getAccess() {
        return fAccess;
    }

    /**
     * フィールド [itemList] の値を設定します。
     *
     * フィールドの説明: [各キー＋値の情報。]。
     *
     * @param argItemList フィールド[itemList]に設定する値。
     */
    public void setItemList(final List<BlancoResourceBundleBundleItemStructure> argItemList) {
        fItemList = argItemList;
    }

    /**
     * フィールド [itemList] の値を取得します。
     *
     * フィールドの説明: [各キー＋値の情報。]。
     * デフォルト: [new java.util.ArrayList&lt;blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure&gt;()]。
     *
     * @return フィールド[itemList]から取得した値。
     */
    public List<BlancoResourceBundleBundleItemStructure> getItemList() {
        return fItemList;
    }

    /**
     * フィールド [resourceItem] の値を設定します。
     *
     * フィールドの説明: [ワークに利用されるフィールド。]。
     *
     * @param argResourceItem フィールド[resourceItem]に設定する値。
     */
    public void setResourceItem(final BlancoResourceBundleBundleItemStructure argResourceItem) {
        fResourceItem = argResourceItem;
    }

    /**
     * フィールド [resourceItem] の値を取得します。
     *
     * フィールドの説明: [ワークに利用されるフィールド。]。
     *
     * @return フィールド[resourceItem]から取得した値。
     */
    public BlancoResourceBundleBundleItemStructure getResourceItem() {
        return fResourceItem;
    }

    /**
     * フィールド [currentLocale] の値を設定します。
     *
     * フィールドの説明: [現在処理しているロケールを記憶します。]。
     *
     * @param argCurrentLocale フィールド[currentLocale]に設定する値。
     */
    public void setCurrentLocale(final String argCurrentLocale) {
        fCurrentLocale = argCurrentLocale;
    }

    /**
     * フィールド [currentLocale] の値を取得します。
     *
     * フィールドの説明: [現在処理しているロケールを記憶します。]。
     *
     * @return フィールド[currentLocale]から取得した値。
     */
    public String getCurrentLocale() {
        return fCurrentLocale;
    }

    /**
     * フィールド [currentResourceString] の値を設定します。
     *
     * フィールドの説明: [現在処理しているリソース文字列を記憶します。]。
     *
     * @param argCurrentResourceString フィールド[currentResourceString]に設定する値。
     */
    public void setCurrentResourceString(final String argCurrentResourceString) {
        fCurrentResourceString = argCurrentResourceString;
    }

    /**
     * フィールド [currentResourceString] の値を取得します。
     *
     * フィールドの説明: [現在処理しているリソース文字列を記憶します。]。
     *
     * @return フィールド[currentResourceString]から取得した値。
     */
    public String getCurrentResourceString() {
        return fCurrentResourceString;
    }

    /**
     * フィールド [annotation] の値を設定します。
     *
     * フィールドの説明: [ワークに利用されるフィールド。]。
     *
     * @param argAnnotation フィールド[annotation]に設定する値。
     */
    public void setAnnotation(final String argAnnotation) {
        fAnnotation = argAnnotation;
    }

    /**
     * フィールド [annotation] の値を取得します。
     *
     * フィールドの説明: [ワークに利用されるフィールド。]。
     * デフォルト: [&quot;&quot;]。
     *
     * @return フィールド[annotation]から取得した値。
     */
    public String getAnnotation() {
        return fAnnotation;
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
        buf.append("blanco.resourcebundle.valueobject.BlancoResourceBundleBundleStructure[");
        buf.append("name=" + fName);
        buf.append(",listLocale=" + fListLocale);
        buf.append(",package=" + fPackage);
        buf.append(",suffix=" + fSuffix);
        buf.append(",annotationList=" + fAnnotationList);
        buf.append(",importList=" + fImportList);
        buf.append(",description=" + fDescription);
        buf.append(",access=" + fAccess);
        buf.append(",itemList=" + fItemList);
        buf.append(",resourceItem=" + fResourceItem);
        buf.append(",currentLocale=" + fCurrentLocale);
        buf.append(",currentResourceString=" + fCurrentResourceString);
        buf.append(",annotation=" + fAnnotation);
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
    public void copyTo(final BlancoResourceBundleBundleStructure target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: BlancoResourceBundleBundleStructure#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fName
        // Type: java.lang.String
        target.fName = this.fName;
        // Name: fListLocale
        // Type: java.util.List
        // フィールド[fListLocale]はサポート外の型[java.util.Listjava.lang.String]です。
        // Name: fPackage
        // Type: java.lang.String
        target.fPackage = this.fPackage;
        // Name: fSuffix
        // Type: java.lang.String
        target.fSuffix = this.fSuffix;
        // Name: fAnnotationList
        // Type: java.util.List
        // フィールド[fAnnotationList]はサポート外の型[java.util.Listjava.lang.String]です。
        // Name: fImportList
        // Type: java.util.List
        // フィールド[fImportList]はサポート外の型[java.util.Listjava.lang.String]です。
        // Name: fDescription
        // Type: java.lang.String
        target.fDescription = this.fDescription;
        // Name: fAccess
        // Type: java.lang.String
        target.fAccess = this.fAccess;
        // Name: fItemList
        // Type: java.util.List
        // フィールド[fItemList]はサポート外の型[java.util.Listblanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure]です。
        // Name: fResourceItem
        // Type: blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure
        // フィールド[fResourceItem]はサポート外の型[blanco.resourcebundle.valueobject.BlancoResourceBundleBundleItemStructure]です。
        // Name: fCurrentLocale
        // Type: java.lang.String
        target.fCurrentLocale = this.fCurrentLocale;
        // Name: fCurrentResourceString
        // Type: java.lang.String
        target.fCurrentResourceString = this.fCurrentResourceString;
        // Name: fAnnotation
        // Type: java.lang.String
        target.fAnnotation = this.fAnnotation;
    }
}
