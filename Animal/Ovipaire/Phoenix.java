package Animal.Ovipaire;
import Animal.Animal;
import Animal.AnimalVolant;
import Animal.Resurrection;

public class Phoenix extends Ovipaire implements AnimalVolant, Resurrection{

    public Phoenix(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }
    @Override
    public String fly() {
        return(super.getName() + " vole de manière royal !");
    }
    
    @Override 
    public String revive(Animal creature) {
    	if (!creature.isAlive()) {
            return creature.getName() + " est en train de ressusciter";

        } else {
            return creature.getName() + " est vivant";
        }
    }
}
