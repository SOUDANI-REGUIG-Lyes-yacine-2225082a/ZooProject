package Animal.Vivipaire;
import Animal.AnimalTerrestre;

public class Licorne extends Vivipaire implements AnimalTerrestre {

    public Licorne(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    @Override
    public String walk() {
      return(super.getName() + " vagabonde !");
    }
}
