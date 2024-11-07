package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {	

	// TODO: objektvariable 
	private Innlegg[] innleggtabell;
	private int nesteledig;
	
	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int innleggPos = -1;
		for (int i = 0; i < getAntall(); i++) {
			if (innleggtabell[i] != null && innleggtabell[i].equals(innlegg)) {
				innleggPos = i;
				break;
			}
		}
		return innleggPos;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		
		for (int i = 0; i < getAntall(); i++) {
			if (innleggtabell[i] != null && innleggtabell[i].equals(innlegg)) {
				finnes = true;
			}
		}
		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] == null) {
				ledig = true;
				break;
			}
		}
		return ledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		
		if (ledigPlass() && !finnes(innlegg)) {
            innleggtabell[nesteledig] = innlegg;
            lagtTil = true;
            nesteledig++;
        }
		return lagtTil;
	}
	
	public String toString() {

		StringBuilder sb = new StringBuilder();
	try {
		for (int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i] != null) {
				sb.append(innleggtabell[i].toString());
			}
		}
		return getAntall() + "\n" + sb;
		}	catch(UnsupportedOperationException ex) {
			System.out.println("an unsupported operation was attempted: " + ex.getMessage());
			return "";
		}
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		int x = innleggtabell.length * 2;
		Innlegg[] newInnleggTabell = new Innlegg[x];
		for(int i = 0; i < innleggtabell.length; i++) {
			newInnleggTabell[i] = innleggtabell[i];
		}
		innleggtabell = newInnleggTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = false;
		
		leggTil(innlegg);
		if (leggTil(innlegg)) {
			lagtTil = true;
		} else {
			utvid();
			leggTil(innlegg);
			lagtTil = true;
		}
		return lagtTil;
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		
		for(int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				innleggtabell[i] = null;
				nesteledig--;
				slettet = true;
			}
		}
		for(int i = 0; i < innleggtabell.length-1; i++){
			if(innleggtabell[i] == null && innleggtabell[i+1] != null) {
				innleggtabell[i] = innleggtabell[i+1];
			}
		}
		
		return slettet;
	}
	
	public int[] search(String keyword) {
		
		int[] idTabell = new int[innleggtabell.length];
        int j = 0;
        for (int i = 0; i < innleggtabell.length; i++) {
            if (innleggtabell[i].toString().contains(keyword)) {
                idTabell[j] = innleggtabell[i].getId();
                j++;
            }
        }
        return idTabell;

	}
}