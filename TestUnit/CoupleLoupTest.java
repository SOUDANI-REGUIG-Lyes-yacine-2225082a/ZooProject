package TestUnit;

import Animal.Vivipaire.TDLoup.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoupleLoupTest {

	private CoupleLoup coupleLoup;
	private Loup alphaMale;
	private Loup alphaFemale;
	private Loup betaMale;

	@BeforeEach
	public void setUp() {
		alphaMale = new Loup("AlphaMale", 'M', 50, 5, 100,  'α');
		alphaFemale = new Loup("AlphaFemale", 'F', 45, 4, 97,'α');
		betaMale = new Loup("BetaMale", 'M', 40, 3, 15,'β');

		coupleLoup = new CoupleLoup(alphaMale, alphaFemale);
	}

	@Test
	public void testSetWolfMale() {
		coupleLoup.setWolfMale(betaMale);

		assertEquals(betaMale, coupleLoup.getWolfMale());
	}

	@Test
	public void testSetWolfFemale() {
		coupleLoup.setWolfFemale(betaMale);

		assertEquals(betaMale, coupleLoup.getWolfFemale());
	}

	@Test
	public void testSetWolfMaleWrongSex() {
		Loup female = new Loup("Female", 'F', 40, 3, 67,'β');
		coupleLoup.setWolfMale(female);

		assertNull(coupleLoup.getWolfMale());
	}

	@Test
	public void testSetWolfFemaleWrongSex() {
		Loup male = new Loup("Male", 'M', 40, 3, 49,'β');
		coupleLoup.setWolfFemale(male);

		assertNull(coupleLoup.getWolfFemale());
	}

}