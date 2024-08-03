package studentmanagement;
import java.sql.*;
public class DbConnection {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub
		private static final String url ="jdbc:mysql://localhost:3307/db";
		private static final String user ="root";
		private static final String password ="root";
		
		
		public static Connection getConnection() throws SQLException{
			return DriverManager.getConnection(url,user,password);
		}
		
		
	}

//}
