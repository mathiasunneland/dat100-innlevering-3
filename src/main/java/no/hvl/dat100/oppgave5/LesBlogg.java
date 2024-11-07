package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		Blogg bloggen = null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(mappe, filnavn)))) {
			
			int i = 0;
			
			int antall = Integer.parseInt(reader.readLine());
			bloggen = new Blogg(antall);
			
			String linje;
			while ((linje = reader.readLine()) != null) {
				String type = linje;
				int id = Integer.parseInt(reader.readLine());
				String bruker = reader.readLine();
				String dato = reader.readLine();
				int likes = Integer.parseInt(reader.readLine());

				if (type.equals(TEKST)) {
					
					String tekst = reader.readLine();
					
					Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
					bloggen.leggTil(innlegg);
					
				} else if (type.equals(BILDE)) {
					
					String tekst = reader.readLine();
					String url = reader.readLine();
					
					Bilde innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					bloggen.leggTil(innlegg);
				}
			}
			
			
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		System.out.println(bloggen.toString());
		return bloggen;
	}
}
