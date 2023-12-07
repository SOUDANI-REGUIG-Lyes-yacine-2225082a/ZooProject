package TestUnit;
import Animal.Ovipaire.Dragon;
import Animal.Animal;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//..testpush
public class AnimalTest {

    

 
        Animal animal = new Dragon("TestAnimal", 'M', 50, 54, 5);

  

    @Test
    public void testEatWhenHungry() {
    	animal.setAlive(true);
        animal.setHunger(10);

        assertNotNull(animal.eat());  // Use assertNotNull instead of assertEquals
        assertFalse(animal.isHunger());
    }

    @Test
    public void testEatWhenNotHungry() {
        animal.setAlive(true);
        animal.setHunger(100);

        assertNull(animal.eat());
    }

    @Test
    public void testSound() {
        assertEquals(animal.getName() + " emet un son", animal.sound());
    }

    @Test
    public void testHealWhenUnhealthy() {
        animal.setAlive(true);
        animal.setHealth(false);

        animal.heal();
        assertTrue(animal.isHealth());
    }

    @Test
    public void testHealWhenHealthy() {
        animal.setAlive(true);
        animal.setHealth(true);

        animal.heal();
        assertTrue(animal.isHealth());
    }

    @Test
    public void testToString() {
        String toStringResult = animal.toString();

        // Check if certain information is present in the string representation
        assertTrue(toStringResult.contains("name='TestAnimal'"));
        assertTrue(toStringResult.contains("sex=M"));
        assertTrue(toStringResult.contains("weight=50"));
        assertTrue(toStringResult.contains("size=5"));
        assertTrue(toStringResult.contains("hunger=false"));
        assertTrue(toStringResult.contains("sleep=false"));
        assertTrue(toStringResult.contains("health=true"));
    }
}