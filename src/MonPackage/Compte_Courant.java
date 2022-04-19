package MonPackage;

public class Compte_Courant extends Compte{

    private double decouvert_autorise;

    public Compte_Courant(int numero, String nom_titulaire, double solde, double decouvert) {
        super(numero, nom_titulaire, solde);
        decouvert_autorise = decouvert;
    }
    
    

    public double getDecouvert_autorise() {
		return decouvert_autorise;
	}

	public void setDecouvert_autorise(double decouvert_autorise) {
		this.decouvert_autorise = decouvert_autorise;
	}


	public void consulte() {
        super.consulte();
        System.out.println("Votre découvert maximal autorisé est de : " + decouvert_autorise + "€");
    }

    public void retirer(double val){
        if (solde - val > - decouvert_autorise) {
            solde = solde - val;
        }
        else {
        	System.out.println("Vous ne pouvez pas déposer votre limite de découvert !");
        }
    }
    
    public int type(){
    	return 1;
    }

}
