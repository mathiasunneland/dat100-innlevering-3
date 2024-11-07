package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;
import no.hvl.dat100.oppgave1.*;


public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		boolean skrive = false;
		
		try {
			PrintWriter skriver = new PrintWriter(mappe + filnavn);
			Innlegg[] innleggtabell = samling.getSamling();
			for (Innlegg innlegg : innleggtabell) {
				if (innlegg != null) {
					skriver.println(innlegg.toString());
				}
			}
			skriver.close();
			skrive = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return skrive;
	}
}
