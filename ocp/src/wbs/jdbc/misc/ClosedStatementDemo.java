package wbs.jdbc.misc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ClosedStatementDemo {

	// was passiert, wenn auf ein ResultSet zugegriffen wird, und das statement,
	// durch das es erzeugt wurde, bereits geschlossen ist?
	
	// SQLException

	public static void main(String[] args) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();

		Properties props = new Properties();

		props.setProperty("user", "root");
		props.setProperty("password", "");

		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		// String user = "root";
		// String password = "mysql";
		String sql = "SELECT * FROM Buch";

		try (Connection connection = driver.connect(url, props);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			statement.close();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("isbn") + " -> "
						+ resultSet.getString("autor") + " -> "
						+ resultSet.getString("titel") + " -> "
						+ resultSet.getDouble("preis"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
