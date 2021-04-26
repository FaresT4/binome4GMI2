package com.cytech.ingredients;

public abstract class Boisson {
	private String nom;
	private double contenance;
	private double prix;
	
	public Boisson(String nom, double contenance, double prix) {
		super();
		this.nom = nom;
		this.contenance = contenance;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public double getContenance() {
		return contenance;
	}

	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Boisson [nom=" + nom + ", contenance=" + contenance + ", prix=" + prix + "]";
	}
	
	 public abstract double getDegreSucre();
	 public abstract double getDegreAlcool();
}
