package com.exia.enseignement;

import java.util.*;

import com.exia.etudiant.Exar;
import com.exia.evaluation.Note;
import com.exia.evaluation.Resultat;

/*
 * Une UE = unité d'enseignement. Une UE "contient" un ensemble d'éléments évaluables
 */
public class UE {
	
	private String intitule;
	
	//collection "contenant" l'ensemble des éléments évaluables d'une UE
	private List<Evaluation> elementsEvaluables = new ArrayList<>();
	
	
	public UE(String intitule) {
		super();
		this.intitule = intitule;
	}
	
	public void ajouter(Evaluation elementEvaluable){
		elementsEvaluables.add(elementEvaluable);
		
	}
	
	/*
	 * méthode calculant la note obtenue par un exar à une UE
	 * retourne la note sous la forme d'une énumération Note
	 * prend en paramètre l'exar dont on veut obtenir le résultat à une UE donnée
	 */
	public Note calculerValidationUE(Exar exar){
		int diviseur = 0;
		float total = 0.0f;
	
		for(Evaluable ev : this.getElementsEvaluables()){//pour chaque élément évaluable de l'UE
			System.out.print("----note pour "+ev.getTitre()+"(coeff de "+ev.getCoefficient()+" )");
			int coefficient = ev.getCoefficient();
			diviseur += coefficient; //on ajoute les coefficients
			for(Resultat res : ev.retournerResultats()){//pour chaque résultat de l'élément évaluable
				if (exar.getResultats().contains(res)){//si la "liste" des résultats de l'exar contient le résultat en cours
					
					total += (res.retournerNoteNumeriquePonderee());//on récupère la valeur numérique du résultat en cours sur lequel on a appliqué le coefficient associé à l'évaluation
					break; //on sort du for le plus proche
				}
			}
		}
		System.out.println("--total="+total);
		System.out.println("--diviseur="+diviseur);
		float moyenne = total/diviseur;//on calcul la moyenne de l'UE
		System.out.print("--moyenne UE "+this.getIntitule()+" = "+moyenne);
		
		//on traduit la note à l'UE en équivalence alphabétique
		if (moyenne <= 1.6f){
			
			return Note.D;
		}else if(moyenne<= 2.6f){
			return Note.C;
		}else if(moyenne<= 3.6f){
			return Note.B;
		}else{
			return Note.A;
		}
		
		
	}
	
	
	
	public List<Evaluation> getElementsEvaluables(){
		return elementsEvaluables;
	}

	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



	@Override
	public int hashCode(){
		
		return intitule.length();
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof UE){
			UE uneUE = (UE) o;
			if(this.intitule.equals(uneUE.intitule) && this.intitule!=null){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
