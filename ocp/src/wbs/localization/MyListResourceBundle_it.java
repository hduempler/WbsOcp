package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_it extends ListResourceBundle{
	
	private Object[][] contents = { { "language", "italiano" },
			{ "currency", "Euro" }, { "capital", "Roma" } };
	
	
	
	@Override
	protected Object[][] getContents() {
	
		return contents;
	}
	

}
