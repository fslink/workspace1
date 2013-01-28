package dataAccess;
import dataAccess.domain.Employee;
import java.util.ArrayList;


public interface EmployeeDAO {
	public void addEmployee(Employee em);
	public void removeEmployee(Employee em);
	public void closeConnection();
	

}
