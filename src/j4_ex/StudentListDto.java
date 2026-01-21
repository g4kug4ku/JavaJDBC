package j4_ex;

public class StudentListDto {
	private String name; //名前
	private String gender; //性別（男：1／女：2）
	private int age; //年齢
	private int career_mon; //職歴
	private String total_career; //〇年〇ヶ月に直した値
	private String branch_name; //登録支店
	private String course_name; //コース名

	//getter/setter（対象フィールド：name）
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//getter/setter（対象フィールド：gender）
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender.equals("1")) {
			this.gender = "男性";
		} else if (gender.equals("2")) {
			this.gender = "女性";
		}
		
	}

	//getter/setter（対象フィールド：age）
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//getter/setter（対象フィールド：career_mon）
	public String getCareer_mon() {
		int career_year = career_mon / 12;
		int career_month = career_mon % 12;
		
		if (career_year == 0 && career_month == 0) {
			total_career = "職歴なし";
		} else if (career_year == 0 && career_month > 0) {
			total_career = career_month + "か月";
		} else if (career_year > 0 && career_month == 0) {
			total_career = career_year + "年";
		} else {
			total_career = career_year + "年" + career_month + "か月";
		}
		
		return total_career;
	}
	
	public void setCareer_mon(int career_mon) {
		this.career_mon = career_mon;
	}
	
	public String getBranch() {
		return branch_name;
	}
	
	public void setBranch(String branch_name) {
		this.branch_name = branch_name;
	}
	
	public String getCourse() {
		return course_name == null ? "受講なし" : course_name;
	}
	
	public void setCourse(String course_name) {
		this.course_name = course_name;
	}

}
