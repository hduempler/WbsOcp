package wbs.jdbc.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetDemoTG_original {

	// wir nehmen an, dass eine Bucherei für jedes Buch aus der Tabelle buch ein
	// oder mehere Exemplare hat

	// wir schreiben die Methode populateExemplar(). Sie legt für jeden record
	// aus der Tabelle buch einen oder mehrere Records in der Tabelle exemplar
	// an. Die Exemplare eines Buches werden fortlaufend nummeriert. Das
	// Anschaffungsjahr soll variieren.

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";

		try (Connection conn = DriverManager.getConnection(url, user,
				password)) {
			conn.setAutoCommit(false);
			RowSetFactory rowSetFactory;

			rowSetFactory = RowSetProvider.newFactory();
			JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();

			String sql = "select isbn from buch";
			CachedRowSet cachedRowSet1 = rowSetFactory.createCachedRowSet();
			// cachedRowSet1.setMatchColumn(1);
			cachedRowSet1.setCommand(sql);
			cachedRowSet1.execute(conn);

			sql = "select * from exemplar";
			CachedRowSet cachedRowSet2 = rowSetFactory.createCachedRowSet();
			// cachedRowSet2.setMatchColumn(1);
			cachedRowSet2.setCommand(sql);
			cachedRowSet2.execute(conn);

			populateExemplar(cachedRowSet1, cachedRowSet2);

			joinRowSet.addRowSet(cachedRowSet1, 1);
			joinRowSet.addRowSet(cachedRowSet2, 1);
			joinRowSet.next();
			System.out.println(joinRowSet.getString("isbn") + " "
					+ joinRowSet.getInt("anschaffungsjahr"));
			joinRowSet.close();
		}
	}

	public static void populateExemplar(RowSet srcRowSet,
			CachedRowSet dstRowSet) throws SQLException {
		while (srcRowSet.next()) {
			for (int i = 1; i <= Math.random() * 5 + 1; i++) {
				dstRowSet.moveToInsertRow();
				dstRowSet.updateString("isbn", srcRowSet.getString(1));
				dstRowSet.updateInt("nr", i);
				dstRowSet.updateInt("anschaffungsjahr",
						(int) (1956 + 60 * Math.random()));
				dstRowSet.insertRow();
				dstRowSet.moveToCurrentRow();
			}
		}
		dstRowSet.acceptChanges();
	}
}
