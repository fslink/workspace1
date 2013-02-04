package com.exia.enseignement;

import java.util.Date;

/*
 * évaluation spécifique caractérisée par une date de passage de l'évaluation
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
