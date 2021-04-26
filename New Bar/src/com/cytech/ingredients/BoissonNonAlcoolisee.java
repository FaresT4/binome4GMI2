package com.cytech.ingredients;

public class BoissonNonAlcoolisee extends Boisson {
	private double DegreSucre;

	public BoissonNonAlcoolisee(String nom, double contenance, double prix, double degreSucre) {
		super(nom, contenance, prix);
		DegreSucre = degreSucre;
	}

	public double getDegreSucre() {
		return DegreSucre;
	}
	
	public double getDegreAlcool() {
		return 0;
	}

	@Override
	public String toString() {
		return "BoissonNonAlcoolisee [DegreSucre=" + DegreSucre + "]";
	}
}
