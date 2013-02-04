package com.exia.enseignement;

import java.util.*;

import com.exia.etudiant.Exar;
import com.exia.evaluation.Note;
import com.exia.evaluation.Resultat;

/*
 * Une UE = unit� d'enseignement. Une UE "contient" un ensemble d'�l�ments �valuables
 */
public class UE {
	
	private String intitule;
	
	//collection "contenant" l'ensemble des �l�ments �valuables d'une UE
	private List<Evaluation> elementsEvaluables = new ArrayList<>();
	
	
	public UE(String intitule) {
		super();
		this.intitule = intitule;
	}
	
	public void ajouter(Evaluation elementEvaluable){
		elementsEvaluables.add(elementEvaluable);
		
	}
	
	/*
	 * m�thode calculant la note obtenue par un exar � une UE
	 * retourne la note sous la forme d'une �num�ration Note
	 * prend en param�tre l'exar dont on veut obtenir le r�sultat � une UE donn�e
	 */
	public Note calculerValidationUE(Exar exar){
		int diviseur = 0;
		float total = 0.0f;
	
		for(Evaluable ev : this.getElementsEvaluables()){//pour chaque �l�ment �valuable de l'UE
			System.out.print("----note pour "+ev.getTitre()+"(coeff de "+ev.getCoefficient()+" )");
			int coefficient = ev.getCoefficient();
			diviseur += coefficient; //on ajoute les coefficients
			for(Resultat res : ev.retournerResultats()){//pour chaque r�sultat de l'�l�ment �valuable
				if (exar.getResultats().contains(res)){//si la "liste" des r�sultats de l'exar contient le r�sultat en cours
					
					total += (res.retournerNoteNumeriquePonderee());//on r�cup�re la valeur num�rique du r�sultat en cours sur lequel on a appliqu� le coefficient associ� � l'�valuation
					break; //on sort du for le plus proche
				}
			}
		}
		System.out.println("--total="+total);
		System.out.println("--diviseur="+diviseur);
		float moyenne = total/diviseur;//on calcul la moyenne de l'UE
		System.out.print("--moyenne UE "+this.getIntitule()+" = "+moyenne);
		
		//on traduit la note � l'UE en �quivalence alphab�tique
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
