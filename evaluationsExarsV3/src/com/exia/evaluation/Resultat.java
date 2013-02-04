package com.exia.evaluation;

import java.util.Date;

import com.exia.enseignement.Evaluation;
import com.exia.etudiant.Exar;


/*
 * le résultat d'un exar pour une évaluation
 */
public class Resultat {
	
	private Date dateCorrection;
	private Evaluation elementEvaluable;
	private Note note;
	private Exar exar;
	
	/*
	 * retourne la valeur numérique d'une note avec le coefficient appliqué.
	 */
	public float retournerNoteNumeriquePonderee(){
		System.out.println(" = "+note+"-"+note.getValeur());
		float resultatPondere = elementEvaluable.getCoefficient() * note.getValeur();
		return resultatPondere;
	}
	
	public Date getDateCorrection() {
		return dateCorrection;
	}
	public void setDateCorrection(Date dateCorrection) {
		this.dateCorrection = dateCorrection;
	}
	public Evaluation getElementEvaluable() {
		return elementEvaluable;
	}
	public void setElementEvaluable(Evaluation elementEvaluable) {
		this.elementEvaluable = elementEvaluable;
	}
	
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	
	
	
	public Exar getExar() {
		return exar;
	}
	public void setExar(Exar exar) {
		this.exar = exar;
	}
	public boolean equals (Object o){
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o instanceof Resultat){
			Resultat unResultat = (Resultat) o;
			if(this.elementEvaluable.getTitre().equals(unResultat.elementEvaluable.getTitre())&&
					this.note.getValeur()==unResultat.note.getValeur()&&
					this.exar.equals(unResultat.exar)){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public int hashCode(){
		int hash =this.elementEvaluable.getTitre().length() + this.note.getValeur();
		hash += this.exar.getNom().concat(this.exar.getPrenom()).length();
		return hash; 
	}
	
}
