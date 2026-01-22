package j4_ex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FWriterStudentsCountByCourseBL {
	//定数の定義
	final String FILE_PATH = "D:\\workspace\\JavaJDBC\\src\\j4_ex\\j4-EX_1.csv"; //書き出し用ファイルのパス情報
	final String NEW_LINE = System.getProperty("line.separator"); //改行
	final String COMMA = ","; // コンマ

	public void extractAll() {
		//データベース接続
		StudentsCountByCourseDao dao = new StudentsCountByCourseDao();
		List<StudentsCountByCourseDto> CoursedtoList = dao.selectMemberInfoAll();

		try {
			//書き出し用ファイルの読み込み
			File file = new File(FILE_PATH);

			//書き出し用ファイルをFileWriterにセット
			FileWriter fileWriter = new FileWriter(file, true); //trueを指定すると追記が可能になる

			fileWriter.write("#--集計結果--");
			fileWriter.write(NEW_LINE);
			fileWriter.write("登録支店, 受講講座, 受講者数");
			fileWriter.write(NEW_LINE);

			for (int i = 0; i < CoursedtoList.size(); i++) {
				fileWriter.write(CoursedtoList.get(i).getBranchName());
				fileWriter.write(COMMA);
				fileWriter.write(CoursedtoList.get(i).getCourseName());
				fileWriter.write(COMMA);
				fileWriter.write(String.valueOf(CoursedtoList.get(i).getStudentCount()));
				fileWriter.write(NEW_LINE);
			}

			fileWriter.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
