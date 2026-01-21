package j4_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentListDao {
	//データベース接続
	//JDBCドライバの相対パス
	//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	//接続先のデータベース
	//※データベース名が「test_db」でない場合は該当の箇所を変更してください
	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";

	//接続するユーザー名
	//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
	String USER_ID = "test_user";

	//接続するユーザーのパスワード
	//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
	String USER_PASS = "test_pass";

	public List<StudentListDto> selectMemberInfoAll() {

		try {
			Class.forName(DRIVER_NAME); //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection con = null; // Connection（DB接続情報）格納用変数
		PreparedStatement ps = null; // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet rs = null; // ResultSet（SQL抽出結果）格納用変数
		
		//抽出データ（List型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		List<StudentListDto> dtoList = new ArrayList<StudentListDto>();
		
		try {
			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" SELECT                                                                  ");
			buf.append("   uzuz_student.student_name   ,                                         ");
			buf.append("   uzuz_student.gender         ,                                         ");
			buf.append("   uzuz_student.age            ,                                         ");
			buf.append("   uzuz_student.career_mon     ,                                         ");
			buf.append("   branch.branch_name          ,                                         ");
			buf.append("   course.course_name                                                    ");
			buf.append(" FROM          		                                                     ");
			buf.append("   (branch INNER JOIN uzuz_student                                       ");
			buf.append("          ON uzuz_student.branch_id = branch.branch_id)                  ");
			buf.append("          LEFT JOIN course ON uzuz_student.course_id = course.course_id ");
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());

			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();

			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			while(rs.next()){
				StudentListDto dto = new StudentListDto();
				dto.setName(   rs.getString( "student_name"   ) );
				dto.setGender( rs.getString( "gender" ) );
				dto.setAge(    rs.getInt(    "age"    ) );
				dto.setCareer_mon(rs.getInt("career_mon"));
				dto.setBranch(rs.getString("branch_name"));
				dto.setCourse(rs.getString("course_name"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//-------------------------------------------
			//接続の解除
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

		//抽出データを戻す
		return dtoList;
	}

}
