package workshop.student.control;
import exception.InvalidGradeException;
import workshop.student.entity.Student;

public class StudentTest {
	// 김민수 / 컴퓨터공학 / 3학년
	// 5학년으로 변경 
	
	public static void main(String[] args) {
		
		try {
			Student stu = new Student("a121432522", "김민수", "컴퓨터공학", 3);
			
			System.out.println(stu.getStudentId() + '/' + stu.getMajor() + '/' + stu.getClass());
			System.out.println ("5학년으로 변경");
			
			stu.setGrade(5);
			
			
			
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
