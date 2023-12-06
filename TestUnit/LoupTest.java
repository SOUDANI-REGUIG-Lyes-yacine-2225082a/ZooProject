package TestUnit;

import Animal.Vivipaire.TDLoup.Colonie;
import Animal.Vivipaire.TDLoup.CoupleLoup;
import Animal.Vivipaire.TDLoup.Loup;
import Animal.Vivipaire.TDLoup.Meute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LoupTest {

	private Colonie Colonie;
	private CoupleLoup CoupleLoup;
	private ArrayList<Loup> loups;
	private String howl;
    private Loup alphaLoup;
    private Loup betaLoup;
    private Meute meute;
    private Loup loup;

    @BeforeEach
    public void setUp() {
        alphaLoup = new Loup("Alpha", 'm', 80, 7,1 ,'α');
        betaLoup = new Loup("Beta", 'm', 70, 6, 8 , 'β');
        meute = new Meute(Colonie, CoupleLoup, howl);
        loup = new Loup("TestLoup", 'm', 50, 5, 9, 'α');
    }
        


    @Test
    public void testDominateBetaLoup() {
        alphaLoup.setWolfPack(meute);
        betaLoup.setWolfPack(meute);

        alphaLoup.dominate(betaLoup);

        assertEquals(1, alphaLoup.getRankDomination());
        assertEquals(0, betaLoup.getRankDomination());
        assertEquals('α', alphaLoup.getRankDomination());
        assertEquals('β', betaLoup.getRankDomination());
        assertEquals(2, alphaLoup.getLevel());
        assertEquals(1, betaLoup.getLevel());
    }

    @Test
    public void testMakeOld() {
        // Set the age to 2 for testing the case where the age is not 3
        loup.setAge(2);

        // Call the makeOld method
        loup.makeOld();

        // Check if the age has been incremented
        assertEquals(3, loup.getAge(), "Age should be incremented to 3");

        // You can add more assertions based on your specific requirements
    }
    // Add more tests as needed to cover other functionalities of the Loup class
}
