package workshop.student.entity;

import exception.InvalidGradeException;

public class Student {
	private String studentId;
	
	private String name;
	
	private String major;
	
	private int grade;
	
	public Student(String studentId, String name, String major, int grade) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
		
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public void setGrade(int grade) throws InvalidGradeException{
		if(grade < 0 || grade > 4) {
			

			String errMessage = String.format("학년은 1~4 사이여야 합니다.");
			
			throw new InvalidGradeException(errMessage);
		}
		this.grade = grade;
	}
	
	
	
}
