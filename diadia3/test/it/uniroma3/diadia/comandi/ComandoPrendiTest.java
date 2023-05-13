package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzone;
	private Comando comando;
	private IO io;
	Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("libro", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("libro", 2);
		attrezzone = new Attrezzo("mattone", 11);
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}

	
	public boolean attrezzoPresente(String s) {
		if(partita.getStanzaCorrente().getAttrezzo(s)==null)
			return false;
		return true;
		}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("libro");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("libro"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("libro");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("libro"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzone);
		comando.setParametro("mattone");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("mattone"));
	}
	
}
