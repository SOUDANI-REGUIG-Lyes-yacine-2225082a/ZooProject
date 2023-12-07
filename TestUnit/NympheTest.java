package TestUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Animal.Vivipaire.Nymphe;

public class NympheTest {

    private Nymphe nymphe;

    @BeforeEach
    public void setUp() {
        nymphe = new Nymphe("Nymphadora", 'f', 30, 1,4);
    }

    @Test
    public void testWalk() {
        assertEquals("Nymphadora se déplace gracieusement ", nymphe.walk());
    }

    @Test
    public void testReviveWhenCreatureIsDead() {
        Nymphe creature = new Nymphe("DeadCreature", 'm', 50, 2,7200);
        creature.setAlive(false);

        assertEquals("DeadCreature est en train de ressusciter", nymphe.revive(creature));
    }
}