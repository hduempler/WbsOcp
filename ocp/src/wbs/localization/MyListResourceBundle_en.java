package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_en extends ListResourceBundle{
	
	private Object[][] contents = { { "language", "english" },
			{ "currency", "Pound" }, { "capital", "London" } };
	
	
	
	@Override
	protected Object[][] getContents() {
	
		return contents;
	}
	

}
