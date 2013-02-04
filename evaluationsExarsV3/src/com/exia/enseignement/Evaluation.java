package com.exia.enseignement;

import java.util.*;

import com.exia.evaluation.Resultat;

/*
 * classe abstraite ne pouvant être instanciée. 
 * Implémente les méthodes de l'interface Evaluable. 
 * Ces méthodes sont communes à tous les types concrets d'évaluation (Cctl et WS)
 */

public abstract class Evaluation implements Evaluable{
	
	private String titre ;
	private int coefficient;
	private Set<Resultat> resultats = new HashSet<>();//collection de tous les résultats d'une évaluation donnée
	
	//Pour information : oui une classe abstraite peut implémenter un constructeur, mais vous n'avez pas le droit d'instancier
	public Evaluation(String titre, int coefficient) {
		this.titre = titre;
		this.coefficient = coefficient;
	}
	
	public void ajouterResultat(Resultat resultat){
		resultats.add(resultat);
	}
	
	// implémentation de la méthode listant l'ensemble des résultats d'un élément évaluable.
	// retourne l'ensemble des résultats pour une évaluation donnée
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
