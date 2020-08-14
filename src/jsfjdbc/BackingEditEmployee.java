package jsfjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean(name="backingEditEmployee")
@SessionScoped
public class BackingEditEmployee {
private Employee employee= new Employee();
 EmployeesBO empb = new EmployeesBO();
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public String updateEmployee() {
	
	
	try {
		Connection conn=null;
		EmployeesBO objcon= new EmployeesBO();
		conn=objcon.get_Connection();
		PreparedStatement pst=conn.prepareStatement("update employees set name=?,lastname=?,company=?, employeeno=?, salary=? where id=? ");
		
		//Employee employee =new Employee();
		
		pst.setString(1,employee.getFirstName());
		pst.setString(2,employee.getLastName());
		pst.setString(3,employee.getCompany());
		pst.setString(4,employee.getEmplNumber());
		pst.setDouble(5,employee.getSalary());
		pst.setInt(6,employee.getId());
		pst.executeUpdate();
	}catch(Exception e) {
		
		System.out.println(e);
		
	}
	return "employees";
}


}
