package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle extends ListResourceBundle{
	
	private Object[][] contents = { { "language", "donaldisch" },
			{ "currency", "Taler" }, { "capital", "Entenhausen City" } };
	
	
	
	@Override
	protected Object[][] getContents() {
	
		return contents;
	}
	

}
