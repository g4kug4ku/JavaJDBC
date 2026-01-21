package j4_ex;

import java.util.List;

public class FwriterStudentListBL {

	private final String COMMA = ",";

	public void extractAll() {

		//データベース接続
		StudentListDao dao = new StudentListDao();
		List<StudentListDto> dtoList = dao.selectMemberInfoAll();

		if (dtoList != null) {
			for (int i = 0; i < dtoList.size(); i++) {
				StringBuffer rsbuf = new StringBuffer();
				rsbuf.append(dtoList.get(i).getName());
				rsbuf.append(COMMA);
				rsbuf.append(dtoList.get(i).getGender());
				rsbuf.append(COMMA);
				rsbuf.append(dtoList.get(i).getAge());
				rsbuf.append(COMMA);
				rsbuf.append(dtoList.get(i).getCareer_mon());
				rsbuf.append(COMMA);
				rsbuf.append(dtoList.get(i).getBranch());
				rsbuf.append(COMMA);
				rsbuf.append(dtoList.get(i).getCourse());

				System.out.println(rsbuf.toString());
			}
		} else {
			System.out.println("[INFO]該当のユーザー情報を取得できませんでした");
		}

	}

}

