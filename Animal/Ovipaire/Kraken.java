package Animal.Ovipaire;
import Animal.AnimalMarin;

public class Kraken extends Ovipaire implements AnimalMarin {

    public Kraken(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage ");
    }
}
