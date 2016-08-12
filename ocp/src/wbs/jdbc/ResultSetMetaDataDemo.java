package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		String sql = "SELECT * FROM buch";
		ResultSetMetaData meta;
		try (Connection connection = DriverManager.getConnection(url, user,
				password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			meta = resultSet.getMetaData();
			System.out.println(meta.getColumnCount());
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				System.out.println(meta.getColumnName(i) + " -> "
						+ meta.getColumnTypeName(i) + " -> "
						+ meta.getTableName(i) + " -> "
						+ meta.getCatalogName(i));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
