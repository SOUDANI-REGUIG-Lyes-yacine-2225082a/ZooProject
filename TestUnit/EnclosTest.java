
package TestUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Animal.Animal;
import Animal.Ovipaire.Dragon;
import Enclos.Enclos;
import Enclos.Enclosure;
import Maitre.Kaaris;

class EnclosTest {

	private Enclos<Animal> enclos;
	private Kaaris kaaris;
	private Animal animal;

	@BeforeEach
	public void setUp() {
		kaaris = new Kaaris("Kaaris", 'M', 45);
		animal = new Dragon("San goku", 'm', 2000, 100, 150);
		enclos= new Enclos<Animal>("Enclos 1", 10, 10);
	}

	@Test
	void testEnclosure() {
		assertNotNull(enclos);
	}

	@Test
	void testClean() {
		enclos.clean();
		assertTrue(enclos.getCleanliness() == 3);
	}

	

	@Test
	void testAddAnimal() {
		enclos.addAnimal(animal);
		assertTrue(enclos.getNbAnimal() == 1);
	}

	@Test
	void testRemoveAnimal() {
		enclos.addAnimal(animal);
		enclos.removeAnimal(animal);
		assertTrue(enclos.getNbAnimal() == 0);
	}

	@Test
	void testGetInfos() {
		String toStringResult = enclos.getInfos();
		assertTrue(toStringResult.contains("Niveau de proprete="+enclos.getCleanliness()));
		assertTrue(enclos.getNbAnimal() == 0);
	}

}




