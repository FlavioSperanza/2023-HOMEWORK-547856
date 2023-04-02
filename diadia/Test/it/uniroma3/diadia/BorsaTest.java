package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {

	Borsa borsa = new Borsa();
	Attrezzo astuccio;
	Attrezzo incudine;
	
	@Before
	public void setUp() {
		astuccio = new Attrezzo("astuccio", 4);
		incudine = new Attrezzo("incudine", 11);
	}

	//test per addAttrezzo
	@Test
	public void testAddAttrezzoMinoreDiPesoMax() {
		assertTrue("errore addAttrezzo di peso minore di 10", borsa.addAttrezzo(astuccio));

	}
	public void testAddAttrezzoPesoMaggioreDiPesoMax() {
		assertFalse("errore addAttrezzo di peso maggiore di 10", borsa.addAttrezzo(incudine));

	}
	
	//test per getAttrezzo
	@Test
	public void testGetAttrezzo() {
		borsa.addAttrezzo(astuccio);
		assertEquals("errore getAttrezzo", astuccio, borsa.getAttrezzo("astuccio"));

	}
	
	//test per getPeso
	public void testGetPesoBorsaVuota() {
		assertEquals("errore getPeso su borsa vuota", 0, this.borsa.getPeso());
	}
	public void testGetPesoBorsaPiena() {
		this.borsa.addAttrezzo(astuccio);
		assertEquals("errorre getPeso su borsa piena", 4, this.borsa.getPeso());
	}
	
	//test per hasAttrezzo
	public void testHasAttrezzoBorsaPiena() {
		this.borsa.addAttrezzo(astuccio);
		assertTrue("errore hasAttrezzo su borsa piena", this.borsa.hasAttrezzo("astuccio"));
	}
	public void testHasAttrezzoBorsaVuota() {
		assertFalse("errore hasAttrezzo su borsa vuota", this.borsa.hasAttrezzo("astuccio"));
	}
	
	//test per removeAttrezzo
	public void testRemoveAttrezzoBorsaPiena() {
		this.borsa.addAttrezzo(astuccio);
		assertEquals("errore removeAttrezzo su borsa piena", astuccio, this.borsa.removeAttrezzo("astuccio"));
	}
	public void testRemoveAttrezzoBorsaVuota() {
		assertNull("errore removeAttrezzo su borsa vuota", this.borsa.removeAttrezzo("astuccio"));
	}
}