package com.cytech.collections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

import com.cytech.ingrédients.Boisson;

public class Sauvegarde {

  public static void main(String[] args) {
      Set<Boisson> listeDeBoissons = new HashSet<Boisson> ();
     
     try {
       FileOutputStream fileOut = new FileOutputStream("sauvegarde.txt");
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(listeDeBoissons);
       out.close();
       fileOut.close();
       System.out.println("\nSauvegarde terminée avec succès...\n");
 
     } catch (FileNotFoundException e) {
       e.printStackTrace();
     } catch (IOException e) {
       e.printStackTrace();
     }
  }
}