package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Comandi.Comando;
import Comandi.ComandoVai;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	private Stanza uno;
	private Stanza due;
	private Comando vai;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		uno = new Stanza("stanza uno");
		due = new Stanza("stanza due");
		vai = new ComandoVai();
		partita = new Partita();
		vai.setIo(new IOConsole());
	}

	@Test
	public void testVaiNull() {
		partita.setStanzaCorrente(uno);
		vai.esegui(partita);
		assertEquals("errore vaiNull",uno, partita.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		partita.setStanzaCorrente(uno);
		uno.impostaStanzaAdiacente("sud-ovest", due);
		vai.setParametro("sud-ovest");
		vai.esegui(partita);
		assertEquals("errore vaiDirezioneEsistente",due, partita.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		partita.setStanzaCorrente(uno);
		uno.impostaStanzaAdiacente("sud-ovest", due);
		vai.setParametro("in fondo a destra");
		vai.esegui(partita);
		assertNotEquals("errore vaiDirezioneInesistente",due, partita.getStanzaCorrente());
	}
}
