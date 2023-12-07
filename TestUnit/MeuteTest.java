package TestUnit;

import Animal.Vivipaire.TDLoup.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeuteTest {

    private Meute meute;
    private Loup alphaMale;
    private Loup alphaFemale;
    private Loup omegaLoup;

    @BeforeEach
    public void setUp() {
        alphaMale = new Loup("AlphaMale", 'm', 50, 5, 1,'α');
        alphaFemale = new Loup("AlphaFemale", 'f', 45, 4, 7,'α');
        omegaLoup = new Loup("OmegaLoup", 'm', 40, 3, 9 ,'ω');

        CoupleLoup coupleLoup = new CoupleLoup(alphaMale, alphaFemale);
        meute = new Meute(null, coupleLoup, "Aouuuuuh");

        meute.constituteCouple(alphaMale);
        meute.addWolf(alphaFemale);
        meute.addWolf(omegaLoup);
    }

    @Test
    public void testAddWolf() {
        Loup newWolf = new Loup("NewWolf", 'M', 30, 3, 6,'γ');
        meute.addWolf(newWolf);

        assertTrue(meute.getWolfs().contains(newWolf));
    }

    @Test
    public void testRemoveWolf() {
        meute.removeWolf(alphaFemale);

        assertFalse(meute.getWolfs().contains(alphaFemale));
    }

    @Test
    public void testSetOmegaWolf() {
        meute.setOmegaWolf(alphaMale);

        assertEquals('ω', alphaMale.getRankDomination());
    }

    @Test
    public void testGiveBirth() {
        meute.giveBirth();

        assertEquals(3, meute.getWolfs().size());
    }

    @Test
    public void testDecreaseRank() {
        meute.decreaseRank(alphaMale);

        assertEquals('β', alphaMale.getRankDomination());
    }

    // Add more tests based on the functionality you want to validate in the Meute class
}
