package Zoo.Animal.Vivipaire;
import Zoo.Animal.AnimalTerrestre;

public class Nymphe extends Vivipaire implements AnimalTerrestre {

    public Nymphe(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " se déplace gracieusement ");
    }
}
