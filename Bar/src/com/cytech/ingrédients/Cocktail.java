package com.cytech.ingrédients;
import com.cytech.collections.*;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class Cocktail implements Barman {
	 private String nom;
	 private Set<Boisson> listeDeBoissons = new HashSet<Boisson>();
	
	 public Cocktail(String nom, Set<Boisson> listeDeBoissons) {
		super();
		this.nom = nom;
		this.listeDeBoissons = listeDeBoissons;
	 }
	
	 public String getNom() {
		return nom;
	 }
	
	
	 public Set<Boisson> getListeDeBoissons() {
		return listeDeBoissons;
	 }

	@Override
	public String toString() {
		return "Cocktail [nom=" + nom + ", listeDeBoissons=" + listeDeBoissons + "]";
	}
	
	 
	public float calculerPrix() {
		System.out.println( "prix d'un cocktail");
		float prix = 0;
		for(Boisson b: listeDeBoissons) {
			prix += b.getPrix();
		}
		return prix + prix/10;
	}


	public float calculerDegreAlcool() {
			float deg = 0;
			for(Boisson b: listeDeBoissons) {			
				deg += b.getDegreAlcool()*b.getContenance();
			}
			return deg/(listeDeBoissons.size());
		
		}
	public float calculerDegreSucre() {
		float deg = 0;
		for(Boisson b: listeDeBoissons) {			
			deg += b.getDegreSucre()*b.getContenance();
		}
		return deg/(listeDeBoissons.size());
	
	}
	
	public float facturer() 
	{
		return calculerPrix();
	}
	
	
	
	public Cocktail composer() {
		System.out.println("Bonjour, veuillez choisir vos boissons. ");
		com.cytech.collections.Récupération.lireFichier(new File("/data/Documents/Ing1-GM/Informatique/Analyse et programmation orientée objet/Java Project$"));
		int bit=0;
		do {
		String choix;
		Scanner sc=new Scanner(System.in);
    	System.out.println("Veuillez choisir votre boisson à l'aide du nom: ");
    	choix = sc.nextLine();
		String [] tb = new String[6];
		tb=com.cytech.collections.Récupération.lireinfo(new File ("/data/Documents/Ing1-GM/Informatique/Analyse et programmation orientée objet/Java Project$"), choix);
		float contenance=Float.parseFloat(tb[1]);
		float prix=Float.parseFloat(tb[2]);
		Boisson b = new Boisson(choix,contenance, prix);
		switch(choix) {
			case "CocaCola":
				listeDeBoissons.add(b);
			case "RedBull":
				listeDeBoissons.add(b);
			case "Sprite":
				listeDeBoissons.add(b);	
		}
		
    	System.out.println("Voulez-vous entrer d'autres boissons (Oui=0, Non=1 ");
    	bit = sc.nextInt();
		}while(bit==0);

		
		
	}
	
	public void gererstock() {
		
	}

}
