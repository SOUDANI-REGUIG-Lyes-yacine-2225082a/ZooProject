package Zoo.Animal.Viviparous;
import Zoo.Animal.MarineAnimal;


public class Mermaid extends Viviparous implements MarineAnimal {

    public Mermaid(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage ");
    }
}
