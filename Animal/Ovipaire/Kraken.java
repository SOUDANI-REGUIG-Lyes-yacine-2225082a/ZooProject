package Zoo.Animal.Ovipaire;
import Zoo.Animal.MarineAnimal;

public class Kraken extends Oviparous implements MarineAnimal {

    public Kraken(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage ");
    }
}
