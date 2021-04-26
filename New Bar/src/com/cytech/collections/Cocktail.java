package com.cytech.collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.cytech.ingredients.*;

public class Cocktail {
	private Set<Boisson> ListedeBoissons = new HashSet<Boisson>();
	public Cocktail(Set<Boisson> listedeBoissons) {
		super();
		ListedeBoissons = listedeBoissons;
	}
	
	public Set<Boisson> getListedeBoissons() {
		return ListedeBoissons;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ListedeBoissons == null) ? 0 : ListedeBoissons.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cocktail other = (Cocktail) obj;
		if (ListedeBoissons == null) {
			if (other.ListedeBoissons != null)
				return false;
		} else if (!ListedeBoissons.equals(other.ListedeBoissons))
			return false;
		return true;
	}
	
	

	public void AjouterBoisson(Boisson b) {
		ListedeBoissons.add(b);
	}
	
	public double CalculerPrix() {
		System.out.println( "prix du Cocktail");
		double prix = 0;
		for(Boisson b: ListedeBoissons) {
			prix += b.getPrix();
		}
		return prix + prix/10;
	}


	public double CalculerDegreAlcool() {
			double deg = 0;
			for(Boisson b: ListedeBoissons) {			
				deg += b.getDegreAlcool()*b.getContenance();
			}
			return deg/(ListedeBoissons.size());
		
		}
	public double CalculerDegreSucre() {
		double deg = 0;
		for(Boisson b: ListedeBoissons) {			
			deg += b.getDegreSucre()*b.getContenance();
		}
		return deg/(ListedeBoissons.size());
	
	}
	
	public double Facturer() {
		return CalculerPrix();
	}
	
	public void Composer() {
		System.out.println("Espace de composition de Cocktails");
		com.cytech.gestionFichiers.Recuperer.lireFichierB(new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt"));
		String check = "yes";
		Scanner sc=new Scanner(System.in);
		while(check.equals("yes")){
		
		String choix;
    	System.out.println("Veuillez choisir votre boisson a l'aide du nom:");
    	choix = sc.nextLine();
		String [] tb = new String[6];
		tb=com.cytech.gestionFichiers.Recuperer.lireinfoB(new File ("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt"), choix);
		double contenance=Double.parseDouble(tb[1]);
		double prix=Double.parseDouble(tb[2]);
		double DegreSucre=Double.parseDouble(tb[3]);
		double DegreAlcool=Double.parseDouble(tb[4]);
		if(DegreSucre!=0) {
			AjouterBoisson(new BoissonNonAlcoolisee(choix, contenance, prix, DegreSucre));
		}
		else {
			AjouterBoisson(new BoissonAlcoolisee(choix, contenance, prix, DegreAlcool));
		}
    	System.out.println("Voulez-vous ajouter d'autres boissons ? (oui=yes ou non=no)");//bug//
    	check = sc.nextLine();
		}
		
		String nom;
		System.out.println("Veuillez choisir un nom pour votre cocktail:");
		sc.reset();
    	nom = sc.nextLine();
    	sc.close();
		AjouterCocktail(nom, ListedeBoissons);
	}
	
	public void AjouterCocktail(String nom, Set<Boisson> ListedeBoissons) {
		//Creer une methode qui ecrit dans un fichier Cocktail.txt afin d'ajouter le nom et la composition du cocktail//
		if(com.cytech.gestionFichiers.Recuperer.lirenom("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Cocktail.txt", nom)) {
		
		try {
			FileWriter fw = new FileWriter("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Cocktail.txt", true);
			fw.write("\n");
			fw.write(nom);
			for(Boisson b: ListedeBoissons) {
			fw.write(";"+b.getNom());
			}
			fw.write(";"+"stop");
			fw.close();
		}
		catch (Exception e) {
			System.out.println("Erreur "+e);
		}
		}
		else {
			System.out.println("Le nom de votre cocktail est deja present dans notre bar.");
		}
	}
	
	public boolean GererStock(String nom, int quantite) {
		//La methode GererStock() sera capable d'ecrire dans le fichier boisson.txt ou autre afin de modifier le stock//

		 try {
		File entree = new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt");
		File sortie = new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson1.txt");
		BufferedReader br = new BufferedReader(new FileReader(entree));
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		String ligne="";

		while (br.ready()){
		ligne=br.readLine();

		if(ligne.startsWith(nom)){
		//System.out.println(ligne);
		String[] st = ligne.split(";");
		int new_quantite = Integer.parseInt(st[5])+quantite;
		System.out.println(new_quantite);
		bw.write(st[0]+";"+st[1]+";"+st[2]+";"+st[3]+";"+st[4]+";"+Integer.toString(new_quantite));
		bw.newLine();

		}else{
			bw.write(ligne);
			bw.newLine();
		}
		}
		bw.close();
		br.close();
		return true; //On peut avoir un bug ici si la boisson n'est pas presente dans la liste//
		}catch (Exception e){
		System.out.println("Erreur Gerer Stock "+e);
		return false;
		}
		}
	
	public boolean CommanderB() {
		com.cytech.gestionFichiers.Recuperer.lireFichierB(new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt"));
		System.out.println("Veuillez choisir votre boisson a l'aide du nom:");
		Scanner sc=new Scanner(System.in);
		String nom = sc.nextLine();
    	//sc.close();
    	System.out.printf(nom);
		String [] tb = com.cytech.gestionFichiers.Recuperer.lireinfoB((new File ("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt")), nom);
		int stock = Integer.parseInt(tb[5]);
		System.out.printf("Le stock de votre est boisson est %d\n", stock);
		
		
		System.out.printf("Combien de verre(s) Voulez-vous?");
		//Scanner sc1=new Scanner(System.in);
		
    	int quantite = Integer.parseInt(sc.nextLine());
    	sc.close();
		if(stock-quantite>=0) {
			GererStock(nom, -quantite);//pour retirer la boisson commandee du stock par la quantite introduite (negative ici)//
			renommer();
			System.out.println("Voici vos/votre boisson(s).");
			return true;
		}
		else {
			System.out.println("Quantite>Stock");
			return false;
		}
	}
	
	public static void renommer() {
		File entree = new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt");
		File sortie = new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson1.txt");
		entree.delete();
		sortie.renameTo(entree);
	}
	
	public boolean CommanderC() {
		com.cytech.gestionFichiers.Recuperer.lireFichierC(new File("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Cocktail.txt"));
		System.out.println("Veuillez choisir votre coktail a l'aide du nom:");
		String nom;
		Scanner sc=new Scanner(System.in);
    	nom = sc.nextLine();
    	sc.close();
		String [] tb = null;
		tb=com.cytech.gestionFichiers.Recuperer.lireinfoC(new File ("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Cocktail.txt"), nom);
		int taille = tb.length-2;
		for(int i=1;i<=taille;i++) {
			Boisson b = new BoissonAlcoolisee(tb[i],0,0,0);
			AjouterBoisson(b);
		}
    	
		int check = 1;
		while(taille>0) {
			String [] tbn = null;
			tbn=com.cytech.gestionFichiers.Recuperer.lireinfoB(new File ("h:\\Documents\\Ing1-GM\\Informatique\\Analyse et programmation orientée objet\\Java Project\\Boisson.txt"), tb[taille]);
			int stock=Integer.parseInt(tbn[5]);
			Boisson b = new BoissonAlcoolisee(tbn[1],0,0,0);
			AjouterBoisson(b);
			if(stock-1>=0) {
				
			}
			else {
				check=0;
				break;
			}
			taille--;
		}
		if(check==1) {
			for(Boisson b: ListedeBoissons)  {
			GererStock(b.getNom(),-1);
			renommer();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean CreerCocktail() {
		Composer();
		String choix;
		System.out.println("Voulez-vous le commander des maintenant? (Oui=Yes Non=");
		Scanner sc=new Scanner(System.in);
    	choix = sc.nextLine();
    	sc.close();
    	if(choix=="Yes") {
    		return CommanderC();
    	}
    	else {
    		System.out.println("Vous allez etre rediriger vers ...");
    		return false;
    	}
	}
}
