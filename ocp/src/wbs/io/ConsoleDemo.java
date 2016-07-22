package wbs.io;

import java.io.Console;

//path_to_workspace/ocp/bin> java wbs.io.ConsoleDemo

//hinweise:
//eine console steht nicht immer zur verfügung
//(z.b. aufruf aus entwicklungsumgebung, start als hintergrundprozess, ein-/ausgabe-umlenkung)

//eine referenz auf eine console bekommt man nur über System.console()
//(liefert null, aber keine exception, falls keine console geliefert werden kann)

//Console ist isoliert, direkter Subtyp von Object

//methoden von Console liefern im fehlerfall einen Error aber keine Exception

//es schadet nichts, die methoden von Console namentlich zu kennen

public class ConsoleDemo {
	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			System.err.println("no console ... ");
			System.exit(-1);
		}
		console.printf(console.readLine());
	}
}