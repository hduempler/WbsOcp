package wbs.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class BridgeDemo {
	/*
	 * An einem Bridgeturnier nehmen 10 Bridgespielerinnen teil.
	 * 
	 * Wir listen alle möglichen Zusammenstellungen von 4 Damen zu einer
	 * Bridgepartie auf.
	 */
	public static void main(String[] args) {
		List<String> bridgeList = new ArrayList<>();
		MyList<String> myBridgeList = new MyList<String>(bridgeList);
		bridgeList.add("Larissa");
		bridgeList.add("Vanessa");
		bridgeList.add("Charlotte");
		bridgeList.add("Tanja");
		bridgeList.add("Franziska");
		bridgeList.add("Theresa");
		bridgeList.add("Antonia");
		bridgeList.add("Laura");
		bridgeList.add("Julia");
		bridgeList.add("Kerstin");

		int n = 0;
		for (List<String> sublist : myBridgeList) {
			if (sublist.size() == 4) {
				System.out.println(sublist);
				n++;
			}
		}
		System.out.println();
		System.out.println("Bei " + bridgeList.size()
				+ " Teilnehmerinnen gibt es " + n
				+ " mögliche Zusammensetzungen von 4 Spielerinnen.");

	}

}
