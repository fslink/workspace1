package dataAccess.domain;

public class Employee {
   private int id;
   private String name;
   private String firstname;
   
   //constructeur
   public Employee(String N, String F){
	   this.name = N;
	   this.firstname = F;
   }
   
   //accesseurs
   public String getName(){
	   return name;
   }
   public String getFirstname(){
	   return firstname;
   }
   public int getId(){
	   return id;
   }
   //modifieurs
   public void setName(String N){
	   this.name = N;
   }
   public void setFirstname(String F){
	   this.firstname = F;
   }
   public void setId(int I){
	   this.id = I;
   }
   //toString
   public String toString(){
	   return "employe id: "+id+" -- "+name+" "+firstname; 
   }
   
   
}
