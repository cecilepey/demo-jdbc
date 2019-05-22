package fr.diginamic.openfoodfacts.service;

import fr.diginamic.openfoodfacts.dao.CategorieDao;
import fr.diginamic.openfoodfacts.dao.IngredientDao;
import fr.diginamic.openfoodfacts.dao.MarqueDao;
import fr.diginamic.openfoodfacts.dao.ProduitDao;
import fr.diginamic.openfoodfacts.model.Produit;

/**
 * Classe qui va gérer les opérations CRUD dans les tableaux
 * 
 * @author Cécile Peyras
 *
 */
public class ProduitService {

	// CRUD
	// Faire une méthode insert

	public static void insert(Produit produit) {

		MarqueDao marqueDao = new MarqueDao();
		if (!marqueDao.marqueExist(produit.getMarque())) {
			marqueDao.marqueAdd(produit.getMarque());
		}

		CategorieDao categorieDao = new CategorieDao();
		if (!categorieDao.categorieExist(produit.getCategorie())) {
			categorieDao.categorieAdd(produit.getCategorie());
		}

		int idMarque = marqueDao.getIdMarque(produit.getMarque());
		int idCategorie = categorieDao.getIdCategorie(produit.getCategorie());
		produit.setIdCategorie(idCategorie);
		produit.setIdMarque(idMarque);

		ProduitDao produitDao = new ProduitDao();
		if (!produitDao.produitExist(produit.getNom())) {
			produitDao.produitAdd(produit);
		}

		IngredientDao ingredientDao = new IngredientDao();

		if (!ingredientDao.ingredientExist(ingredientDao.getIdProduit(produit.getNom()))) {
			for (String ingre : produit.getIngredient()) {
				ingredientDao.ingredientAdd(ingre, produitDao.getIdProduit(produit.getNom()));
			}

		}

	}

}
