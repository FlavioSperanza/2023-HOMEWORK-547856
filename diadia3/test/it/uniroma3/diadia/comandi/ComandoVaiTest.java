package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {

	private Stanza s;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;

	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		s = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		 labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("libro", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(labirinto);
		vai.setIo(io);
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();

	}


	@Test
	public void testVaiNull() {
		p.setStanzaCorrente(s);
		vai.esegui(p);
		assertEquals(s, p.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		p.setStanzaCorrente(s);
		s.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("sud-ovest");
		vai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(s);
		s.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("in fondo a destra");
		vai.esegui(p);
		assertNotEquals(s2, p.getStanzaCorrente());
	}

	@Test
	public void testPartitaConComandoVai() {
		righeDaLeggere.add("vai nord");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());
		
	}
	
	@Test
	public void testPartitaConComandoVaiOvest() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("fine");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Studio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
	@Test
	public void testPartitaConComandoVaiOvestEst() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("vai est");
		righeDaLeggere2.add("fine");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Studio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Atrio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
}


