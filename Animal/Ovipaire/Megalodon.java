package Animal.Ovipaire;
import Animal.AnimalMarin;

public class Megalodon extends Ovipaire implements AnimalMarin {

    public Megalodon(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    @Override
    public String swim() {
        return(super.getName() + " nage à la recherche de bouffe");
    }
}
