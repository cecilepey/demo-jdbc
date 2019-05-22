package fr.diginamic.openfoodfacts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.openfoodfacts.connexion.ConnexionManager;

/**
 * Classe qui gère les actions sur la table marque
 * 
 * @author Cécile Peyras
 *
 */
public class MarqueDao {

	public void marqueAdd(String marque) {
		Connection conn = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try {
			conn.setAutoCommit(false);
			statement = conn.prepareStatement("INSERT INTO marque (nom) VALUES (?)");
			statement.setString(1, marque);
			statement.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new TechnicalException("Le rollback n'a pas fonctionné", e);
			}
			throw new TechnicalException("L'ajout ne s'est pas fait", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {

				throw new TechnicalException("La fermeture ne s'est pas faite", e);
			}
		}

	}

	public boolean marqueExist(String marque) {
		Connection conn = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet curseur = null;

		try {

			statement = conn.prepareStatement("SELECT * FROM marque WHERE nom = ?");
			statement.setString(1, marque);
			curseur = statement.executeQuery();

			if (curseur.next()) {

				return true;
			}
			return false;

		} catch (SQLException e) {

			throw new TechnicalException("Une erreur sur l'exitence de la marque", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (curseur != null) {
					curseur.close();
				}
			} catch (SQLException e) {

				throw new TechnicalException("La fermeture ne s'est pas faite", e);
			}
		}

	}

	public int getIdMarque(String marque) {
		Connection conn = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet curseur = null;
		int idMarque = 0;

		try {

			statement = conn.prepareStatement("SELECT id FROM marque where nom =?");
			statement.setString(1, marque);
			curseur = statement.executeQuery();

			while (curseur.next()) {

				int id = curseur.getInt("id");

				idMarque = id;

			}

			return idMarque;

		} catch (SQLException e) {

			throw new TechnicalException("L'id Marque n'a pas pu être trouvé", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (curseur != null) {
					curseur.close();
				}
			} catch (SQLException e) {

				throw new TechnicalException("La fermeture ne s'est pas faite", e);
			}
		}

	}
}
