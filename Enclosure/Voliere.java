package Zoo.Enclosure;

import Zoo.Animal.AnimalVolant;

public class Voliere<T extends AnimalVolant> extends Enclosure {
    private int height;


    public Voliere(String name, int area, int maxAnimal, int height) {
        super(name, area, maxAnimal);
        this.height = height;
    }
}
