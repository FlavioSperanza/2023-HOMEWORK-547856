package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {	

	Stanza s = new Stanza("s");
	Stanza s2= new Stanza("s2");
	Attrezzo m = new Attrezzo("martello", 42);
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s.getStanzaAdiacente("sud"));
	}
	

	@Test
	public void testImpostaStanzaAdiacente() {
		s.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAddAttrezzo() {
		
		assertTrue(s.addAttrezzo(m));
	}
	

}
