package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitaTest {

	Partita partita = new Partita();
	Stanza stanza = new Stanza("Stanza");
	
	//test per getStanzaVincente
	@Test
	public void testGetStanzaVincente() {
		assertEquals("errore getStanzaVincente","Biblioteca",  partita.getLabirinto().getStanzaVincente().getNome());
	}

	//test per setStanzaCorrente
	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertEquals("errore setStanzaCorrente", stanza, partita.getLabirinto().getStanzaCorrente());
	}

	//test per isFinita
	@Test
	public void testIsFinita() {
		assertFalse("errore isFinita", partita.isFinita());
	}
	
}