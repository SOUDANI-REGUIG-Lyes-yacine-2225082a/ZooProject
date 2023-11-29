package Zoo.Animal.Ovipaire;
import Zoo.Animal.MarineAnimal;

public class Megalodon extends Oviparous implements MarineAnimal {

    public Megalodon(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage à la recherche de bouffe");
    }
}
