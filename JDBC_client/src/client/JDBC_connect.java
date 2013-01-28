package client;
import dataAccess.EmployeeSimpleDAO;
import dataAccess.EmployeeDAO;
import dataAccess.domain.Employee;
import client.IHM_insertion;

public class JDBC_connect{
	
	public static void main(String[] args){
		
		EmployeeSimpleDAO dao = new EmployeeSimpleDAO();
		
		try{
			IHM_insertion insert = new IHM_insertion();
			insert.setVisible(true);
			
		}catch(Exception e){
		System.out.println("erreur dans le chargement de l'IHM -- le prog va s'arrêter après fermeture de la connexion" +e);
		}finally{
		dao.closeConnection();//fermeture de la connexion
		}


		
	}
}

