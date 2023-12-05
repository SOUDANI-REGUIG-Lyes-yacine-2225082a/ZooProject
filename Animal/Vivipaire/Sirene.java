package Animal.Vivipaire;
import Animal.AnimalMarin;


public class Sirene extends Vivipaire implements AnimalMarin {

    public Sirene(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage ");
    }
}
