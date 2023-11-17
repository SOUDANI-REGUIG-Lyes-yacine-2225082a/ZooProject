package Zoo.Animal;

public abstract class Oviparous extends Animal {

    public Oviparous(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    public void wander() {
        System.out.println(super.getName() + " vagabonde");
    }

    public void giveBirth() {
        if(super.getSex() == 'f') {
            System.out.println("F�licitations ! " + super.getName() + " a pondue un oeuf !");
        }
    }
}