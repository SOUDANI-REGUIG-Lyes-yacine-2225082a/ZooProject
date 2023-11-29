package Zoo.Animal.Vivipaire;
import Zoo.Animal.WalkingAnimal;

public class Nymphe extends Viviparous implements WalkingAnimal {

    public Nymphe(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " se déplace gracieusement ");
    }
}
