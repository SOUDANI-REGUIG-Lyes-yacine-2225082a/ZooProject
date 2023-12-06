package Animal.Ovipaire;
import Animal.AnimalVolant;
import Animal.Resurrection;
import Animal.Animal;
import Animal.AnimalMarin;


public class Dragon extends Ovipaire implements AnimalVolant, AnimalMarin, Resurrection {

    /**
     * Dragon
     * @param name
     * @param sex
     * @param weight
     * @param size
     * @Description
     */
    public Dragon(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    @Override
    public String fly() {
        return(super.getName() + " vole majestueusement !");
    }

    @Override
    public String swim() {
    	return(super.getName() + " nage parce que pourquoi pas");
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

