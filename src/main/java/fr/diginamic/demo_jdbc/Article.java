package fr.diginamic.demo_jdbc;

/**
 * Classe qui gère les articles de la base de données
 * 
 * @author Cécile Peyras
 *
 */
public class Article {

	/** id : int */
	private int id;
	/** designation : String : nom de l'article */
	private String designation;
	/** fournisseur : String : nom du fournisseur */
	private String fournisseur;
	/** prix : double : prix de l'article */
	private double prix;

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            = id
	 * @param designation
	 *            = nom du produit
	 * @param fournisseur
	 *            = nom du fournisseur
	 * @param prix
	 *            = prix de l'article
	 */
	public Article(int id, String designation, String fournisseur, double prix) {
		super();
		this.id = id;
		this.designation = designation;
		this.fournisseur = fournisseur;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", designation=" + designation + ", fournisseur=" + fournisseur + ", prix=" + prix
				+ "]";
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
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Setter
	 * 
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Getter
	 * 
	 * @return the fournisseur
	 */
	public String getFournisseur() {
		return fournisseur;
	}

	/**
	 * Setter
	 * 
	 * @param fournisseur
	 *            the fournisseur to set
	 */
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Setter
	 * 
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
