package wbs.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBooksTableDemo {

	
	public static void main(String[] args) throws IOException {
		
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		
		String path = "resources/sql/createBooks.sql";

		String sql = new String(Files.readAllBytes(Paths
				.get(path)));

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();
			stmt.execute("DROP TABLE IF EXISTS Buch");
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
