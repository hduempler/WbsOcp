package wbs.jdbc.annotation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SQLUtilHandler extends DefaultHandler {
	private SQLUtilConfig config = new SQLUtilConfig();

	public SQLUtilConfig getConfig() {
		return config;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		switch (qName) {
		case "connection":
			config.setDriver(attributes.getValue("driver"));
			config.setUrl(attributes.getValue("url"));
			config.setUser(attributes.getValue("user"));
			config.setPassword(attributes.getValue("password"));
			break;
		case "tableMapping":
			config.putTableMapping(attributes.getValue("className"),
					attributes.getValue("tableName"));
			break;
		case "typeMapping":
			config.putTypeMapping(attributes.getValue("javaType"),
					attributes.getValue("sqlType"));
			break;
		}
	}


}
