package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateResultSetDemo {
	/*
	 * Wir erhöhen die Preise aller BÜcher um 20 %
	 */
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		String sqlSelect = "SELECT isbn, preis FROM buch";
		// ggf try...catch...finally (OHNE try-with-resources)
		try (Connection connection = DriverManager.getConnection(url, user,
				password);
				Statement statement = connection.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet resultSet = statement.executeQuery(sqlSelect)) {
			while (resultSet.next()) {
				double preis=resultSet.getDouble(2);
				preis+=preis*20/100;
				resultSet.updateDouble(2,preis);
				
				resultSet.updateRow();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
