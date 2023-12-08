package TestUnit;
import Animal.Ovipaire.Dragon;

import Animal.Animal;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//..testpush
public class AnimalTest {

    


    @BeforeEach
    public void setUp() {
        animal = new Dragon("TestAnimal", 'm', 50, 54, 5);
    }

        Animal animal = new Dragon("TestAnimal", 'M', 50, 54, 5);

  

    @Test
    public void testEatWhenHungry() {
    	animal.setAlive(true);
        animal.setHunger(10);

        assertNotNull(animal.eat()); 
    }

    @Test
    public void testEatWhenNotHungry() {
        animal.setAlive(true);
        animal.setHunger(100);

        assertNull(animal.eat());
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
        //.
        // Check if certain information is present in the string representation
        assertTrue(toStringResult.contains("name='TestAnimal'"));
        assertTrue(toStringResult.contains("sex=m"));
        assertTrue(toStringResult.contains("weight=50"));
        assertTrue(toStringResult.contains("size=5"));
        assertTrue(toStringResult.contains("hunger=" + animal.getHunger()));
        assertTrue(toStringResult.contains("sleep=false"));
        assertTrue(toStringResult.contains("health=true"));
    }
}