package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {

	public static void main(String[] args) {

		Connection maConnection = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			maConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pizzeria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "pupuce");
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
