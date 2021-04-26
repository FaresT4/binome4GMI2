package com.cytech.gestionFichiers;

import java.util.HashSet;
import java.util.Set;

import com.cytech.collections.Cocktail;
import com.cytech.ingredients.Boisson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Boisson> LDB = new HashSet<Boisson>();
		Cocktail ck = new Cocktail(LDB);
		ck.CreerCocktail();
	}

}
