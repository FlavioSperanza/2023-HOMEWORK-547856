package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	Labirinto labirinto;
	Stanza biblioteca;
	Stanza N11;

	@Before
	public void setUp() {
		labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("trapano", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		
		biblioteca = new Stanza("Biblioteca");
		N11 = new Stanza("N11");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Errore getStanzaVincente","Biblioteca", labirinto.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(N11);
		assertEquals("Errore setStanzaCorrente",N11, labirinto.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Errore getStanzaCorrente","Atrio", labirinto.getStanzaCorrente().getNome());
	}

}
