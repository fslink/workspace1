package com.exia.enseignement;

/*
 * �valuation sp�cifique caract�ris�e par une dur�e
 */
public class Cctl extends Evaluation {

    private int duree = 0;
	
	public Cctl(String titre, int coefficient, int duree) {
		super(titre,coefficient);
		this.duree = duree;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	
	
	

}
