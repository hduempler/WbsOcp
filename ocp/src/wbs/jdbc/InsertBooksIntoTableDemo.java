package wbs.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class InsertBooksIntoTableDemo {

	public static void main(String[] args) throws IOException {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();
			//stmt.execute("TRUNCATE TABLE Buch");
			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO Buch VALUES (?,?,?,?)");
			String filename = "resources/io/spiegelbestseller.txt";
			try (BufferedReader br = new BufferedReader(
					new FileReader(filename))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] fields = line.split("\\|");
					for (int i = 0; i < 4; i++) {
						System.out.println(fields[i]);
						pstmt.setString(i + 1, fields[i]);
					}
					pstmt.execute();
					System.out.println();
				}
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
