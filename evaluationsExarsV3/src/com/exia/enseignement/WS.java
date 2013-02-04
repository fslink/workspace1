package com.exia.enseignement;

import java.util.Date;

/*
 * �valuation sp�cifique caract�ris�e par une date de passage de l'�valuation
 */
public class WS extends Evaluation {
	
	private Date datePassage;

	public WS(String titre, int coefficient, Date datePassage) {
		super(titre,coefficient);
		this.setDatePassage(datePassage);
	}

	public Date getDatePassage() {
		return datePassage;
	}

	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}
	
	
	

	

}
