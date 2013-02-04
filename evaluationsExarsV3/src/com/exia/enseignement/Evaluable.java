package com.exia.enseignement;

import java.util.Set;

import com.exia.evaluation.Resultat;

/*
 * Interface impl�ment�e par tout type d'�l�ment �valuable.
 * Contrat que toute �valuation doit respect�e
 */

public interface Evaluable {
	
	public void setTitre(String titre);
	public String getTitre();
	
	public void setCoefficient(int coef);  
	public int getCoefficient();
	public void ajouterResultat(Resultat resultat);
	// m�thode listant l'ensemble des r�sultats d'un �l�ment �valuable
	public Set<Resultat> retournerResultats();
	

}
