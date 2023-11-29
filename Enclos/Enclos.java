package Zoo.Enclos;

import Zoo.Animal.Animal;

public class Enclos<T extends Animal> extends Enclosure<T> {

    public Enclos(String name, int area, int maxAnimal) {
        super(name, area, maxAnimal);
    }
}
