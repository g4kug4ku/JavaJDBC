package j4_ex;

public class FWriterStudentInfoMain {

	public static void main(String[] args) {
		
		FwriterStudentListBL bl = new FwriterStudentListBL();
		System.out.println("#--受講生一覧--");
		System.out.println("名前, 性別, 年齢, 職歴, 登録支店, 受講講座");
		bl.extractAll();

	}

}
