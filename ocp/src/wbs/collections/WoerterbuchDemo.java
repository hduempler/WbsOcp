package wbs.collections;

public class WoerterbuchDemo {

	public static void main(String[] args) {
		Woerterbuch wb = new Woerterbuch("plattdeutsch", "hochdeutsch");
		String[] entries = {
				"mieter:knauser",
				"mimer:sinnierer,phantast,träumer,grübler",
				"morskruper:arschkriecher,schmeichler",
				"döösbaddel:tollpatsch,dummkopf,idiot",
				"töffel:dummkopf",
				"bangbüx:angsthase",
				"suffkopp:starktrinker,alkoholiker",
				"dööskopp:dummkopf",
				"puttfarken:schmutzfink",
				"dröhnbüdel:schwätzer",
				"dwarsbüngel:querkopf",
				"klookschieter:besserwisser,klugscheißer",
				"swienegel:ferkel",
				"prüllker:lump,knicker,geizhals",
				"proter:großmaul",
				"priemelpott:korinthenkacker",
				"priemelmors:korinthenkacker,pedant,genauigkeitskrämer",
				"püttjer:pedant",
				"quacke:faselhans,pfuscher",
				"quackel:faselhans,pfuscher",
				"quarker:nörgler",
				"rattsnuut:quasselstrippe",
				"rif-raff:pöbel,gesindel",
				"snacker:plaudertasche",
				"snöttfatt:rotzbengel,naseweis",
				"swiendriever:schweinetreiber",
				"trieselpiepe:plagegeist",
				"wrögel:stänkerer,zänker",
		};
		
		for (String s : entries) {
			String[] entry = s.split(":");
			String srcWord=entry[0];
			for (String dstWord : entry[1].split(",")) {
				wb.putWords(srcWord,dstWord);
			}
		}

		System.out
				.println("---------------------------------------------------------------------------");
		System.out.println("Wörterbuch " + wb.getSrcLanguage() + " -> "
				+ wb.getDstLanguage());
		System.out
				.println("---------------------------------------------------------------------------");

		for (String s : wb.srcWords()) {
			System.out.println(s + " -> " + wb.getWords(s));
		}

		wb = wb.invertDict();
		System.out
				.println("---------------------------------------------------------------------------");
		System.out.println("Wörterbuch " + wb.getSrcLanguage() + " -> "
				+ wb.getDstLanguage());
		System.out
				.println("---------------------------------------------------------------------------");
		for (String s : wb.srcWords()) {
			System.out.println(s + " -> " + wb.getWords(s));
		}

	}

}
