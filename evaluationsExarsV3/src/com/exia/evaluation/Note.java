package com.exia.evaluation;

/*
 * représentation du concept de note de l'eXia.CESI
 * par exemple : Un A correspond à la valeur numérique 4
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
