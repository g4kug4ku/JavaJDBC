package j4_ex;

public class StudentsCountByCourseDto {
	private String branch_name; //支店名
	private String course_name; //コース名
	private int student_id; //生徒数
	
	public String getBranchName() {
		return branch_name;
	}
	
	public void setBranchName(String branch_name) {
		this.branch_name  = branch_name;
	}
	
	public String getCourseName() {
		return course_name;
	}
	
	public void setCourseName(String course_name) {
		this.course_name = course_name;
	}
	
	public int getStudentCount() {
		return student_id;
	}
	
	public void setStudentCount(int student_id) {
		this.student_id = student_id;
	}

	

}
