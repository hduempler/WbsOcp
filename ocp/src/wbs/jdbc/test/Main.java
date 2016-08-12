package wbs.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class Main {

	public static void main(String[] args) {
		try {
			String mysqlUrl = "jdbc:mysql://localhost:3306/jdbc?user=root";
			//String derbyUrl = "jdbc:derby:TestDB1";

			// get connection to database
			Connection connection = DriverManager.getConnection(mysqlUrl);
			connection.setAutoCommit(false);

			// set up the initial records
			Statement statement = connection.createStatement();
			statement.executeUpdate("Delete from test_table");
			statement.executeUpdate(
					"Insert into test_table (i1, i2) values (1, 1)");

			// select records into a filtered row set
			CachedRowSet results = new CachedRowSetImpl();
			results.setCommand("select * from test_table");
			results.execute(connection);

			// insert a new row
			results.moveToInsertRow();
			results.updateInt("i1", 1);
			results.updateInt("i2", 2);
			results.insertRow();
			results.moveToCurrentRow();

			// commit changes
			// This works in derby.
			results.acceptChanges();
			// In mySQL, the previous line throws this exception:
			// javax.sql.rowset.spi.SyncProviderException: 2conflicts while
			// synchronizing
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
