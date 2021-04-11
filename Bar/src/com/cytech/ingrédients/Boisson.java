package com.cytech.ingrédients;

abstract public class Boisson {
	private String Nom;
	private float Contenance;
	private float prix;
	
	public Boisson(String nom, float contenance, float prix) {
		super();
		Nom = nom;
		Contenance = contenance;
		this.prix = prix;
	}

	public String getNom() {
		return Nom;
	}

	public float getContenance() {
		return Contenance;
	}

	public float getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Boisson [Nom=" + Nom + ", Contenance=" + Contenance + ", prix=" + prix + "]";
	}
	
	abstract public float getDegreSucre();
	abstract public float getDegreAlcool();
}
	
	abstract class BoissonNonAlcoolisee extends Boisson {
		private float degreSucre;

		public BoissonNonAlcoolisee(String nom, float contenance, float prix, float degreSucre) {
			super(nom, contenance, prix);
			this.degreSucre = degreSucre;
		}

		public float getDegreSucre() {
			return degreSucre;
		}

		@Override
		public String toString() {
			return "BoissonNonAlcoolisee [degreSucre=" + degreSucre + "]";
		}
	}
	
	abstract class BoissonAlcoolisee extends Boisson {
		private float degreAlcool;

		public BoissonAlcoolisee(String nom, float contenance, float prix, float degreAlcool) {
			super(nom, contenance, prix);
			this.degreAlcool = degreAlcool;
		}

		public float getDegreAlcool() {
			return degreAlcool;
		}

		@Override
		public String toString() {
			return "BoissonAlcoolisee [degreAlcool=" + degreAlcool + "]";
		}
		
	}
