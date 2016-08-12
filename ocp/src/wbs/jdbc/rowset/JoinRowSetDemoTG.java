package wbs.jdbc.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetDemoTG {

	// wir nehmen an, dass eine Bucherei für jedes Buch aus der Tabelle buch ein
	// oder mehere Exemplare hat

	// wir schreiben die Methode populateExemplar(). Sie legt für jeden record
	// aus der Tabelle buch einen oder mehrere Records in der Tabelle exemplar
	// an. Die Exemplare eines Buches werden fortlaufend nummeriert. Das
	// Anschaffungsjahr soll variieren.

	static void truncateExemplar() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sql = "TRUNCATE TABLE exemplar";
		try (Connection connection = DriverManager.getConnection(url, user,
				password); Statement stmt = connection.createStatement()) {
			stmt.executeUpdate(sql);

		}

	}

	
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		truncateExemplar();
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			conn.setAutoCommit(false);
			RowSetFactory rowSetFactory;
	
			rowSetFactory = RowSetProvider.newFactory();
			JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
	
			String sql = "select * from buch";
			CachedRowSet cachedRowSet1 = rowSetFactory.createCachedRowSet();
//			cachedRowSet1.setMatchColumn(1);
			cachedRowSet1.setCommand(sql);
			cachedRowSet1.execute(conn);
	
			sql = "select * from exemplar";
			CachedRowSet cachedRowSet2 = rowSetFactory.createCachedRowSet();
//			cachedRowSet2.setMatchColumn(1);
			cachedRowSet2.setCommand(sql);
			cachedRowSet2.execute(conn);
	
			populateExemplar(cachedRowSet1, cachedRowSet2);
			
			joinRowSet.addRowSet(cachedRowSet1,"isbn");
			joinRowSet.addRowSet(cachedRowSet2,"isbn");

			joinRowSet.first();
			while (joinRowSet.next()) {
				System.out.printf("%s; %s; %s; Lfd.Nr.: %s; Anschaffungsjahr: %s%n",
						joinRowSet.getString("isbn").replaceAll(
								"(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4"),
						joinRowSet.getString("autor"),
						joinRowSet.getString("titel"), joinRowSet.getString("nr"),
						joinRowSet.getString("anschaffungsjahr"));
			}

			
			
			joinRowSet.close();
		}
	}
	
	public static void populateExemplar(RowSet srcRowSet, CachedRowSet dstRowSet) throws SQLException {

		while (srcRowSet.next()) {
			for (int i = 1; i <= Math.random()*5+1; i++) {
				dstRowSet.moveToInsertRow();
				dstRowSet.updateString("isbn", srcRowSet.getString("isbn"));
				dstRowSet.updateInt("nr", i);
				dstRowSet.updateInt("anschaffungsjahr", (int) (1956+60*Math.random()));
				dstRowSet.insertRow();
				dstRowSet.moveToCurrentRow();
			}
		}
		dstRowSet.acceptChanges();
	}
}
