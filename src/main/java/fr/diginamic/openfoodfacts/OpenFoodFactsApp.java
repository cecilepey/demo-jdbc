package fr.diginamic.openfoodfacts;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.openfoodfacts.model.Produit;
import fr.diginamic.openfoodfacts.service.ProduitService;

public class OpenFoodFactsApp {

	public static void main(String[] args) {

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		} catch (SQLException e1) {
			throw new TechnicalException("La connexion ne s'est pas établi dans le main", e1);
		}

		String fichier = "C:\\Users\\Cécile Peyras\\Documents\\workspace-sts-3.8.4.RELEASE\\demo-jdbc\\data\\openFoodFacts.csv";

		List<String> listeFichier = null;

		try {
			listeFichier = FileUtils.readLines(new File(fichier), "UTF-8");
			listeFichier.remove(0);
			for (String line : listeFichier) {
				System.out.println(line);
				Produit produit = new Produit(line);
				ProduitService.insert(produit);
			}
		} catch (IOException e) {
			throw new TechnicalException("Le fichier n'a pas été trouvé", e);
		}

	}

}
