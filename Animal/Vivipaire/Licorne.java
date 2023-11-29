package Zoo.Animal.Vivipaire;
import Zoo.Animal.WalkingAnimal;

public class Licorne extends Viviparous implements WalkingAnimal{

    public Licorne(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonde !");
    }
}
