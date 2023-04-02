package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class StanzaTest {
	
	private Stanza centrale;
	private Stanza nord;
	private Stanza sud;
	private Stanza est;
	private Stanza ovest;
	
	private Stanza piena;
	
	private Stanza vuota;
	
	@Before
	public void setUp() {
		this.nord = new Stanza("nord");
		this.sud = new Stanza("sud");
		this.est = new Stanza("est");
		this.ovest = new Stanza("ovest");
		this.centrale = new  Stanza("centrale");
		this.centrale.impostaStanzaAdiacente("nord", nord);
		this.centrale.impostaStanzaAdiacente("sud", sud);
		this.centrale.impostaStanzaAdiacente("est", est);
		this.centrale.impostaStanzaAdiacente("ovest", ovest);
		
		Attrezzo martello = new Attrezzo("martello", 5);
		Attrezzo libro = new Attrezzo("libro", 3);
		Attrezzo pc = new Attrezzo("pc", 4);
		Attrezzo zaino = new Attrezzo("zaino", 3);
		
		this.piena = new Stanza("piena");
		this.piena.addAttrezzo(martello);
		this.piena.addAttrezzo(libro);
		this.piena.addAttrezzo(pc);
		this.piena.addAttrezzo(zaino);
		
		this.vuota = new Stanza("stanza vuota e senza adiacenze");
	}
	
	//test per impostaStanzaAdiacente
	@Test
	public void testImpostaAdiacenzaNord() {
		this.vuota.impostaStanzaAdiacente("nord", nord);
		assertEquals("errore imposta adiacenza nord", nord, this.vuota.getStanzaAdiacente("nord"));
	}
	public void testImpostaAdiacenzaSud() {
		this.vuota.impostaStanzaAdiacente("sud", sud);
		assertEquals("errore imposta adiacenza sud", sud, this.vuota.getStanzaAdiacente("sud"));
	}
	public void testImpostaAdiacenzaEst() {
		this.vuota.impostaStanzaAdiacente("est", est);
		assertEquals("errore imposta adiacenza est", est, this.vuota.getStanzaAdiacente("est"));
	}
	public void testImpostaAdiacenzaOvest() {
		this.vuota.impostaStanzaAdiacente("ovest", ovest);
		assertEquals("errore imposta adiacenza ovest", ovest, this.vuota.getStanzaAdiacente("ovest"));
	}
	
	//test per getStanzaAdiacente
	@Test
	public void testGetAdiacenteNord() {
		assertEquals("errore get adiacenza nord", nord, this.centrale.getStanzaAdiacente("nord"));
	}
	public void testGetAdiacenteSud() {
		assertEquals("errore get adiacenza sud", sud, this.centrale.getStanzaAdiacente("sud"));
	}
	public void testGetAdiacenteEst() {
		assertEquals("errore get adiacenza est", est, this.centrale.getStanzaAdiacente("est"));
	}
	public void testGetAdiacenteOvest() {
		assertEquals("errore get adiacenza ovest", ovest, this.centrale.getStanzaAdiacente("ovest"));
	}
	
	//test per addAttrezzo
	@Test
	public void testAddAttrezzoVuota() {
		Attrezzo gomma = new Attrezzo("gomma", 1);
		assertTrue("errore addAttrezzo su stanza vuota", this.vuota.addAttrezzo(gomma));
	}
	public void testAddAttrezzoPiena() {
		Attrezzo penna = new Attrezzo("penna", 1);
		assertFalse("errore addAttrezzo su stanza piena", this.piena.addAttrezzo(penna));
	}
	public void testAddAttrezzoNullo() {
		assertFalse("errore addAttrezzo nullo", this.vuota.addAttrezzo(null));
	}
	
	//test per hasAttrezzo
	@Test
	public void testHasAttrezzoStanzaPiena() {
		assertTrue("errore hasAttrezzo su stanza piena", this.piena.hasAttrezzo("martello"));
	}
	public void testHasAttrezzoStanzaVuota() {
		assertFalse("errore hasAttrezzo su stanza vuota", this.vuota.hasAttrezzo("martello"));
	}
	public void testHasAttrezzoInesistente() {
		assertFalse("errore hasAttrezzo per un attrezzo inesistente", this.piena.hasAttrezzo("penna"));
	}
	
	
	//test per getAttrezzo
	@Test
	public void testGetAttrezzoStanzaPiena() {
		assertEquals("errore getAttrezzo su stanza piena", "martello (5kg)", this.piena.getAttrezzo("martello").toString());
	}
	public void getAttrezzoStanzaVuota() {
		assertNull("errore getAttrezzo su stanza vuota", this.vuota.getAttrezzo("martello"));
	}
	public void getAttrezzoInesistente() {
		assertNull("errore getAttrezzo per attrezzo inesistente", this.piena.getAttrezzo("penna"));
	}
	
	
	//test per removeAttrezzo
	@Test
	public void testRemoveAttrezzoStanzaPiena() {
		assertTrue("errore removeAttrezzo su stanza piena", this.piena.removeAttrezzo("martello"));
	}
	public void removeAttrezzoStanzaVuota() {
		assertFalse("errore removeAttrezzo su stanza vuota", this.vuota.removeAttrezzo("martello"));
	}
	public void testRemoveAttrezzoInesistente() {
		assertFalse("errore removeAttrezzo inesistente", this.piena.removeAttrezzo("matita"));
	}
	

	
		
	
	
	
}
	