package com.exia.synthese;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import com.exia.enseignement.Cctl;
import com.exia.enseignement.Evaluation;
import com.exia.enseignement.UE;
import com.exia.enseignement.WS;
import com.exia.etudiant.Exar;
import com.exia.evaluation.Note;
import com.exia.evaluation.Resultat;



public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		/* ---------------------------début BLOC pouvant être ignoré ----------------------------------*/
		//créer des exars
		Exar exar1 = new Exar("Diet","Jean-Aymeric");
		Exar exar2= new Exar("Sbriglio","Alexandre");
		Exar exar3 = new Exar("Barbolini","Emmanuel");
		
		//créer une UE
		UE ue1 = new UE("BDD 2");
		//ajouter des Elements évaluables
		Cctl sql = new Cctl("SQL",2,20);
		ue1.ajouter(sql);
		Cctl merise = new Cctl("Merise",3,30);
		ue1.ajouter(merise);
		WS plsql = new WS("PL/SQL",1,DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRANCE).parse("21/03/2013"));
		ue1.ajouter(plsql);
		
		//créer une UE
		UE ue2 = new UE("Programmation 2");
		//ajouter des Elements évaluables
		Cctl java = new Cctl("Java",1,10);
		ue2.ajouter(java);
		Cctl uml = new Cctl("UML",2,30);
		ue2.ajouter(uml);
		WS umljava = new WS("UML/Java",3,DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRANCE).parse("28/01/2013"));
		ue2.ajouter(umljava);
		
		//ajouter les UEs aux exars
		exar1.ajouter(ue1);
		exar1.ajouter(ue2);
		
		exar2.ajouter(ue1);
		exar2.ajouter(ue2);
		
		exar3.ajouter(ue1);
		exar3.ajouter(ue2);
		
		//Noter exar 1
		noter(exar1,Note.A,uml);
		noter(exar1,Note.B,java);
		noter(exar1,Note.A,umljava);
		noter(exar1,Note.A,sql);
		noter(exar1,Note.C,merise);
		noter(exar1,Note.B,plsql);
		
		//Noter exar 2
		noter(exar2,Note.C,uml);
		noter(exar2,Note.A,java);
		noter(exar2,Note.B,umljava);
		noter(exar2,Note.B,sql);
		noter(exar2,Note.C,merise);
		noter(exar2,Note.B,plsql);		
		
		//Noter exar 3
		noter(exar3,Note.B,uml);
		noter(exar3,Note.D,java);
		noter(exar3,Note.C,umljava);
		noter(exar3,Note.A,sql);
		noter(exar3,Note.A,merise);
		noter(exar3,Note.C,plsql);	
		/* ---------------------------fin BLOC pouvant être ignoré ----------------------------------*/
		
		//POINT D'ENTREE POUR LE DIAGRAMME DE SEQUENCES
		exar1.listerEvaluationsUes();
		exar2.listerEvaluationsUes();
		exar3.listerEvaluationsUes();

	}
	//méthode de notation pouvant être ignorée
	private static void noter(Exar exar, Note note, Evaluation eval){
		Resultat res = new Resultat();
		res.setDateCorrection(new Date());
		res.setElementEvaluable(eval);
		res.setNote(note);
		res.setExar(exar);
		exar.ajouter(res);
		eval.ajouterResultat(res);
		
	}
	
	

}
