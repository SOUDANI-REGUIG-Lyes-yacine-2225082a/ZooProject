package Animal.Ovipaire;
import Animal.AnimalVolant;
import Animal.AnimalMarin;


public class Dragon extends Ovipaire implements AnimalVolant, AnimalMarin {

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

    }
}
