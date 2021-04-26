package com.cytech.gestionFichiers;

import java.util.Set;

import com.cytech.ingredients.*;

public interface Barman {
	boolean GererStock(String nom, int quantite);
	double Facturer();
	void Composer();
	void AjouterCocktail(String name, Set<Boisson> ListedeBoissons);
}

	interface Client {
		boolean CommanderB();
		boolean CommanderC();
		boolean CreerCocktail();
	}