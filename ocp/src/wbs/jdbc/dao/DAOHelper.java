package wbs.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAOHelper {
	private final static String URL = "jdbc:mysql://localhost:3306/jdbc";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new PersistenceException(e);
		}
	}

}
