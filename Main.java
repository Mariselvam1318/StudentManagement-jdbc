package studentmanagement;
import java.sql.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao sd = new StudentDao();
		Scanner sc = new Scanner(System.in);	
		while(true) {
			System.out.println("*** Student Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
            	case 1:
            		System.out.println("Enter Student Id:");
            		int sid = sc.nextInt();
            		System.out.println("Enter Student Name:");
            		String sname = sc.next();
            		System.out.println("Enter Student Class:");
            		String sclass = sc.next();
            		System.out.println("Enter Student Mark:");
            		int smark = sc.nextInt();
            		
            		Student newstudent = new Student(sid,sname,sclass,smark);
            		sd.addStudent(newstudent);
            		System.out.println("Student Added Successfully!!..");
            		break;
            	case 2:
            		System.out.println("Enter Student Id:");
            		int id = sc.nextInt();
            		try {
            			Student student = sd.getStudent(id);
            			if(student!=null) {
            				System.out.println("Student Details");
            				System.out.println("ID :"+student.getStudentId());
            				System.out.println("Name :"+student.getStudentName());
            				System.out.println("Class :"+student.getStudentClass());
            				System.out.println("Mark :"+student.getStudentMark());
            			}
            			else {
            				System.out.println("Student Not Found");
            			}
            		}
            		catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	case 3:
            		System.out.println("All Student Details");
            		try{
            			sd.displayStudents();
            		}
            		catch(SQLException e) {
            			System.out.println("Error in displaying Students!!");
            			e.printStackTrace();
            		}
            		break;
            	case 4:
            		System.out.println("Enter Student Id to Update:");
            		int upid=sc.nextInt();
            		System.out.println("Enter Student Name:");
            		String uname = sc.next();
            		System.out.println("Enter Student Class:");
            		String uclass = sc.next();
            		System.out.println("Enter Student Mark:");
            		int umark = sc.nextInt();
            		Student upstudent = new Student(upid,uname,uclass,umark);
            		try {
            			sd.updateStudent(upstudent);
            		}
            		catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	case 5:
            		try {
            			System.out.println("Enter Student Id to Delete :");
                		int ds=sc.nextInt();
                		sd.deleteStudent(ds);
            		}
            		catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	case 6:
            		System.out.println("Exiting...");
            		System.exit(0);
            }
		}
	}

}
