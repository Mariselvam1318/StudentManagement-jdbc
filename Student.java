package studentmanagement;

public class Student  {
	private int studentId;
	private String studentName;
	private String studentClass;
	private int studentMark;
	
	
	public Student(int studentId,String studentName,String studentClass,int studentMark){
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentClass=studentClass;
		this.studentMark = studentMark;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId=studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass=studentClass;
	}
	public int getStudentMark() {
		return studentMark;
	}
	public void setStudentMark(int studentMark) {
		this.studentMark=studentMark;
	}
	
}
