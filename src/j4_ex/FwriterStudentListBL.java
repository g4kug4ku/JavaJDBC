package j4_ex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FwriterStudentListBL {

	//定数の定義
	final String FILE_PATH = "D:\\workspace\\JavaJDBC\\src\\j4_ex\\j4-EX_1.csv"; //書き出し用ファイルのパス情報
	final String NEW_LINE = System.getProperty("line.separator"); //改行
	final String COMMA = ","; // コンマ

	public void extractAll() {

		//データベース接続
		StudentListDao dao = new StudentListDao();
		List<StudentListDto> dtoList = dao.selectMemberInfoAll();

		try {
			//書き出し用ファイルの読み込み
	    	File file = new File( FILE_PATH );

	        //書き出し用ファイルをFileWriterにセット
	        FileWriter fileWriter = new FileWriter(file);
	        
	        fileWriter.write("#--受講生一覧--");
	        fileWriter.write(NEW_LINE);
	        fileWriter.write("名前, 性別, 年齢, 職歴, 登録支店, 受講講座");
	        fileWriter.write(NEW_LINE);
	        
	        for (int i = 0; i < dtoList.size(); i++) {
	        	fileWriter.write(dtoList.get(i).getName());
	        	fileWriter.write( COMMA );
	        	fileWriter.write(dtoList.get(i).getGender());
	        	fileWriter.write( COMMA );
	        	fileWriter.write(String.valueOf(dtoList.get(i).getAge()));
	        	fileWriter.write( COMMA );
	        	fileWriter.write(dtoList.get(i).getCareer_mon());
	        	fileWriter.write( COMMA );
	        	fileWriter.write(dtoList.get(i).getBranch());
	        	fileWriter.write( COMMA );
	        	fileWriter.write(dtoList.get(i).getCourse());
	        	fileWriter.write(NEW_LINE);
	        }
	        
	        fileWriter.write(NEW_LINE);
	        fileWriter.write(NEW_LINE);
	        
	        fileWriter.close();
	        
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}

