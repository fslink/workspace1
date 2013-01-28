package client;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dataAccess.EmployeeSimpleDAO;
import dataAccess.domain.Employee;

class evenements extends MouseAdapter {
	
	EmployeeSimpleDAO dao;
	Employee empl;
	
	public evenements(String N, String F){
		this.empl = new Employee(N, F);
	}

	
	public void mouseClickedValider(MouseEvent e){
		dao = new EmployeeSimpleDAO();
		dao.addEmployee(empl);
	}
		
	

}
