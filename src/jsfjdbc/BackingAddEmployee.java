package jsfjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name="backingAddEmployee")
@ViewScoped
public class BackingAddEmployee {
private Employee employee = new Employee();
private ArrayList<Company> companiesList=new ArrayList<Company>();





public ArrayList<Company> getCompaniesList() {
	return companiesList;
}

public void setCompaniesList(ArrayList<Company> companiesList) {
	this.companiesList = companiesList;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public void saveEmployee() {
try {
		
		Connection conn=null;
		EmployeesBO objcon= new EmployeesBO();
		conn=objcon.get_Connection();
		PreparedStatement pst=conn.prepareStatement("insert into employees(name,lastname,company,employeeno,salary) values(?,?,?,?,?)");
		//st.executeQuery("insert into categories(category_name) value('"+category_name+"')");
		pst.setString(1,employee.getFirstName());
		pst.setString(2,employee.getLastName());
		pst.setString(3,employee.getCompany());
		pst.setString(4,employee.getEmplNumber());
		pst.setDouble(5,employee.getSalary());
		pst.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
	
	
}

}
