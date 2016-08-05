package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		String sql = "SELECT * FROM Buch";
		try (Connection connection = DriverManager.getConnection(url, user,
				password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				System.out.printf("ISBN: %s;%s: %s; %,.2f Euro%n",resultSet.getString("ISBN").replaceAll("(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4"),resultSet.getString("AUTOR"),resultSet.getString("TITEL"),resultSet.getDouble("PREIS"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
