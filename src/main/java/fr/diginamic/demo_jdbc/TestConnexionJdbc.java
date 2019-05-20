package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.exception.TechnicalException;

/**
 * Classe pour se connecter à la base
 * 
 * @author Cécile Peyras
 *
 */
public class TestConnexionJdbc {

	public static void main(String[] args) {

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String driverName = monFichierConf.getString("database.driver");
		String urlName = monFichierConf.getString("database.url");
		String userName = monFichierConf.getString("database.user");
		String password = monFichierConf.getString("database.password");

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new TechnicalException("Le driver JDBC" + driverName + " n'a pas été trouvé");
		}

		Connection maConnexion = null;

		try {
			maConnexion = DriverManager.getConnection(urlName, userName, password);
			System.out.println(maConnexion);
		} catch (SQLException e) {
			throw new TechnicalException("La connexion à la basse de données n'a  pas pu s'établir");
		} finally {
			try {
				maConnexion.close();
			} catch (SQLException e) {
				throw new TechnicalException(
						"La fermeture de la connexion à la base de données n'a pas pu se réaliser");
			}
		}

	}
}
