package jsfjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



@ManagedBean(name="backingEmployees")
@SessionScoped


public class BackingEmployees {
	
	
	
	
	
	public List<Employee> findAllEmployees(){
		ArrayList <Employee> employeeList = new ArrayList <Employee>();
		try {
			
			Connection conn=null;
			EmployeesBO objcon= new EmployeesBO();
			conn=objcon.get_Connection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from employees");
			while(rs.next()) {
				Employee obj_emp=new Employee();
				obj_emp.setId(rs.getInt("id"));
				obj_emp.setFirstName(rs.getString("name"));
				obj_emp.setLastName(rs.getString("lastname"));
				obj_emp.setCompany(rs.getString("company"));
				obj_emp.setEmplNumber(rs.getString("employeeno"));
				obj_emp.setSalary(rs.getInt("salary"));
				employeeList.add(obj_emp);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return employeeList;
	}
	
	@ManagedProperty(value="#{backingEditEmployee}")
	private BackingEditEmployee backingEditEmployee;
	
public BackingEditEmployee getBackingEditEmployee() {
		return backingEditEmployee;
	}
	public void setBackingEditEmployee(BackingEditEmployee backingEditEmployee) {
		this.backingEditEmployee = backingEditEmployee;
	}
public void delete(Employee employee) {
	
	try {
		
		Connection conn=null;
		EmployeesBO objcon= new EmployeesBO();
		conn=objcon.get_Connection();
		PreparedStatement pst=conn.prepareStatement("delete from employees where id =?");
		pst.setInt(1,employee.getId());
		pst.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
}
public String edit(Employee employee) {
	backingEditEmployee.setEmployee(employee);
	
	return"update-employee";
}
	
}
