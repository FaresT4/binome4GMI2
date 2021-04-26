package com.cytech.gestionFichiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Recuperer {
	public static void lireFichierB(File rep) {
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String ligne = br.readLine();
				String[] st = ligne.split(";");
				System.out.println("Nom = "+st[0]+" prix = "+st[2] +"$" );

			}
			br.close();
			fr.close();
			
			}catch (Exception e){
			
				System.out.println("Erreur dans lirefichier "+e);
			
			}
	}
	
	public static void lireFichierC(File rep) {
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				String ligne = br.readLine();
				System.out.println(ligne);

			}
			br.close();
			fr.close();
			
			}catch (Exception e){
			
				System.out.println("Erreur dans lirefichier "+e);
			
			}
	}
	
	public static boolean lirenom(String  string,String nom) {
		
		int check=0;
		boolean b=true;
		
		try{
			
			FileReader fr =new FileReader(string);
			BufferedReader br= new BufferedReader(fr);
			while(br.ready() & check==0) {
				
				String[] st = br.readLine().split(";");
				 
				if (st[0]==nom){
					
					b=false;
					check=1;
				}
				
			}
			
			br.close();
			fr.close();
		
			}catch (Exception e){
			
				System.out.println("Erreur lirenom"+e);
			
			}
		return b;
	}
	
	public static int lirestock(File rep,String nom) {
		
		int stock=0;
		
		try{
			
			FileReader fr = new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String[] st = br.readLine().split(br.readLine(), ';');
				 
				if (st[0]==nom){
					
					stock=Integer.parseInt(st[4]);
						
				}
				
			}
			
			br.close();
			fr.close();
		
			}catch (Exception e){
			
				System.out.println("Erreur "+e);
			
			}
		
		return stock;
		
	}
	
	public static String[] lireinfoB(File rep,String nom) {
		
		String [] tb = null;
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String ligne = br.readLine();
				String[] st = ligne.split(";");
				System.out.println(nom);
				System.out.println("Nom = "+st[0]+ " Contenance ="+st[1]+" prix = "+st[2] +"$" );
				 
				if (st[0].equals(nom)){
					
					System.out.println("Trouvée ! ");
					tb=st;
					br.close();
					fr.close();
					return st;
				}
				
			}
			
			br.close();
			fr.close();
		
			}catch (Exception e){
			
				System.out.println("Erreur sur lire info "+e);
			
			}
		
		return tb;
		
		
	}
	
	public static String[] lireinfoC(File rep,String nom) {
		
		String [] tb = new String[20];
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String ligne = br.readLine();
				String[] st = ligne.split(";");
				br.close();
				fr.close();
				return tb=st;
				
			}
			
			br.close();
			fr.close();
		
			}catch (Exception e){
			
				System.out.println("Erreur sur lire info "+e);
			
			}
		
		return tb;
		
		
	}
}
