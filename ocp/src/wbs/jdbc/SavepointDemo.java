package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavepointDemo {
	static String url = "jdbc:mysql://localhost:3306/jdbc";
	static String user = "root";
	static String password = "";

	static void printBooks() {
		String sql = "SELECT * FROM Buch";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				System.out.printf("ISBN: %s;%s: %s; %,.2f Euro%n",
						resultSet.getString("ISBN").replaceAll(
								"(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4"),
						resultSet.getString("AUTOR"),
						resultSet.getString("TITEL"),
						resultSet.getDouble("PREIS"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String sql = "insert into buch (isbn, autor , titel, preis) values(?,?,?,?)";
		Savepoint sp1;
		Savepoint sp2;
		Savepoint sp3;
		try (Connection conn = DriverManager.getConnection(url, user,
				password)) {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			sp1 = conn.setSavepoint();
			pstmt.setString(1, "1111111111111");
			pstmt.setString(2, "Autor 1");
			pstmt.setString(3, "Titel 1");
			pstmt.setDouble(4, 1.11);
			try {
				pstmt.execute();
			} catch (SQLIntegrityConstraintViolationException sqle) {
				System.out.println("Eintrag schon vorhanden");
			}
			sp2 = conn.setSavepoint("sp2");
			pstmt.setString(1, "2222222222222");
			pstmt.setString(2, "Autor 2");
			pstmt.setString(3, "Titel 2");
			pstmt.setDouble(4, 2.22);
			try {
				pstmt.execute();
			} catch (SQLIntegrityConstraintViolationException sqle) {
				System.out.println("Eintrag schon vorhanden");
			}
			sp3 = conn.setSavepoint("sp3");
			pstmt.setString(1, "3333333333333");
			pstmt.setString(2, "Autor 3");
			pstmt.setString(3, "Titel 3");
			pstmt.setDouble(4, 3.33);

			try {
				pstmt.execute();
			} catch (SQLIntegrityConstraintViolationException sqle) {
				System.out.println("Eintrag schon vorhanden");
			}
			conn.rollback(sp1);
			conn.commit();

		} catch (SQLIntegrityConstraintViolationException sqle) {
			System.out.println("MIST");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		printBooks();
	}

}
