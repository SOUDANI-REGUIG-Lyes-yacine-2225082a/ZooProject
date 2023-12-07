package TestUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Animal.Ovipaire.Dragon;

public class DragonTest {

    private Dragon dragon;

    @BeforeEach
    public void setUp() {
        dragon = new Dragon("Drogon", 'm', 500, 10, 41);
    }

    @Test
    public void testFly() {
        assertEquals("Drogon vole majestueusement !", dragon.fly());
    }

    @Test
    public void testSwim() {
        assertEquals("Drogon nage parce que pourquoi pas", dragon.swim());
    }

    @Test
    public void testReviveWhenCreatureIsDead() {
        Dragon creature = new Dragon("DeadCreature", 'f', 100, 5, 23);
        creature.setAlive(false);

        assertEquals("DeadCreature est en train de ressusciter", dragon.revive(creature));
    }
}
