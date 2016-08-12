package wbs.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class FilteredRowSetDemo {
	
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
			String user = "root";
			String password = "";
			RowSetFactory rowSetFactory;
			FilteredRowSet filteredRowSet;
			String sql = "select isbn, autor, titel, preis from buch";
			MyPredicate predicate = new MyPredicate("preis");
			// ggf selektionskriterien für den preis setzen
			rowSetFactory = RowSetProvider.newFactory();
			filteredRowSet = rowSetFactory.createFilteredRowSet();
			filteredRowSet.setUrl(url);
			filteredRowSet.setUsername(user);
			filteredRowSet.setPassword(password);
			filteredRowSet.setFilter(predicate);
			filteredRowSet.setCommand(sql);
			filteredRowSet.execute();
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getDouble("preis"));
			}
			System.out.println("--------");
			
			filteredRowSet.beforeFirst();
			predicate.setColumnName("autor");
			// ggf selektionskriterien für den autor setzen
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getString("autor"));
			}
			System.out.println("--------");
			
			filteredRowSet.beforeFirst();
			predicate.setColumnName("titel");
			// ggf selektionskriterien für den titel setzen
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getString("titel"));
			}
			System.out.println("--------");
			
			filteredRowSet.beforeFirst();
			predicate.setColumnName("isbn");
			// ggf selektionskriterien für die isbn setzen
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getString("titel"));
			}
			System.out.println("--------");
			
			filteredRowSet.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
