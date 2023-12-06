package TestUnit;

import Animal.Vivipaire.TDLoup.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColonieTest {

    private Colonie colonie;
    private Meute meute1;
    private Meute meute2;

    @BeforeEach
    public void setUp() {
        colonie = new Colonie();
        meute1 = new Meute(null, null, "Howl1");
        meute2 = new Meute(null, null, "Howl2");
    }

    @Test
    public void testAddWoldPack() {
        colonie.addWoldPack(meute1);

        assertTrue(colonie.getWolfPacks().contains(meute1));
    }

    @Test
    public void testAddWoldPackDuplicate() {
        colonie.addWoldPack(meute1);
        colonie.addWoldPack(meute1);

        assertEquals(1, colonie.getWolfPacks().size());
    }

    @Test
    public void testGetWolfPacks() {
        colonie.addWoldPack(meute1);
        colonie.addWoldPack(meute2);

        assertEquals(2, colonie.getWolfPacks().size());
    }
}
