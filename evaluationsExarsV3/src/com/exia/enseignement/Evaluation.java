package com.exia.enseignement;

import java.util.*;

import com.exia.evaluation.Resultat;

/*
 * classe abstraite ne pouvant �tre instanci�e. 
 * Impl�mente les m�thodes de l'interface Evaluable. 
 * Ces m�thodes sont communes � tous les types concrets d'�valuation (Cctl et WS)
 */

public abstract class Evaluation implements Evaluable{
	
	private String titre ;
	private int coefficient;
	private Set<Resultat> resultats = new HashSet<>();//collection de tous les r�sultats d'une �valuation donn�e
	
	//Pour information : oui une classe abstraite peut impl�menter un constructeur, mais vous n'avez pas le droit d'instancier
	public Evaluation(String titre, int coefficient) {
		this.titre = titre;
		this.coefficient = coefficient;
	}
	
	public void ajouterResultat(Resultat resultat){
		resultats.add(resultat);
	}
	
	// impl�mentation de la m�thode listant l'ensemble des r�sultats d'un �l�ment �valuable.
	// retourne l'ensemble des r�sultats pour une �valuation donn�e
	@Override
	public Set<Resultat> retournerResultats(){
		return resultats;
	}

	
	@Override
	public void setTitre(String titre) {
		this.titre = titre;
		
	}

	@Override
	public String getTitre() {
		// TODO Auto-generated method stub
		return titre;
	}

	@Override
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
		
	}
	

	@Override
	public int getCoefficient() {
		// TODO Auto-generated method stub
		return this.coefficient;
	}

}
