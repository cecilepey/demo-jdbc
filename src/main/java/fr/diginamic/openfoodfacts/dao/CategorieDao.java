package fr.diginamic.openfoodfacts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.openfoodfacts.connexion.ConnexionManager;

/**
 * Classe qui gère les actions sur la table catégorie
 * 
 * @author Cécile Peyras
 *
 */
public class CategorieDao {

	public void categorieAdd(String categorie) {
		Connection conn = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try {
			conn.setAutoCommit(false);
			statement = conn.prepareStatement("INSERT INTO categorie (nom) VALUES (?)");
			statement.setString(1, categorie);
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

	public boolean categorieExist(String categorie) {
		Connection conn = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet curseur = null;

		try {

			statement = conn.prepareStatement("SELECT nom FROM categorie where nom = ?");
			statement.setString(1, categorie);
			curseur = statement.executeQuery();

			if (curseur.next()) {

				return true;
			}

			return false;
		} catch (SQLException e) {
			throw new TechnicalException("Une erreur sur l'existence de la catégorie", e);
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

	public int getIdCategorie(String categorie) {
		Connection conn = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet curseur = null;
		int idCategorie = 0;

		try {

			statement = conn.prepareStatement("SELECT id FROM categorie where nom = ?");
			statement.setString(1, categorie);
			curseur = statement.executeQuery();

			if (curseur.next()) {

				int id = curseur.getInt("id");

				idCategorie = id;
			}

			return idCategorie;

		} catch (SQLException e) {

			throw new TechnicalException("Une erreur sur la récupération de id catégorie", e);
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
