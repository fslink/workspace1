package com.exia.evaluation;

/*
 * repr�sentation du concept de note de l'eXia.CESI
 * par exemple : Un A correspond � la valeur num�rique 4
 */
public enum Note {
   
   A(4),B(3),C(2),D(1);
   Note(int valeur){
	   this.valeur = valeur;
   }
   
   private int valeur = 0;
   public int getValeur(){
	   return valeur;
   }
}
