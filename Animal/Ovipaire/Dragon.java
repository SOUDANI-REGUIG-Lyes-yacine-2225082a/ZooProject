package Zoo.Animal.Ovipaire;
import Zoo.Animal.FlyingAnimal;


public class Dragon extends Oviparous implements FlyingAnimal  {

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
}
