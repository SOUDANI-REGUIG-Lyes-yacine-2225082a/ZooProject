package Zoo.Enclos;

import Zoo.Animal.AnimalMarin;

public class Aquarium<T extends AnimalMarin> extends Enclosure {
    private int depth;
    private int cleanlinessWater; // 1 = propre / 2 = �tat moyen / 3 = sale

    public Aquarium(String name, int area, int maxAnimal, int depth) {
        super(name, area, maxAnimal);
        this.depth = depth;
        this.cleanlinessWater = 1;
    }
}
