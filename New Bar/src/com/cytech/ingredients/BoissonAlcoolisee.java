package com.cytech.ingredients;

public class BoissonAlcoolisee extends Boisson {
	private double DegreAlcool;

	public BoissonAlcoolisee(String nom, double contenance, double prix, double degreAlcool) {
		super(nom, contenance, prix);
		DegreAlcool = degreAlcool;
	}

	public double getDegreAlcool() {
		return DegreAlcool;
	}
	
	public double getDegreSucre() {
		return 0;
	}

	@Override
	public String toString() {
		return "BoissonAlcoolisee [DegreAlcool=" + DegreAlcool + "]";
	}
}
