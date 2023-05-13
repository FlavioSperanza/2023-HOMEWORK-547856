package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	LabirintoBuilder labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder();
	}



	@Test
	public void testGetLabirinto() {
		assertNotNull("Errore getLabirinto torna null",labirinto.getLabirinto());
		assertEquals("Errore getLabirinto equals",Labirinto.class, labirinto.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		labirinto.addStanza("stanza2");
		Stanza expected = new Stanza("stanza2");
		assertEquals("Errore addStanza",expected, labirinto.getNome2stanza().get("stanza2"));
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta(){
		
		assertEquals("errore addAttrezzoSenzaUltimaStanzaAggiunta",LabirintoBuilder.class, labirinto.addAttrezzo("chiave", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		labirinto.addStanzaIniziale("stanza2").addAttrezzo("chiave", 3);
		Attrezzo expected = new Attrezzo("chiave", 3);
		assertEquals("Errore addAttrezzoConUltimaStanzaAggiunta",expected, labirinto.getLabirinto().getStanzaCorrente().getAttrezzo("chiave"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
        labirinto.addStanza("stanza2");
        labirinto.addAttrezzo("chiave", 3);
        assertTrue("Errore addAttrezzoConStanza",labirinto.getNome2stanza().get("stanza2").hasAttrezzo("chiave"));
    }
}


