package com.exia.etudiant;

import java.util.*;

import com.exia.enseignement.UE;
import com.exia.evaluation.Resultat;

/*
 * modélise un étudiant de l'eXia
 */
public class Exar {
	
	private String nom;
	private String prenom;
	
	//l'ensemble des unités d'enseignement auxquelles un exar est inscrit
	private Set<UE> ues = new HashSet<>();
	//l'ensemble des résultats obtenus par un exar toute UE confondue
	private Set<Resultat> resultats = new HashSet<>();
	
	public Exar(String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	

	//méthode "générant" la synthèse des évaluations pour toutes les UEs auxquelles l'exar est inscrit
	public void listerEvaluationsUes(){
		System.out.println("RESULTATS DE "+prenom.toUpperCase()+" "+nom.toUpperCase());
		for(UE ue : this.getUes()){//pour chaque UE à laquelle l'exar est inscrit
			System.out.println("*UE "+ue.getIntitule());
			System.out.println("====>"+ue.calculerValidationUE(this));//on calcule la note à cette UE
		}
		System.out.println("\n");
	}
	
	public void ajouter(UE ue){
		ues.add(ue);
	}
	
	public void ajouter(Resultat resultat){
		
		resultats.add(resultat);
		
	}
	
	public Set<UE> getUes(){
		return ues;
	}
	
	public Set<Resultat> getResultats(){
		return resultats;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Exar)) {
			return false;
		}
		Exar other = (Exar) obj;
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
			return false;
		}
		return true;
	}

	

	
	
	
	

}
