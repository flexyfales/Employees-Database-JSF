package jsfjdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class EmployeesBO {


	 public static void main(String[] args) {
		EmployeesBO objcon= new EmployeesBO();
		System.out.println(objcon.get_Connection());
	}
	
	
	
	public Connection get_Connection() {
		Connection conn=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		return conn;
	}
	
	
	
}
