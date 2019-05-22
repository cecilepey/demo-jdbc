package fr.diginamic.openfoodfacts.model;

/**
 * Classe qui gère la catégorie
 * 
 * @author Cécile Peyras
 *
 */
public class Categorie {

	/** id : int */
	private int id;
	/** nom : String */
	private String nom;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 */
	public Categorie(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
