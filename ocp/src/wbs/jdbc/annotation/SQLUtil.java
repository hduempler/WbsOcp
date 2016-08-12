package wbs.jdbc.annotation;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SQLUtil {
	String pathToDescriptor;

	public SQLUtil(String pathToDescriptor) {
		this.pathToDescriptor = pathToDescriptor;
	}

	public SQLUtil() {
		this("resources/sql/persistence.xml");
	}

	public void createTables() throws SAXException,
			ParserConfigurationException, IOException, SQLException {
		InputSource source = new InputSource(pathToDescriptor);

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(false);

		XMLReader reader = factory.newSAXParser().getXMLReader();
		SQLUtilHandler sqlUtilHandler = new SQLUtilHandler();
		ContentHandler handler = sqlUtilHandler;

		reader.setContentHandler(handler);
		reader.parse(source);

		SQLUtilConfig config = sqlUtilHandler.getConfig();
		Map<String, String> tableMappings = config.getTableMappings();
		Map<String, String> typeMappings = config.getTypeMappings();
		try (Connection conn = DriverManager.getConnection(config.getUrl(),
				config.getUser(), config.getPassword());) {

			for (Map.Entry<String, String> entry : tableMappings.entrySet()) {
				try {
					Class<?> myClass = Class.forName(entry.getKey());
					String sql = class2Table(myClass.getName(), tableMappings,
							typeMappings);
					Statement stmt = conn.createStatement();
					System.out.println("Führe aus: " + sql);
					stmt.executeUpdate(sql);
				} catch (ClassNotFoundException e) {
					System.out.println("Klasse " + entry.getKey()
							+ " wurde nicht gefunden.");
				} catch (SQLSyntaxErrorException e) {
					System.out.println("SQL-Fehler: " + e.getMessage());
				}

			}
		}

	};

	public String class2Table(String className,
			Map<String, String> tableMappings, Map<String, String> typeMappings)
			throws ClassNotFoundException {

		Class<?> cls = Class.forName(className);
		StringBuilder sql = new StringBuilder(
				"CREATE TABLE " + tableMappings.get(cls.getName()) + "(");

		Column column;
		PrimaryKey primaryKey;

		StringBuilder fieldDecs = new StringBuilder();
		Map<Integer, String> pKeysMap = new TreeMap<>();

		for (Field field : cls.getDeclaredFields()) {
			column = field.getAnnotation(Column.class);
			if (column != null) {
				if (fieldDecs.length() != 0)
					fieldDecs.append(", ");
				String sqlType = typeMappings
						.get(field.getType().getSimpleName());
				fieldDecs.append(
						String.format("%s %s", field.getName(), sqlType));

				primaryKey = field.getAnnotation(PrimaryKey.class);
				if (primaryKey != null) {
					fieldDecs.append(" NOT NULL");
					pKeysMap.put(primaryKey.index(), field.getName());
				}

			}
		}

		StringBuilder pKeys = new StringBuilder();
		for (String fieldName : pKeysMap.values()) {
			if (pKeys.length() != 0)
				pKeys.append(", ");
			pKeys.append(fieldName);

		}

		sql.append(fieldDecs);
		if (pKeys.length() > 0) {
			sql.append(", PRIMARY KEY (" + pKeys + ")");
		}
		sql.append(")");

		return sql.toString();
	}

	// public String saveObject(Object o, Map<String, String> tableMappings,
	// Map<String, String> typeMappings)
	// throws ClassNotFoundException, SQLException {
	//
	// @SuppressWarnings("rawtypes")
	// Class cls = o.getClass();
	// Column column;
	//
	// StringBuilder sql = new StringBuilder(
	// "INSERT INTO " + tableMappings.get(cls.getName()) + " (");
	//
	// StringBuilder fieldDecs = new StringBuilder();
	// StringBuilder values = new StringBuilder();
	// List<Object> valueList = new ArrayList();
	// for (Field field : cls.getDeclaredFields()) {
	// column = field.getAnnotation(Column.class);
	// if (column != null) {
	// System.out.println(field + " " + column);
	// if (fieldDecs.length() != 0) {
	// fieldDecs.append(", ");
	// values.append(", ");
	// }
	// fieldDecs.append(String.format("%s", field.getName()));
	// values.append("?");
	// try {
	// valueList.add(field.get(o));
	// } catch (IllegalArgumentException | IllegalAccessException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// }
	// sql.append(fieldDecs).append(") VALUES (").append(values).append(")");
	// try (Connection conn = DriverManager.getConnection(url, user,
	// password)) {
	// PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	// for (int i = 0; i < valueList.size(); i++) {
	// pstmt.setObject(i + 1, valueList.get(i));
	// }
	// pstmt.executeUpdate();
	// }
	// return sql.toString();
	// }

}
