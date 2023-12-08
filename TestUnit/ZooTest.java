
package TestUnit;

import Enclos.Enclosure;
import Enclos.Voliere;
import Maitre.Kaaris;
import Animal.Animal;
import Animal.Ovipaire.Dragon;
import Zoo.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class ZooTest {

     private Zoo zoo;
     private Animal ani1;
     Enclosure enclosure1;
     Enclosure enclosure2;
     Enclosure enclosure3;
     
     @BeforeEach
     public void setUp() {
    	
         zoo = new Zoo("TestZoo", new Kaaris("Kaaris", 'M', 45), 10);
         ani1 = new Dragon("MALFOY", 'F', 1223, 86, 45);
         enclosure1 = new Voliere<Dragon>("TestEnclosure1", 10, 10, 10);
         enclosure2 = new Voliere<Dragon>("TestEnclosure2", 10, 10, 10);
         enclosure3 = new Voliere<Dragon>("TestEnclosure3", 10, 10, 10);
     }

     @Test
     public void testAddEnclosure() {
         Enclosure enclosure = new Enclosure("TestEnclosure", 10, 10);
         zoo.addEnclosure(enclosure);
     }

     @Test
     public void testShowNbAnimals() {
         zoo.addEnclosure(enclosure1);
         zoo.addEnclosure(enclosure2);
         zoo.addEnclosure(enclosure3);
         enclosure1.addAnimal(ani1);
         enclosure2.addAnimal(ani1);
         enclosure3.addAnimal(ani1);
         assertEquals(3, zoo.showNbAnimals());
     }

     

 }