package Animal.Vivipaire;
import Animal.AnimalMarin;


public class Sirene extends Vivipaire implements AnimalMarin {

    public Sirene(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    @Override
    public String swim() {
        return(super.getName() + " nage ");
    }
}
