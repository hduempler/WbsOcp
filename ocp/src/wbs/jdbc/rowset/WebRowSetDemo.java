package wbs.jdbc.rowset;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&amp;characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		RowSetFactory rowSetFactory;
		WebRowSet webRowSet;
		String sql = "select * from buch";
		try (FileWriter fileWriter = new FileWriter("resources/xml/buch.xml")) {
			rowSetFactory = RowSetProvider.newFactory();
			webRowSet = rowSetFactory.createWebRowSet();
			webRowSet.setUrl(url);
			webRowSet.setUsername(user);
			webRowSet.setPassword(password);
			webRowSet.setCommand(sql);
			webRowSet.execute();
			webRowSet.writeXml(fileWriter);
			webRowSet.beforeFirst();
			while (webRowSet.next()) {
				System.out.printf("%s; %s; %s; %,.2f Euro%n",webRowSet.getString("isbn"),webRowSet.getString("autor"),webRowSet.getString("titel"),webRowSet.getDouble("preis"));
			}
			webRowSet.writeXml(fileWriter);
			webRowSet.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
