package Animal.Ovipaire;
import Animal.Animal;

public abstract class Ovipaire extends Animal {

    public Ovipaire(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    public void wander() {
        System.out.println(super.getName() + " vagabonde");
    }

    public void giveBirth() {
        if(super.getSex() == 'f') {
            System.out.println("Félicitations ! " + super.getName() + " a pondue un oeuf !");
        }
    }
}
