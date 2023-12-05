package Animal.Ovipaire;
import Animal.AnimalVolant;

public class Phoenix extends Ovipaire implements AnimalVolant {

    public Phoenix(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " vole de manière royal !");
    }
}
