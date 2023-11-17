package Zoo.Animal.Viviparous;
import Zoo.Animal.WalkingAnimal;

public class Unicorn extends Viviparous implements WalkingAnimal{

    public Unicorn(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonde !");
    }
}
