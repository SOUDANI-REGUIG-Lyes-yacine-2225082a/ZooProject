package Enclos;

import Animal.Animal;

public class Enclos<T extends Animal> extends Enclosure<T> {

    public Enclos(String name, int area, int maxAnimal) {
        super(name, area, maxAnimal);
    }
}
