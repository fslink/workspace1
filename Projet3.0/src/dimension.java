
public class dimension {

	
	int largeur;
	int hauteur;
	public dimension(int larg,int haut){
		this.largeur = larg;
		this.hauteur = haut;
	
		
	}
	public void setLargeur(int large){
		this.largeur = large;
	}
	public void setHauteur(int haute){
		this.hauteur = haute;
	}
	
	public int getLargeur(){
		return this.largeur;
	}
	public int getHauteur(){
		return this.hauteur;
	}
}

