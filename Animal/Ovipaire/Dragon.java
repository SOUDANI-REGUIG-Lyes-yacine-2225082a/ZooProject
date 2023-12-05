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
    public Dragon(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " vole majestueusement !");
    }

    @Override
    public void swim() {
    	System.out.println(super.getName() + " nage parce que pourquoi pas");
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

