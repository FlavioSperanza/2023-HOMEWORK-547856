package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class BorsaTest {

	Borsa b;
	Borsa b1;
	Borsa b2;
	Attrezzo libro;
	Attrezzo zaino;
	Attrezzo scrivania;
	Attrezzo martello;
	Attrezzo computer;
	Attrezzo penna;
	Attrezzo astuccio;

	
	@Before
	public void setUp() {
		b = new Borsa();
		b1 = new Borsa();
		b2 = new Borsa();
		libro = new Attrezzo("libro", 2);
		zaino = new Attrezzo("zaino", 3);
		astuccio = new Attrezzo("astuccio", 3);
		martello = new Attrezzo("martello", 2);
		scrivania = new Attrezzo("scrivania", 16);
		computer = new Attrezzo("computer", 2);
		penna = new Attrezzo("penna", 4);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(libro));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(scrivania));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(libro);
		assertEquals(libro, b.getAttrezzo("libro"));

	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		b1.addAttrezzo(libro);
		b1.addAttrezzo(martello);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(libro);
		expected.add(martello);
		assertArrayEquals(expected.toArray(), b1.getSortedSetOrdinatoPerPeso().toArray());
	}


	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziDiversiPesoDiverso() {
		b2.addAttrezzo(computer);
		b2.addAttrezzo(penna);
		Set<Attrezzo> e = new TreeSet<>();
		e.add(computer);
		e.add(penna);
		assertArrayEquals(e.toArray(), b2.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(libro);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(libro);
		ex.add(martello);
		assertTrue(this.controllaList(ex, b2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoPesiDiversi() {
		b2.addAttrezzo(computer);
		b2.addAttrezzo(penna);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(computer);
		ex.add(penna);
		assertTrue(this.controllaList(ex, b2.getContenutoOrdinatoPerPeso()));
	}
	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}
	
	@Test
	public void testControllaSet() {
		Set<Attrezzo> e = new TreeSet<>();
		e.add(libro);
		e.add(martello);
		assertTrue(this.controllaSet(e, e));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoPeso() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(libro);

		Set<Attrezzo> e = new TreeSet<>();
		e.add(libro);
		e.add(martello);
		assertTrue(this.controllaSet(e, b2.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomePesoDiverso() {
		b2.addAttrezzo(zaino);
		b2.addAttrezzo(martello);

		Set<Attrezzo> e = new TreeSet<>();
		e.add(zaino);
		e.add(martello);
		
		assertTrue(this.controllaSet(e, b2.getSortedSetOrdinatoPerPeso()));
	}

	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testControllaMap() {
		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new TreeSet<>();
		Set<Attrezzo> sing2 = new TreeSet<>();
		
		sing1.add(martello);
		sing2.add(zaino);
		
		e.put(2, sing1);
		e.put(3, sing2);
		assertTrue(this.controllaMap(e, e));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiSingleton() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(zaino);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new TreeSet<>();
		Set<Attrezzo> sing2 = new TreeSet<>();
		
		sing1.add(martello);
		sing2.add(zaino);
		
		e.put(2, sing1);
		e.put(3, sing2);
		
		System.out.println(e);
		System.out.println(b2.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b2.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiGruppi() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(zaino);
		b2.addAttrezzo(astuccio);
		b2.addAttrezzo(libro);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new HashSet<>();
		Set<Attrezzo> sing2 = new HashSet<>();
		
		sing1.add(martello);
		sing2.add(zaino);
		sing2.add(astuccio);
		sing1.add(libro);
		
		e.put(2, sing1);
		e.put(3, sing2);
		
		System.out.println(e);
		System.out.println(b2.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b2.getContenutoRaggruppatoPerPeso()));
	}
}
