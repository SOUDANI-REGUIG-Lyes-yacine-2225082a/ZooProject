package TestUnit;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoupTest {

	Loup loup1, loup2, loup3, loup4;
	Meute meute1;
	ArrayList<Loup> listLoup;

	@Before
	public void setUp() throws Exception {
		loup1 = new Loup("Gris", 1, 1, 1, 'α');
		loup2 = new Loup("Noir", 2, 2, 2, 'α');
		loup3 = new Loup("Blanc", 3, 3, 3, 'α');
		loup4 = new Loup("Rouge", 4, 4, 4, 'α');
		listLoup = new ArrayList<Loup>();
		listLoup.add(loup1);
		listLoup.add(loup2);
		listLoup.add(loup3);
		listLoup.add(loup4);
		meute1 = new Meute(listLoup);
	}

	@After
	public void tearDown() throws Exception {
		loup1 = null;
		loup2 = null;
		loup3 = null;
		loup4 = null;
		listLoup = null;
		meute1 = null;
	}

	@Test
	public void testHowlDomination() {
		loup1.howlDomination(loup2);
		assertEquals(loup1.getViolence(), 2);
	}

	@Test
	public void testHowlSoumission() {
		loup2.howlSoumission(loup1);
		assertEquals(loup2.getViolence(), 3);
	}

	@Test
	public void testHowlAggresive() {
		loup3.howlAggresive(loup4);
		assertEquals(loup3.getViolence(), 5);
	}

	@Test
	public void testWalk() {
		assertEquals(loup1.walk(), "Gris vagabonde !");
	}

	@Test
	public void testGetLevel() {
		assertEquals(loup1.getLevel(), 1);
	}

	@Test
	public void testGetViolence() {
		assertEquals(loup2.getViolence(), 2);
	}

	@Test
	public void testGetRankDomination() {
		assertEquals(loup3.getRankDomination
