package wbs.jdbc.annotation;

public class SQLUtilCreateTablesDemo {

	public static void main(String[] args) throws Exception {

		String pathToDescriptor = "resources/sql/persistence.xml";

		SQLUtil sqlUtil = new SQLUtil(pathToDescriptor);

		// erzeugt alle tabellen, für die es in persistence.xml einen eintrag
		// gibt
		sqlUtil.createTables();
	}
}
