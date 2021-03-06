

import java.io.IOError;
import java.util.Scanner;
import fr.eisti.ing1.java.cdmanager.data.*;

public class CDThequeManager {
	/**
	    * @param args (non utilisés ici)
	    */
		public static void main(String[] args) {
			CDTheque cds; // une cdthèque
			int choix; // choix du menu 
			
			
			cds = new CDTheque();
			choix=-1; 
	    
			try {
			while (choix!=0) {
				afficherMenu();
				choix = saisieChoix(0,10);	
				System.out.println("\n--------------------------------------------");
				switch (choix){
					case 1 :   
						cds.charger(""); // TODO à compléter plus tard
						break;
					case 2 :   
						ajouterCD(cds);
						break;
					case 3 :   
						supprimerCDparISBN(cds); 
						break;									                    
					case 4 :   
						supprimerCDparArtisteTitre(cds);
						break;
					case 5 :
						supprimerCDparStyleTitre(cds);
						break;
					case 6 :
						rechercheParISBN(cds);
						break;
					case 7 :
						rechercheParArtisteTitre(cds);
						break;
					case 8 :
						rechercheParStyleTitre(cds);
						break;
					case 9 :
						afficherCDTheque(cds);
						break;
					case 10 :
						cds.sauvegarder("");	// TODO à compléter
						break;
					case 0 :   System.out.println("Bye Bye");
						break;
				}
			}
			} catch (IOError e) {
				System.err.println("Erreur grave d'entrée/sortie, fin de l'application");
			} finally {
				// TODO : proposer une sauvegarde de la CDTheque si ce n'est pas
				// fait
			}
		}


		// Methodes Privées : menu + utilitaires saisies et différents cas
		// d'utilisation


		/**
		 * affichage du menu
		 */
		private static void afficherMenu() {
				System.out.println("");
				System.out.println("Menu :");
				System.out.println("(1) Charger la CDTheque");
				System.out.println("(2) Ajouter CD");
				System.out.println("(3) Supprimer CD par ISBN");
				System.out.println("(4) Supprimer CD par nom d'artiste et titre d'album");
				System.out.println("(5) Supprimer CD par style et titre d'album");
				System.out.println("(6) Rechercher CD par ISBN");
				System.out.println("(7) Rechercher CD par nom d'artiste et titre d'album");
				System.out.println("(8) Rechercher CD par style et titre d'album");
				System.out.println("(9) Afficher le contenu de la CDTheque");
				System.out.println("(10) Enregistrer la CDTheque dans un fichier ");
				System.out.println("(0) Quitter");
				System.out.println("");
		}

		/**
		 * lire une information au clavier avec un message d'attente
		 * @param messageInfo le message d'attente (prompt)
		 * @return chaîne lu au clavier
		 */
	    private static String lireInfo(String messageInfo) {
			String infoLue;
			System.out.print(messageInfo + " : ");
			// lecture clavier et nettoyage des espaces en tête ou en queue de
			// chaîne
			 Scanner s = new Scanner(System.in);
			 infoLue = s.nextLine();
			return infoLue;
		}

		/**
		 * lire le choix de l'utilisateur au clavier jusqu'à ce qu'il soit correct
		 * @param borneMin choix minimal
		 * @param borneMax choix maximal
		 * @return choix numérique lu au clavier
		 */
		private static int saisieChoix(int borneMin, int borneMax) {
			int choix = -1;
			boolean erreur;
			String lecture; // buffer de lecture clavier

			// lecture du choix jusqu'à ce qu'elle soit correcte
			do {
				try {
					erreur = false;
					lecture = lireInfo("Votre choix");
					choix = Integer.parseInt(lecture);
				} catch (NumberFormatException e) {
					// ce n'est pas un entier qui a été lu au clavier
					erreur = true;
				}
			} while (erreur || choix<0 || choix>11);
			return choix;
		}
		
		/**
		 * lire un numéro d'ISBN (entier long) au clavier jusqu'à ce qu'il soit
		 * correct
		 * @return numéro lu au clavier
		 */
		private static long saisieISBN(){
	        // TODO
			long ISBN;
			boolean erreur;
			String lecture; // buffer de lecture clavier

			// lecture du choix jusqu'à ce qu'elle soit correcte
			do {
				try {
					erreur = false;
					lecture = lireInfo("Votre choix");
					ISBN = Long.parseLong(lecture);
				} catch (NumberFormatException e) {
					// ce n'est pas un entier qui a été lu au clavier
					erreur = true;
				}
			} while (erreur);
			return ISBN;
		}

		/**
		 * lire un nombre de pistes (entier) au clavier jusqu'à ce qu'il soit
		 * correct
		 * @return numéro lu au clavier
		 */
		private static int saisieNbrePistes() {
			
			 // TODO
			int NbrePistes;
			boolean erreur;
			String lecture; // buffer de lecture clavier

			// lecture du choix jusqu'à ce qu'elle soit correcte
			do {
				try {
					erreur = false;
					lecture = lireInfo("Votre choix");
					NbrePistes = Integer.parseInt(lecture);
				} catch (NumberFormatException e) {
					// ce n'est pas un entier qui a été lu au clavier
					erreur = true;
				}
			} while (erreur);
			return NbrePistes;
		}

		/**
		 * saisie d'un nouveau CD puis ajout de celui-ci dans la CDTheque
		 * @param cds la cdtheque à modifier
		 */
		private static void ajouterCD(CDTheque cds){
			long iSBN;
	        String artiste;
	        String titre;
	        String style;
	        String chaineNbrePistes;
	        int nbrePistes;
	        boolean erreur;
	        boolean operationOK;
	       
	        // lectures clavier
	        System.out.println("Saisie d'un nouveau CD : ");
	        iSBN = saisieISBN();
	        artiste = lireInfo("   artiste");
	        titre = lireInfo("   titre album");
	        style = lireInfo("   style de l'album");
	        nbrePistes = saisieNbrePistes();
	        operationOK = cds.ajouterCD(iSBN, artiste, titre, style, nbrePistes);
	        if (operationOK) {
	            System.out.println("CD ajouté avec succès");
	        } else {
	            System.out.println("Problème dans l'ajout du CD");
	        }
			
		}

		/**
		 * suppression d'un CD dans la CDTheque dont l'ISBN est saisi au clavier
		 * @param cds la cdtheque à modifier
		 */
		private static void supprimerCDparISBN(CDTheque cds) {
			boolean operationOK;
			long iSBN;
		
			System.out.println("Supprimer un CD par son ISBN.");
			iSBN = saisieISBN();		
			// TODO
	        operationOK = cds.supprimerCD(iSBN);
	        if (operationOK) {
	            System.out.println("CD supprimé avec succès");
	        } else {
	            System.out.println("Problème dans la suppression du CD. Il n'est pas présent.");
	        }
		}
			
			
		/**
		 * suppression d'un CD dans la CDTheque dont l'artiste et le titre
		 * sont saisis au clavier
		 * @param cds la cdtheque à modifier
		 */
		private static void supprimerCDparArtisteTitre(CDTheque cds) {
			boolean operationOK;
			String artiste;
			String titre;
		
	        // TODO
	        operationOK = cds.supprimerCDparArtisteTitre(artiste, titre);
	        if (operationOK) {
	            System.out.println("CD supprimé avec succès");
	        } else {
	            System.out.println("Problème dans la suppression du CD. Il n'est pas présent.");
	        }
		}

		/**
		 * suppression d'un CD dans la CDTheque dont le style et le titre
		 * sont saisis au clavier
		 * @param cds la cdtheque à modifier
		 */
		private static void supprimerCDparStyleTitre(CDTheque cds) {
			boolean operationOK;
			String style;
			String titre;
		
			System.out.println("Supprimer un CD par le style et le titre de l'album.");
			style = lireInfo("   style");
			titre = lireInfo("   titre");	

			// TODO
	        operationOK = cds.supprimerCDparStyleTitre(style, titre);
	        if (operationOK) {
	            System.out.println("CD supprimé avec succès");
	        } else {
	            System.out.println("Problème dans la suppression du CD. Il n'est pas présent.");
	        }
		}

		/**
		 * recherche d'un CD dans la CDTheque à partir de son numéro ISBN
		 * saisi au clavier
		 * @param cds la cdtheque à consulter
		 */
		private static void rechercheParISBN(CDTheque cds) {
			CDAudio cdTrouve; // le CD recherché
			long iSBN;
	        // TODO
			if(cds.rechercherCD(iSBN) != null) {
				System.out.println("Votre cd est présent dans la CDTheque.");
			}
			else {
				System.out.println("Votre cd n'est pas présent dans la CDTheque.");

			}
		}

		/**
		 * recherche d'un CD dans la CDTheque à partir de son artiste et de son
		 * titre saisis au clavier
		 * @param cds la cdtheque à consulter
		 */
		private static void rechercheParArtisteTitre(CDTheque cds) {
			CDAudio cdTrouve; // le CD recherché
			String artiste;
			String titre;
		
	        //TODO
			if(cds.getCDparArtisteTitre(artiste, titre) != null) {
				System.out.println("Votre cd est présent dans la CDTheque");
			}
			else {
				System.out.println("Votre cd n'est pas présent dans la CDTheque.");
			}
		}
		
		/**
		 * recherche d'un CD dans la CDTheque à partir de son style et de son
		 * titre saisis au clavier
		 * @param cds la cdtheque à consulter
		 */
		private static void rechercheParStyleTitre(CDTheque cds){
			CDAudio cdTrouve; // le CD recherché
			String style;
			String titre;
		
	     // TODO
			if(cds.getCDparStyleTitre(style, titre) != null) {
				System.out.println("Votre cd est présent dans la CDTheque");
			}
			else {
				System.out.println("Votre cd n'est pas présent dans la CDTheque.");
			}
		}

		/**
		 * affichage de la CDTheque
		 * @param cds la cdtheque
		 */
		private static void afficherCDTheque(CDTheque cds) {
			System.out.println(" Ma Super CDThèque ");
			System.out.println(" ------ D E B U T ------ ");
			for (CDAudio cd : cds) {
				System.out.println(" - " + cd);
			}
			System.out.println(" ------- F I N --------- ");

		}

}
