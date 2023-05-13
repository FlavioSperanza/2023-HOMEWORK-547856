package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica s;
	private Attrezzo roccia;
	private Attrezzo martellone;
	private Attrezzo scudo;
	
	@Before
	public void setUp() throws Exception {
		s = new StanzaMagica("s");
		roccia = new Attrezzo("roccia", 33);
		martellone = new Attrezzo("martellone", 42);
		scudo = new Attrezzo("scudo", 42);
	}


	@Test
	public void testAddAttrezzo() {
		assertTrue("Errore addAttrezzo",s.addAttrezzo(martellone));

	}


	@Test
	public void testModificaAttrezzo() {
		assertTrue(s.addAttrezzo(roccia));
		assertTrue(s.addAttrezzo(scudo));
		assertTrue(s.addAttrezzo(martellone));

		}
}
