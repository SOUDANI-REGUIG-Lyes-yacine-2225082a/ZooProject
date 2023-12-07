package TestUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Animal.Vivipaire.Licorne;

public class LicorneTest {

    private Licorne licorne;

    @BeforeEach
    public void setUp() {
        licorne = new Licorne("Luna", 'f', 300, 8, 4);
    }

    @Test
    public void testWalk() {
        assertEquals("Luna vagabonde !", licorne.walk());
    }
}