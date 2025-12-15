package j4_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample4_01_1 {

	//定数
	private static String COMMA = ","; //コンマ

	public static void main(String[] args) {
		//-------------------------------------------
		//データベースへの接続情報
		//-------------------------------------------

		//JDBCドライバの相対パス
		//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
		String driverName = "com.mysql.cj.jdbc.Driver";

		//接続先のデータベース
		//※データベース名が「test_db」でない場合は該当の箇所を変更してください
		String jdbcUrl    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";

		//接続するユーザー名
		//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
		String userId     = "test_user";

		//接続するユーザーのパスワード
		//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
		String userPass   = "test_pass";

		//-------------------------------------------
		//① JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(driverName);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数

		try {
			//-------------------------------------------
			// ②接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(jdbcUrl, userId, userPass);

			//-------------------------------------------
			// ③SQL文の送信 ＆ ④抽出結果の取得
			//-------------------------------------------

			//SQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer() ;
			buf.append(" SELECT        ");
			buf.append("   id     ,    ");
			buf.append("   name   ,    ");
			buf.append("   gender ,    ");
			buf.append("   age    ,    ");
			buf.append("   course      ");
			buf.append(" FROM          ");
			buf.append("   uzuz_member ");
			buf.append(" ORDER BY      ");
			buf.append("   id          ");

			//PreparedStatementオブジェクトを生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());

			//SQL文の送信＆抽出結果（ResultSetオブジェクト）の取得
			rs = ps.executeQuery();

			//ResultSetオブジェクトから1レコードずつデータを取得＆加工＆表示する
			while (rs.next()) {

				//1レコード分のデータを取得＆加工（各カラムをコンマ綴りで結合）
				StringBuffer rsbuf = new StringBuffer();
				rsbuf.append(rs.getString("id"));
				rsbuf.append(COMMA);
				rsbuf.append(rs.getString("name"));
				rsbuf.append(COMMA);
				rsbuf.append(rs.getString("gender"));
				rsbuf.append(COMMA);
				rsbuf.append(rs.getString("age"));
				rsbuf.append(COMMA);
				rsbuf.append(rs.getString("course"));

				//加工作成した1レコード分のデータを表示
				System.out.println(rsbuf.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			//-------------------------------------------
			// ⑤接続の解除
			//-------------------------------------------

			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
