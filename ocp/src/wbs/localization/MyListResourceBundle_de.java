package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_de extends ListResourceBundle{
	
	private Object[][] contents = { { "language", "deutsch" },
			{ "currency", "Euro" }, { "capital", "Berlin" } };
	
	
	
	@Override
	protected Object[][] getContents() {
	
		return contents;
	}
	

}
