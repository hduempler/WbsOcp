package wbs.jdbc.annotation;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class SimpleSaxHandlerDemo {

	public static void main(String[] args)throws Exception {
		
		String xmlFile = "resources/sql/persistence.xml";
		InputSource source = new InputSource(xmlFile);
				
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(false);
		
		XMLReader reader = factory.newSAXParser().getXMLReader();
		
		ContentHandler handler = new SimpleSaxHandler();
		
		//reader.setContentHandler(handler);
		reader.parse(source);
	}
}
