package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore();
	
	//test per getCfu
	@Test
	public void testGetCfuDiPartenza() {
		assertEquals("errore getCfu", 20, g.getCfu());
	}
	
	//test per setCfu
	@Test
	public void testSetCfu() {
		g.setCfu(3);
		assertEquals("errore setCfu", 3, g.getCfu());
	}

	//test per getBorsa
	@Test
	public void testGetBorsa() {
		assertNotNull("errore getBorsa", g.getBorsa());
	}
}
