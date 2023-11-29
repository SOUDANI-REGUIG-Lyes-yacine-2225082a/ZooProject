package Zoo.Animal.Vivipaire;
import Zoo.Animal.Animal;

public abstract class Vivipaire extends Animal {

    public Vivipaire(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    public void wander() {
        System.out.println(super.getName() + " vagabonde");
    }

    public void giveBirth() {
        if(super.getSex() == 'f') {
            System.out.println("F�licitations ! " + super.getName() + " a mit bas !");
        }
    }
}
