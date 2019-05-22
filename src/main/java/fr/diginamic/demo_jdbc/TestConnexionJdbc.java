package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;

/**
 * Classe pour se connecter à la base
 * 
 * @author Cécile Peyras
 *
 */
public class TestConnexionJdbc {

	/** LOGGER : Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger("monLogger");

	/**
	 * Classe qui gère la connexion
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String driverName = monFichierConf.getString("database.driver");
		String urlName = monFichierConf.getString("database.url");
		String userName = monFichierConf.getString("database.user");
		String password = monFichierConf.getString("database.password");

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Le driver JDBC" + driverName + " n'a pas été trouvé", e);
			throw new TechnicalException("Le driver JDBC" + driverName + " n'a pas été trouvé", e);
		}

		Connection maConnexion = null;
		Statement monStatement = null;
		ResultSet curseur = null;

		try {
			maConnexion = DriverManager.getConnection(urlName, userName, password);
			System.out.println(maConnexion);
			monStatement = maConnexion.createStatement();

			// Créer les éléments dans le tableau

			monStatement.executeUpdate(
					"INSERT INTO article (ID, DESIGNATION, FOURNISSEUR, PRIX) VALUES(1,'Article 1','fournisseur 1', 10)");

			monStatement.executeUpdate(
					"INSERT INTO ARTICLE (ID,DESIGNATION,FOURNISSEUR, PRIX) VALUES(2,'Article 2','fournisseur 1', 0.5)");
			monStatement.executeUpdate(
					"INSERT INTO ARTICLE (ID,DESIGNATION,FOURNISSEUR, PRIX) VALUES(3,'Article 3','fournisseur 2', 25)");
			monStatement.executeUpdate(
					"INSERT INTO ARTICLE (ID,DESIGNATION,FOURNISSEUR, PRIX) VALUES(4,'Article 4','fournisseur 3', 15)");

			// Modifier le prix quand supérieur à 10
			monStatement.executeUpdate("UPDATE ARTICLE SET PRIX = PRIX*1.25 WHERE PRIX >10");

			curseur = monStatement.executeQuery("SELECT ID, DESIGNATION, FOURNISSEUR, PRIX FROM ARTICLE");

			ArrayList<Article> listeArticle = new ArrayList<>();

			while (curseur.next()) {

				Integer id = curseur.getInt("ID");

				String designation = curseur.getString("DESIGNATION");

				String fournisseur = curseur.getString("FOURNISSEUR");

				Double prix = curseur.getDouble("PRIX");

				Article article = new Article(id, designation, fournisseur, prix);

				listeArticle.add(article);

			}

			for (Article article : listeArticle) {
				System.out.println(article.toString());

			}

			curseur = monStatement.executeQuery("SELECT AVG(PRIX) AS PRIXMOYEN FROM ARTICLE");

			if (curseur.next()) {
				double moyenne = curseur.getDouble("PRIXMOYEN");
				System.out.println(moyenne);
			}

			monStatement.executeUpdate("DELETE FROM ARTICLE");

		} catch (SQLException e) {
			LOGGER.error("La connexion à la basse de données n'a  pas pu s'établir", e);
			throw new TechnicalException("La connexion à la basse de données n'a  pas pu s'établir", e);
		} finally {
			try {
				if (curseur != null) {
					curseur.close();
				}
				if (monStatement != null) {
					monStatement.close();
				}
				if (maConnexion != null) {
					maConnexion.close();
				}

			} catch (SQLException e) {
				LOGGER.error("La fermeture de la connexion à la base de données n'a pas pu se réaliser.", e);
				throw new TechnicalException("La fermeture de la connexion à la base de données n'a pas pu se réaliser",
						e);
			}
		}

	}
}
