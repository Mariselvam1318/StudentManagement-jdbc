package studentmanagement;
import java.sql.*;
public class StudentDao {

	public void addStudent(Student student) {
		String sql ="Insert into Student(Student_Id,Student_Name,Student_Class,Student_Mark)"
				    + "values(?,?,?,?)";
		try(Connection connection = DbConnection.getConnection();
			PreparedStatement pst =connection.prepareStatement(sql)){
			pst.setInt(1, student.getStudentId());
			pst.setString(2, student.getStudentName());
			pst.setString(3, student.getStudentClass());
			pst.setInt(4, student.getStudentMark());
			pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Student getStudent(int studentId) throws SQLException{
		String sql = "Select * from  Student where Student_Id=?";
		Student student =null;
		try(Connection connection = DbConnection.getConnection();
				PreparedStatement pst =connection.prepareStatement(sql)){
			pst.setInt(1, studentId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				student = new Student(
						rs.getInt("Student_Id"),
						rs.getString("Student_Name"),
						rs.getString("Student_Class"),
						rs.getInt("Student_Mark")
						);
				
						
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	public void displayStudents()throws SQLException{
		String sql = "Select * from Student";
		try(Connection connection = DbConnection.getConnection();
			PreparedStatement pst =connection.prepareStatement(sql)){
			ResultSet rs=pst.executeQuery();
			 System.out.printf("%-15s %-20s %-15s %s%n", "Student_Id", "Student_Name", "Student_Class", "Student_Mark");
			//System.out.println("Student_Id\t\tStudent_Name\t\tStudent_Class\t\tStudent_Mark");
			while (rs.next()) {
				 
                int sid = rs.getInt("Student_Id");
                String sname = rs.getString("Student_Name");
                String sclass = rs.getString("Student_Class");
                int smarks =rs.getInt("Student_Mark");
                //System.out.println(sid + "\t\t" + sname + "\t\t" + sclass + "\t\t" +smarks);
                System.out.printf("%-15d %-20s %-15s %d%n", sid, sname, sclass, smarks);
            }
		}
			
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id)throws SQLException{
		String sql = "delete from Student where Student_Id = ?";
		try(Connection connection = DbConnection.getConnection();
				PreparedStatement pst =connection.prepareStatement(sql)){
			pst.setInt(1,id);
			int rows=pst.executeUpdate();
            if (rows > 0) {
            	System.out.println("Student deleted Successfully!!");
	        } else {
	            System.out.println("No Student found with ID: " + id);
	        }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudent(Student student)throws SQLException{
		String sql = "update Student set Student_Name=?,Student_Class=?,Student_Mark=? where Student_Id=?";
		try(Connection connection = DbConnection.getConnection();
				PreparedStatement pst =connection.prepareStatement(sql)){
			pst.setString(1,student.getStudentName());
			pst.setString(2,student.getStudentClass());
			pst.setInt(3, student.getStudentMark());
			pst.setInt(4, student.getStudentId());
			int rows=pst.executeUpdate();
			if (rows > 0) {
	            System.out.println("Student Updated Successfully!!");
	        } else {
	            System.out.println("No Student found with ID: " + student.getStudentId());
	        }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
