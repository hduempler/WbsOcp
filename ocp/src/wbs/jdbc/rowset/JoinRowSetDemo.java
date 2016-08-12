package wbs.jdbc.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/*
 * Wir nehmen an, dass eine Bücherei für jedes Buch aus der Tabelle Buch
 * ein oder mehrere Exemplare hat
 * 
 * 
 */

public class JoinRowSetDemo {

	static String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&amp;characterEncoding=UTF-8";
	static String user = "root";
	static String password = "";

	/*
	 * Wir schreiben die Methode populateExemplar(). Sie legt für jeden Record
	 * aus der Tabelle Buch einen oder mehrere Records in der Tabelle Exemplar
	 * an. Die Exemplare eines Buches werden fortlaufend nummeriert. Das
	 * Anschaffungsjahr der einzelnen Exemplare kann variieren.
	 * 
	 */
	static void truncateExemplar() throws SQLException {
		String sql = "TRUNCATE TABLE exemplar";
		try (Connection connection = DriverManager.getConnection(url, user,
				password); Statement stmt = connection.createStatement()) {
			stmt.executeUpdate(sql);

		}

	}

	static void populateExemplar() throws SQLException {
		final Random rnd = new Random();
		final int MIN_ANZAHL = 1;
		final int MAX_ANZAHL = 6;
		final int MIN_JAHR = 2005;
		final int MAX_JAHR = 2016;

		String sql = "SELECT * from buch";
		String insSql = "INSERT INTO exemplar (isbn, nr, anschaffungsjahr) VALUES (?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(url, user,
				password);
				Statement statement = connection.createStatement();
				PreparedStatement pstmt = connection.prepareStatement(insSql);
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				int anzahl = MIN_ANZAHL
						+ rnd.nextInt((MAX_ANZAHL - MIN_ANZAHL) + 1);
				List<Integer> jahrList = new ArrayList<>();
				for (int i = 0; i < anzahl; i++) {
					jahrList.add(
							MIN_JAHR + rnd.nextInt((MAX_JAHR - MIN_JAHR) + 1));
				}
				Collections.sort(jahrList);
				for (int nr = 1; nr <= anzahl; nr++) {
					pstmt.setString(1, resultSet.getString("isbn"));
					pstmt.setInt(2, nr);
					pstmt.setInt(3, jahrList.get(nr - 1));
					pstmt.execute();
				}
			}

		}

	}

	public static void main(String[] args) throws SQLException {
		truncateExemplar();
		// if (true) return;
		populateExemplar();
		RowSetFactory rowSetFactory;
		JoinRowSet joinRowSet;
		CachedRowSet rsBuch;
		CachedRowSet rsEx;
		String sqlBuch = "SELECT * FROM buch";
		String sqlEx = "SELECT * FROM exemplar";

		rowSetFactory = RowSetProvider.newFactory();
		joinRowSet = rowSetFactory.createJoinRowSet();
		rsBuch = rowSetFactory.createCachedRowSet();
		// rsBuch.setUrl(url);
		// rsBuch.setUsername(user);
		// rsBuch.setPassword(password);
		rsBuch.setCommand(sqlBuch);

		rsEx = rowSetFactory.createCachedRowSet();
		// rsEx.setUrl(url);
		// rsEx.setUsername(user);
		// rsEx.setPassword(password);
		rsEx.setCommand(sqlEx);
		try (Connection conn = DriverManager.getConnection(url, user,
				password)) {
			rsBuch.execute(conn);
			rsEx.execute(conn);
		}

		joinRowSet.addRowSet(rsEx, "isbn");
		joinRowSet.addRowSet(rsBuch, "isbn");

		// oder so:

		// rsEx.setMatchColumn("isbn");
		// joinRowSet.addRowSet(rsEx);
		// rsBuch.setMatchColumn("isbn");
		// joinRowSet.addRowSet(rsBuch);
		// rsBuch.beforeFirst();
		// int i=0;
		joinRowSet.afterLast();
		while (joinRowSet.previous()) {
			System.out.printf("%s; %s; %s; Lfd.Nr.: %d; Anschaffungsjahr: %d%n",
					joinRowSet.getString("isbn").replaceAll(
							"(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4"),
					joinRowSet.getString("autor"),
					joinRowSet.getString("titel"), joinRowSet.getInt("nr"),
					joinRowSet.getInt("anschaffungsjahr"));
			// rsBuch.getString("isbn").replaceAll(
			// "(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4"),
			// rsBuch.getString("autor"), rsBuch.getString("titel"));
		}

		rsEx.close();
		rsBuch.close();
		joinRowSet.close();
	}

}
