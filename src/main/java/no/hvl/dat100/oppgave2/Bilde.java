package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;

public class Bilde extends Tekst {

	// TODO - objekt variable
	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return super.toString() + url + "\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		return super.toHTML() + "\t\t<p>" + url + "</p>\n";			
	}
}
