package Enclos;

import Animal.AnimalMarin;

public class Aquarium<T extends AnimalMarin> extends Enclosure {
    private int depth;
    private int cleanlinessWater; // 1 = bon / 2 = correct / 3 = mauvais

    public Aquarium(String name, int area, int maxAnimal, int depth) {
        super(name, area, maxAnimal);
        this.depth = depth;
        this.cleanlinessWater = 1;
    }
}
