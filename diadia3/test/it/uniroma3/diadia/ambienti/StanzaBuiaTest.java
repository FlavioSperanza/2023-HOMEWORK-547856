package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo torcia;
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaBuia("StanzaBuia", "torcia");
		torcia = new Attrezzo("torcia", 1);
	}


	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(torcia);
		assertEquals("Errore getDescrizioneConAttrezzo",stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "qui c'è un buio pesto";
		assertEquals("Errore getDescrizioneSenzaAttrezzo",e, stanza.getDescrizione());
	}
}
