package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) {

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String driverName = monFichierConf.getString("database.driver");
		String urlName = monFichierConf.getString("database.url");
		String userName = monFichierConf.getString("database.user");
		String password = monFichierConf.getString("database.password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		Connection maConnection = null;

		try {
			maConnection = DriverManager.getConnection(urlName, userName, password);
			System.out.println(maConnection);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				maConnection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
