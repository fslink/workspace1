package com.exia.enseignement;

import java.util.Set;

import com.exia.evaluation.Resultat;

/*
 * Interface implémentée par tout type d'élément évaluable.
 * Contrat que toute évaluation doit respectée
 */

public interface Evaluable {
	
	public void setTitre(String titre);
	public String getTitre();
	
	public void setCoefficient(int coef);  
	public int getCoefficient();
	public void ajouterResultat(Resultat resultat);
	// méthode listant l'ensemble des résultats d'un élément évaluable
	public Set<Resultat> retournerResultats();
	

}
