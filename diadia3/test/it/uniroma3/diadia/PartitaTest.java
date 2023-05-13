package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Labirinto labirinto;
	Partita p;
	Stanza s;

	@Before
	public void setUp() {
		 labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("mazza", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Errore getStanzaVincente","Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals("Errore setStanzaCorrente",s, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse("Errore isFinita",p.isFinita());
	}
	
}
