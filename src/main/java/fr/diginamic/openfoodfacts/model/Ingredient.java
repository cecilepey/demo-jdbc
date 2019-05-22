package fr.diginamic.openfoodfacts.model;

/**
 * Classe qui gère l'ingrédient
 * 
 * @author Cécile Peyras
 *
 */
public class Ingredient {

	/** id : int */
	private int id;
	/** nom : String */
	private String nom;
	/** idProduit : int */
	private int idProduit;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 */
	public Ingredient(String nom) {
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

	/**
	 * Getter
	 * 
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * Setter
	 * 
	 * @param idProduit
	 *            the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

}
