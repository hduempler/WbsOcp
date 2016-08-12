package wbs.jdbc.dao;

import java.io.Serializable;

import wbs.jdbc.annotation.Column;
import wbs.jdbc.annotation.PrimaryKey;

public class Buch implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Column
	@PrimaryKey(index = 1)
	public String isbn;
	@Column
	@PrimaryKey(index = 2)
	public String autor;
	@Column
	public String titel;
	@Column
	public double preis;

	// Getter
	public String getIsbn() {
		return isbn;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitel() {
		return titel;
	}

	public double getPreis() {
		return preis;
	}

	// Setter
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return String.format("%s %s: %s; %,.2f Euro",
				isbn.replaceAll("(\\d)(\\d{3})(\\d{5})(\\d)", "$1-$2-$3-$4"),
				autor, titel, preis);
	}

}
