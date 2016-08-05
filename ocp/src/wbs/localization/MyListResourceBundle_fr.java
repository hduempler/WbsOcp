package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_fr extends ListResourceBundle{
	
	private Object[][] contents = { { "language", "francais" },
			{ "currency", "Euro" }, { "capital", "Paris" } };
	
	
	
	@Override
	protected Object[][] getContents() {
	
		return contents;
	}
	

}
