package wbs.jdbc.dao;

import java.util.List;

public class BuchDAODemo {

	public static void setBuch(Buch buch, String isbn, String autor,
			String titel, double preis) {
		buch.setIsbn(isbn);
		buch.setAutor(autor);
		buch.setTitel(titel);
		buch.setPreis(preis);

	}

	// Schwachstellen / Behebung
	// pooling von Connections / DAOs /Komponenten
	// DAOs klinken sich in Transaktionen ein, sind aber selbst weder
	// für das Starten noch für das Committen verantwortlich

	public static void main(String[] args) {
		//
		IBuchDAO buchDAO = DAOFactory.getBuchDAO();
		Buch buch = new Buch();

		// setter-Methoden aufrufen

//		buchDAO.delete("1234345");
//		buchDAO.delete("1234346");
//		setBuch(buch, "1234345", "Hans Dampf",
//				"Die Dampfmaschine im Wandel der Zeiten", 1.99);
//		buchDAO.save(buch);
//
//		setBuch(buch, "1234346", "Tick, Trick und Track",
//				"Pfadfinderhandbuch Teil 2 Hrsg. von Fähnlein Fieselschweif",
//				19.99);
//		buchDAO.save(buch);

		List<Buch> buecher = buchDAO.findAll();
		for (Buch b : buecher) {
			System.out.println(b);
		}
	}

}
