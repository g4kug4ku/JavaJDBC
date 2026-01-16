package j4_ex;

public class StudentListDto {
	private int    id     ;  //ID
	private String name   ;  //名前
	private String gender ;  //性別（男：M／女：F）
	private int    age    ;  //年齢
	
	//getter/setter（対象フィールド：id）
		public int getId() {return id;}
		public void setId(int id) {this.id = id;}

		//getter/setter（対象フィールド：name）
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}

		//getter/setter（対象フィールド：gender）
		public  String getGender() {return gender;}
		public void setGender(String gender) {this.gender = gender;}

		//getter/setter（対象フィールド：age）
		public int getAge() {return age;}
		public void setAge(int age) {this.age = age;}
	

}
