package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	Labirinto llabirinto;
	Stanza biblioteca;
	Stanza stanza;

	@Before
	public void setUp() {
		llabirinto = new Labirinto();
		llabirinto.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		stanza = new Stanza("DS1");
	}


	//test per getStanzaVincente
	@Test
	public void testGetStanzaVincente() {
		assertEquals("errore getStanzaVincente", "Biblioteca", llabirinto.getStanzaVincente().getNome());
	}


	//test per setStanzaCorente
	@Test
	public void testSetStanzaCorrente() {
		llabirinto.setStanzaCorrente(stanza);
		assertEquals("errore setStanzaCorrente", stanza, llabirinto.getStanzaCorrente());
	}
	
	//test per getStanzaCorrente
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("errore getStanzaCorrente", "Atrio", llabirinto.getStanzaCorrente().getNome());
	}

}