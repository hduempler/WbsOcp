package wbs.generics;

// O: Typ des Objekts (Abgeordneter, Wahlberechtigter, Schüler)
// P: Typ der Eigenschaft (Fraktion, Wahlkreis, Klasse)

public interface Mapper2<O,P> {
	public P map(O o);
}
