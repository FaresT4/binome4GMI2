package fr.eisti.ing1.java.cdmanager.data;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CDTheque implements Iterable<CDAudio> {
	// la liste ordonnée des CDs
	 private List <CDAudio> catalogue;
	// TODO
	
	// indexations des CDs
	 private Map<Long, CDAudio> cdByIsbn;
	 private Map<String, CDAudio> cdByartistetitle;
	 private Map<String, CDAudio> cdByStyletitle;
	// TODO

    
	/**
	 * constructeur de CDTheque
	 * initialise la liste et les index
	 */
	public CDTheque(){
	     catalogue = new ArrayList<CDAudio>();
	     cdByIsbn = new HashMap<Long, CDAudio>();
	     cdByartistetitle= new HashMap<String, CDAudio>();
	     cdByStyletitle= new HashMap<String, CDAudio>();
		// TODO
	}
	
	public List<CDAudio> getCatalogue() {
		return catalogue;
	}
	
	public void setCatalogue(List<CDAudio> catalogue) {
		this.catalogue = catalogue;
	}
	public Map<Long, CDAudio> getCdByIsbn() {
		return cdByIsbn;
	}



	public void setCdByIsbn(Map<Long, CDAudio> cdByIsbn) {
		this.cdByIsbn = cdByIsbn;
	}

	public Map<String, CDAudio> getCdByartistetitle() {
		return cdByartistetitle;
	}

	public void setCdByartistetitle(Map<String, CDAudio> cdByartistetitle) {
		this.cdByartistetitle = cdByartistetitle;
	}

	public Map<String, CDAudio> getCdByStyletitle() {
		return cdByStyletitle;
	}

	public void setCdByStyletitle(Map<String, CDAudio> cdByStyletitle) {
		this.cdByStyletitle = cdByStyletitle;
	}
	
	/**
 	 * ajout d'un CD dans la CDTheque
	 * @param cd le CD à ajouter
	 * @return true si le CD a bien été ajouté, false s'il y a un 
	 * doublon dans l'indexation ou un problème lors de l'ajout dans la liste
	 */
	public boolean ajouterCD(CDAudio cd) {
		 if(this.catalogue.contains(cd)) {
			 return true;
		 }
		 else {
			 this.catalogue.add(cd);
			 this.cdByIsbn.put(cd.getISBN(), cd);
			 this.cdByartistetitle.put(cd.getArtiste(), cd);
			 this.cdByStyletitle.put(cd.getStyle(), cd);
			 return false;
		 }
		// TODO

	}
   
	/**
 	 * ajout d'un CD dans la CDTheque à partir de ses propriétés
	 * @param iSBN le numéro ISBN du CD à ajouter
	 * @param artiste l'artiste du CD à ajouter
	 * @param titre le titre du CD à ajouter
	 * @param style le style ISBN du CD à ajouter
	 * @param nbrePistes le nombre de psites du CD à ajouter
	 * @return true si le CD a bien été ajouté, false s'il y a un 
	 * doublon dans l'indexation ou un problème lors de l'ajout dans la liste
	 */
	public boolean ajouterCD(long iSBN, String artiste, String titre, String
			style, int nbrePistes){
		CDAudio cd = new CDAudio(iSBN, artiste, titre, style, nbrePistes);
		return this.ajouterCD(cd);
	}

	/**
	 * suppression d'un CD dans la CDTheque à partir de sa référence
	 * @param cd le CD à supprimer
	 * @return true si le CD était présent dans la CDTheque et a bien été
	 * supprimé
	 */
	public boolean supprimerCD(CDAudio cd) {
		// TODO
		 if(this.catalogue.contains(cd)) {
			 this.cdByIsbn.remove(cd.getISBN(), cd);
			 this.cdByartistetitle.remove(cd.getArtiste(), cd);
			 this.cdByStyletitle.remove(cd.getStyle(), cd);
			 return true;
		 }
		 else {
			 return false;
		 }
	}
			
	/**
	 * suppression d'un CD dans la CDTheque à partir de son numéro ISBN
	 * @param iSBN le numéro ISBN du CD à supprimer
	 * @return true si le CD était présent dans la CDTheque et a bien été
	 * supprimé
	 */
	public boolean supprimerCD(long iSBN) {
		// suppression du CD en se servant de son indexation par ISBN
		return supprimerCD(iSBN, indexISBN);
	}
		
	/**
	 * suppression d'un CD dans la CDTheque à partir de son artiste
	 * et de son titre
	 * @param artiste l'artiste du CD à supprimer
	 * @param titre le titre du CD à supprimer
	 * @return true si le CD était présent dans la CDTheque et a bien été
	 * supprimé
	 */
	public boolean supprimerCDparArtisteTitre(String artiste, String titre) {
		// suppression du CD en se servant de son indexation par artiste et
		// titre
		return supprimerCD(clef(artiste, titre), cdByArtistTitle); 
	}

	/**
	 * suppression d'un CD dans la CDTheque à partir de son style
	 * et de son titre
	 * @param style le style du CD à supprimer
	 * @param titre le titre du CD à supprimer
	 * @return true si le CD était présent dans la CDTheque et a bien été
	 * supprimé
	 */
	public boolean supprimerCDparStyleTitre(String style, String titre) {
		// suppression du CD en se servant de son indexation par style et
		// titre
		return supprimerCD(clef(style, titre), cdByStyleTitle); // indexStyleTitre est la map 
	}

	/**
	 * recherche d'un CD par son numéro ISBN
	 * @param iSBN le numéro ISBN du CD à rechercher
	 * @return le CD correspondant au numéro ISBN s'il est présent dans la
	 * CDThèque, null sinon
	 */
	public CDAudio rechercherCD(long iSBN) {
		CDAudio cd = null;
		for(int i=0;i<catalogue.size();i++) {
			if(iSBN == this.catalogue.get(i).getISBN()) {
				cd=this.catalogue.get(i);
				break;
			}
			else {
				cd=null;
			}
		}
		return cd;
	}

	/**
	 * recherche d'un CD par son artiste et titre
	 * @param artiste l'artiste du CD à rechercher
	 * @param titre le titre du CD à rechercher
	 * @return le CD correspondant aux critères de recherche s'il est présent dans la
	 * CDThèque, null sinon
	 */
	public CDAudio getCDparArtisteTitre(String artiste, String titre) {
		CDAudio cd=null;
		// TODO
		for(int i=0;i<catalogue.size();i++) {
			if(artiste == this.catalogue.get(i).getArtiste() && titre == this.catalogue.get(i).getTitre()) {
				cd=this.catalogue.get(i);
				break;
			}
			else {
				cd=null;
			}
		}
		return cd;
	}
	
	/**
	 * recherche d'un CD par son style et titre
	 * @param style l'artiste du CD à rechercher
	 * @param titre le titre du CD à rechercher
	 * @return le CD correspondant aux critères de recherche s'il est présent 
	 * dans la CDThèque, null sinon
	 */
	public CDAudio getCDparStyleTitre(String style, String titre) {
		CDAudio cd=null;
		// TODO
		for(int i=0;i<catalogue.size();i++) {
			if(style == this.catalogue.get(i).getStyle() && titre == this.catalogue.get(i).getTitre()) {
				cd=this.catalogue.get(i);
				break;
			}
			else {
				cd=null;
			}
		}
		return cd;
	}

	/**
	 * construction d'un itérateur pour parcourir la CDThèque
	 * @return un itérateur pour parcourir la CDThèque
	 */
	public Iterator<CDAudio> iterator() {
		return catalogue.iterator();
	}

	/**
	 * construction d'un itérateur ordonné pour parcourir la CDThèque
	 * @return un itérateur ordonné pour parcourir la CDThèque
	 */
	public ListIterator<CDAudio> listIterator() {
		return catalogue.listIterator();
	}

	/**
	 * sauvegarde d'une CDTheque dans un fichier
	 * TODO
	 * @param nomFichier le nom du fichier contenant la sauvegarde de la
	 * CDThèque
	 */
    public void sauvegarder(String nomFichier){
      //TODO
    	try {
    		FileOutputStream fos = new FileOutputStream(nomFichier);
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		oos.writeObject(catalogue);
    		oos.close();
    		fos.close();
    		System.out.println("File saved");
    	}
    	catch (Exception e) {
    		System.out.println("Error in output:" + e.toString());    	}
   	}

	/**
	 * chargement d'une CDTheque à partir d'un fichier
	 * TODO (pour l'instant chargement en dur)
	 * @param nomFichier le nom du fichier contenant la sauvegarde de la
	 * CDThèque
	 */
  	public void charger(String nomFichier) {
		// Pour l'instant chargement en dur de qqs CDs
	    try
	    {
	        FileInputStream fis = new FileInputStream("movies.txt");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        catalogue = (List<CDAudio>) ois.readObject();
	        Iterator<CDAudio> it = this.catalogue.iterator();
	        while (it.hasNext()) {
	        	CDAudio cd = it.next();
	        	cd.toString();
	        	this.ajouterCD(cd);
	        }
	        ois.close();
	        System.out.println("File Imported");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error in output:" + e.toString());
	    }
	}

	/**
	 * suppression d'un CD à partir d'une clef d'indexation et d'un index
	 * @param clef la clef d'indéxation
	 * @param index l'index dans lequel chercher le CD à partir de la clef
	 * @return true si le CD était présent dans la CDTheque et a bien été
	 * supprimé
	 */
	private <K> boolean supprimerCD(K clef, Map<K,CDAudio> index) { 
        // TODO
		if(index.containsKey(clef)) {
			CDAudio cd = index.get(clef);
			return this.supprimerCD(cd);
		}
		else {
			return false;
		}
	}

	/**
	 * fabrication d'une clef normalisée à partir d'un tuple de chaînes
	 * de caractères
	 * @param parties le tuple à partir duquel fabriquer la clef
	 * @return la clef constitués des différentes parties (normalisée en
	 * majuscule) et séparées par le caractère '-'
	 * @throws IllegalArgumentException le tuple doit contenir au moins un
	 * élément
	 */
	private static String clef(String... parties) {
		// TODO
        String clefResultat;
        if (parties.length < 1) {
            // NB : ne doit pas arriver ici
            throw new IllegalArgumentException("clé d'indexation vide");
        }
        clefResultat = parties[0].toUpperCase();
        for (int i = 1; i < parties.length; i++) {
            clefResultat += "-" + parties[i].toUpperCase();
        }
        return clefResultat;
	}

	/**
	 * fabrication d'une clef à partir des propriétés artiste et titre d'un CD
	 * @param cd le CD dont on veut extraire la clef
	 * @return la clef constituée à partir du nom d'artiste et du titre du CD
	 */
	private static String clefArtisteTitre(CDAudio cd) {
		return clef(cd.getArtiste(),cd.getTitre());
	}

	/**
	 * fabrication d'une clef à partir des propriétés style et titre d'un CD
	 * @param cd le CD dont on veut extraire la clef
	 * @return la clef constituée à partir du style et du titre du CD
	 */
	private static String clefStyleTitre(CDAudio cd) {
		
		return clef(cd.getStyle(),cd.getTitre());
	}


}
