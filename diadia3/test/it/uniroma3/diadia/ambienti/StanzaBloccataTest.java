package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata bloccata;
	private Stanza s;
	private Attrezzo a;
	
	@Before
	public void setUp() throws Exception {
		bloccata = new StanzaBloccata("StanzaBloccata", "ovest", "chiave");
		s = new Stanza("s");
		a = new Attrezzo("chiave", 1);
		bloccata.impostaStanzaAdiacente("ovest", s);
		
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals("Errore getStanzaAdiacenteDirezioneBloccata",bloccata, bloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		bloccata.addAttrezzo(a);
		assertEquals("Errore getStanzaAdiacenteDirezioneSbloccata",s, bloccata.getStanzaAdiacente("ovest"));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		bloccata.addAttrezzo(a);
		assertEquals("Errore getDescrizioneDirezioneSbloccata",bloccata.toString(), bloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Stanza bloccata nella direzione: ovest"+"\nPrendi chiave e posalo";
		assertEquals("Errore testGetDescrizioneDirezioneBloccata",e, bloccata.getDescrizione());
		
	}

}
