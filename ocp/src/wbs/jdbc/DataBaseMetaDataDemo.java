package wbs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseMetaDataDemo {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		ResultSet resultSet;
		/*
		 * Wir ändern den Code. Wir holen uns die Connection direkt vom
		 * MySql-Treiber und verwenden der Drivermanager nicht.
		 * 
		 * -> Class.forName() -> newInstance() über das Class-Objekt ->
		 * connect() mit geeigneter properties-Instanz
		 */
		Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver")
				.newInstance();

		Properties properties = new Properties();
		properties.put("user", user);
		properties.put("password", password);

		// try (Connection conn = DriverManager.getConnection(url, user,
		// password)) {
		try (Connection conn = driver.connect(url, properties)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.getDatabaseProductName());
			System.out.println(meta.getDatabaseProductVersion());
			System.out.println(meta.getDriverMajorVersion());
			System.out.println(meta.getDriverMinorVersion());
			System.out.println(meta.getURL());
			System.out.println("-----------------");
			resultSet = meta.getCatalogs();
			while (resultSet.next()) {
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					System.out.println(resultSet.getMetaData().getColumnName(i)
							+ " -> " + resultSet.getObject(i));
				}
			}
			resultSet.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}