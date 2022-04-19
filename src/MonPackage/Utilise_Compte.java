package MonPackage;

import java.util.Scanner;
import java.util.ArrayList; 

public class Utilise_Compte {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Compte_Courant> lesComptesCourants= new ArrayList<Compte_Courant>();
		ArrayList<Compte_Epargne> lesComptesEpargnes= new ArrayList<Compte_Epargne>();
		
		Compte_Courant unCompteCourant;
		Compte_Epargne unCompteEpargne;
		
		boolean boucle = true;
		int rep, nbAccount = 0, NumCompteBis, decouvert_autorise;
		String nom;
		double solde, taux, retrait, depot, tauxBis;
		
		while(boucle == true) {
			
			System.out.println("Bonjour, bienvenue sur l'application banque");
			System.out.println("Pour créer un compte, tapez '1'");
			System.out.println("Pour afficher tous les comptes, tapez '2'");
			System.out.println("Pour manipuler un compte, tapez '3'");
			System.out.println("Pour manipuler tous les comptes, tapez '4')");
			System.out.println("Pour quitter l'application, tapez '5'");
			
			rep = Saisie.lire_int("");
			
			if(rep == 1) {
				
				rep = Saisie.lire_int("Pour créer un compte courant tapez '1', pour un créer un compte épargne tapez '2'");
				while (rep != 1 && rep !=2) {
					
					rep = Saisie.lire_int("Veuillez saisir '1' ou '2' !");
				}
				
				nbAccount += 1;
				
				nom = Saisie.lire_String("Veuillez saisir un nom");
				
				solde = Saisie.lire_double("Veuillez saisir le solde du compte");
				
				if(rep == 1) {
					
					decouvert_autorise = Saisie.lire_int("Veuillez indiquer le découvert autorisé");
					
					unCompteCourant = new Compte_Courant(nbAccount, nom, solde, decouvert_autorise);
					
					lesComptesCourants.add(unCompteCourant);	
				}
				else if(rep == 2) {
				
					System.out.println("Entrez le taux en %");
					taux = Saisie.lire_double("Veuillez indiquer le taux en pourcentage (%)");
					taux = (taux/100)+1;
					
					unCompteEpargne = new Compte_Epargne(nbAccount, nom, solde, taux);
					
					lesComptesEpargnes.add(unCompteEpargne);
				}
			}
			else if(rep == 2) {
				
				System.out.println("Les comptes courants : ");
				
				for(Compte_Courant leCompteCourant : lesComptesCourants) {
					
					System.out.println("le numero est " + leCompteCourant.getNumero());
					System.out.println("le nom est " + leCompteCourant.getNom());
					System.out.println("");
				}
				
				System.out.println("Les comptes épargnes : ");
				
				for(Compte_Epargne leCompteEpargne : lesComptesEpargnes) {
					
					System.out.println("le numero est " + leCompteEpargne.getNumero());
					System.out.println("le nom est " + leCompteEpargne.getNom());
					System.out.println("");
				}
			}
			else if(rep == 3) {
				
				System.out.println("Si vous souhaitez consulter le solde d'un compte, tapez '1'");
				System.out.println("Si vous souhaitez faire un retrait sur un compte, tapez '2'");
				System.out.println("Si vous souhaitez faire un dépôt sur un compte, tapez '3'");
				System.out.println("Si vous souhaitez connaitre le montant du découvert d'un compte courant, tapez '4'");
				System.out.println("Si vous souhaitez connaitre le taux de rémunération d'un compte épargne, tapez '5'");
				
				rep = Saisie.lire_int("");
				
				if(rep == 1) {
					
					rep = Saisie.lire_int("De quel type de compte il s'agit ? Tapez '1' pour un compte courant ou '2' pour un compte épargne");
					
					if(rep == 1) {
						
						NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
						
						for(Compte_Courant leCompteCourant: lesComptesCourants) {
							
				            if (NumCompteBis == leCompteCourant.getNumero()) {
				            	
				                System.out.println("le solde est de :" + leCompteCourant.getSolde());
				            }
						}
					}
					else if(rep == 2) {
						
						System.out.println("saisissez le numero du compte");
						NumCompteBis = sc.nextInt();
						NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
						
						for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
							
				            if (NumCompteBis == leCompteEpargne.getNumero()) {
				            	
				                System.out.println("le solde est de :" + leCompteEpargne.getSolde());
				            }
						}
					}
				}
				else if(rep == 2) {

					rep = Saisie.lire_int("De quel type de compte il s'agit ? Tapez '1' pour un compte courant ou '2' pour un compte épargne");
					
					
					if(rep == 1) {

						NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
						
						for(Compte_Courant leCompteCourant: lesComptesCourants) {
							if(NumCompteBis == leCompteCourant.getNumero()) {
								
								retrait = Saisie.lire_double("Combien souhaitez-vous retirer ?");
								
								leCompteCourant.retirer(retrait);
								System.out.println("Le nouveau solde est de :" + leCompteCourant.getSolde());
							}
						}
					}
					else if(rep == 2) {
						
						NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
						
						for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
							
							if(NumCompteBis == leCompteEpargne.getNumero()) {
								
								retrait = Saisie.lire_double("Combien souhaitez-vous retirer ?");
								
								leCompteEpargne.retirer(retrait);
								System.out.println("Le nouveau solde est de :" + leCompteEpargne.getSolde());
							}
						}
					}
				}
				else if(rep == 3){
					
					rep = Saisie.lire_int("De quel type de compte il s'agit ? Tapez '1' pour un compte courant ou '2' pour un compte épargne");
					
					if(rep == 1) {
						
						NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
						
						for(Compte_Courant leCompteCourant: lesComptesCourants) {
							
							if(NumCompteBis == leCompteCourant.getNumero()) {
								
								depot = Saisie.lire_double("Combien souhaitez-vous déposer ?");
								
								leCompteCourant.deposer(depot);
								System.out.println("Le nouveau solde est de :" + leCompteCourant.getSolde());
							}
						}
					}
					else if(rep == 2) {
						
						NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
						
						for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
							
							if(NumCompteBis == leCompteEpargne.getNumero()) {
								
								depot = Saisie.lire_double("Combien souhaitez-vous déposer ?");
								
								leCompteEpargne.deposer(depot);
								System.out.println("Le nouveau solde est de :" + leCompteEpargne.getSolde());
							}
						}
					}
				}
				else if(rep == 4){
					
					NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
					
					for(Compte_Courant leCompteCourant: lesComptesCourants) {
						
						if(NumCompteBis == leCompteCourant.getNumero()) {
							
							System.out.println("Le montant du découvert est de :" + leCompteCourant.getDecouvert_autorise());
						}
					}

				}
				else if(rep == 5){
					
					NumCompteBis = Saisie.lire_int("Quel est le numéro du compte ?");
					
					for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
						
						if(NumCompteBis == leCompteEpargne.getNumero()) {
							
							System.out.println("Le montant du taux est de :" + ((leCompteEpargne.getTaux() - 1)*100));
						}
					}

				}
			}
			else if(rep == 4){
				
				System.out.println("Pour afficher la liste des titulaires des comptes courants avec un solde négatif, tapez '1')");
				System.out.println("Pour modifier le taux de rémunération de tous les comptes éparges, tapez '2'");
				System.out.println("Pour afficher la liste des personnes possédant un compte courant et un compte épargne, tapez '3'");
				
				rep = Saisie.lire_int("");
				
				if(rep == 1) {
					
					for(Compte_Courant leCompteCourant: lesComptesCourants) {
						
						if(leCompteCourant.getSolde() < 0){
							
							System.out.println(leCompteCourant.getNom());
						}
					}
				}
				else if(rep == 2) {
					
					tauxBis = Saisie.lire_double("Quel est votre taux en pourcentage (%) ?");
					
					for(Compte_Epargne leCompteEpargne: lesComptesEpargnes) {
						
						leCompteEpargne.setTaux((tauxBis/100+1));
					}
				}
				else if(rep == 3) {
					
					for(Compte_Courant leCompteCourant : lesComptesCourants) {
						
						for(Compte_Epargne leCompteEpargne : lesComptesEpargnes) {
							
							if(leCompteCourant.getNom().equalsIgnoreCase(leCompteEpargne.getNom())) {
								
								System.out.println(leCompteCourant.getNom());
							}
						}
					}
				}
			}
			else if(rep == 5) {
				
				System.out.println("A bientôt, au revoir !");
				boucle = false;
			}
		}
	}
}