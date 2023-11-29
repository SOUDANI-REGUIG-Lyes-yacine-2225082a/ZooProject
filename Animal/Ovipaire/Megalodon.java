package Zoo.Animal.Ovipaire;
import Zoo.Animal.AnimalMarin;

public class Megalodon extends Ovipaire implements AnimalMarin {

    public Megalodon(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage à la recherche de bouffe");
    }
}
