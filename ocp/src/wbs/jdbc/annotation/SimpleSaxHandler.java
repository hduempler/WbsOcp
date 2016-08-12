package wbs.jdbc.annotation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSaxHandler extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println(qName);
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.println(attributes.getQName(i) + ":" + attributes.getValue(i));
		}
		System.out.println();
	}

}
