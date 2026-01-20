package j4_ex;

public class StudentListDto {
	private String name; //名前
	private String gender; //性別（男：1／女：2）
	private int age; //年齢
	private int career_mon; //職歴

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
	public int getCareer_mon() {
		return career_mon;
	}
	
	public void setCareer_mon(int career_mon) {
		this.career_mon = career_mon;
	}

}
