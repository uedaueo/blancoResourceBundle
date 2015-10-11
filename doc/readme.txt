blancoResourceBundleは、「リソースバンドル定義書」という *.xlsファイル形式の記述内容にしたがって、
プロパティファイルの自動生成とリソースバンドル入出力をおこなう Javaソースコードの自動生成をおこなうツールです。

blancoResourceBundleを使うと、Excelなどの表計算ソフトを使って「リソースバンドル定義書」に必要項目を記入するだけで下記の効果が得られます。
 1.プロパティファイルを簡単に作成することができます。しかもドキュメント(*.xls)とプロパティファイルが自動的に一致します。
   native2asciiなどのツールは、使う必要が無くなるのです。
 2.Javaソースコード上の文字列の外部化を簡単で安全に実施することができます。
   しかも、Javaアクセサも併せて自動生成されるので、文字列中の置換文字列の置換忘れなどということは機械的に確実に防止できるようになります。
 3.ResourceBundleにまつわる例外処理を気にする必要がなくなります。
   リソースバンドル／プロパティファイルを読み込む際に気にしなくてはならない、いろいろなコーディングの多くは 自動生成された Javaソースコードが肩代わりしてくれます。
   プロパティファイルが見つからない場合ですら、適切に動作するようになるのも魅力的です。

チュートリアルや定義書記入要領などは、下記のURLで入手することができます。
●http://hp.vector.co.jp/authors/VA027994/blanco/blancoresourcebundle.html

なお、自動生成されたソースコードは、それらが独立して動作するようになっています。
ランタイムライブラリなどは必要ありません。

安全で確実なリソースバンドル処理・プロパティファイル処理が必要な方は、ぜひ blancoResourceBundleを試してみてください。
blancoResourceBundleは Eclipseプラグイン形式または Apache Antタスク形式により配布されています。
Eclipseプラグイン形式としても提供されているので、あなたの手元に Eclipse環境一式があれば、プラグインとして登録するだけですぐに使ってみることができます。

利用のおおまかなステップは下記のようになります。
 1.Eclipseプラグインをインストールする。
 2.blancoResourceBundleプラグインを起動する。
 3.blancoResourceBundleプラグインで リソースバンドル定義書(*.xls)ファイルを作成する。
 4.Excelなどの表計算ソフトを使って、リソースバンドル定義書を記入する。
 5.blancoResourceBundleプラグインで ソースコードの自動生成をおこなう。
 6.自動生成されたソースコードを使って リソースバンドルを活用したプログラムを作成する。

[開発者]
 1.伊賀敏樹 (IGA Tosiki / いがぴょん): 開発および維持メンテ担当。
 2.山本耕司 (ymoto) : 全般にわたる仕様検討。リリース判定担当。
 3.岡本隆史 (OKAMOTO Takashi): 仕様検討段階での仕様提案。

[ライセンス]
 1.blancoResourceBundle は ライセンス として GNU Lesser General Public License を採用しています。

[依存するライブラリ]
blancoResourceBundleは下記のライブラリを利用しています。
   ※各オープンソース・プロダクトの提供者に感謝します。
 1.JExcelApi - Java Excel API - A Java API to read, write and modify Excel spreadsheets
     http://jexcelapi.sourceforge.net/
     http://sourceforge.net/projects/jexcelapi/
     http://www.andykhan.com/jexcelapi/ 
   概要: JavaからExcelブック形式を読み書きするためのライブラリです。
   ライセンス: GNU Lesser General Public License
 2.blancoCg
   概要: ソースコード生成ライブラリ
   ライセンス: GNU Lesser General Public License
 3.その他の blanco Framework
   概要: このプロダクトは それ自身が blanco Frameworkにより自動生成されています。
         このプロダクトは 実行時に blanco Framework各種プロダクトに依存して動作します。
   ライセンス: GNU Lesser General Public License
   