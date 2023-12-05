package Animal.Vivipaire;
import Animal.AnimalTerrestre;

public class Licorne extends Vivipaire implements AnimalTerrestre {

    public Licorne(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonde !");
    }
}
