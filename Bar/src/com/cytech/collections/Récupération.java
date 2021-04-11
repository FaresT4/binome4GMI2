package com.cytech.collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Récupération {
	public static void lireFichier(File rep) {
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String[] st = br.readLine().split(br.readLine(), ';');
				System.out.println("Nom = "+st[1]+" prix = "+st[3] +"$" );

			}
			br.close();
			fr.close();
			
			}catch (Exception e){
			
				System.out.println("Erreur "+e);
			
			}
	}
	
	public static int lirestock(File rep,String nom) {
		
		int stock=0;
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String[] st = br.readLine().split(br.readLine(), ';');
				 
				if (st[1]==nom){
					
					stock=Integer.parseInt(st[6]);
						
				}
				
			}
			
			br.close();
			fr.close();
		
			}catch (Exception e){
			
				System.out.println("Erreur "+e);
			
			}
		
		return stock;
		
	}
	
	public static String[] lireinfo(File rep,String nom) {
		
		String [] tb = new String[6];
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				String[] st = br.readLine().split(br.readLine(), ';');
				 
				if (st[1]==nom){
					tb=st;
				}
				
			}
			
			br.close();
			fr.close();
		
			}catch (Exception e){
			
				System.out.println("Erreur "+e);
			
			}
		
		return tb;
		
	}
}
