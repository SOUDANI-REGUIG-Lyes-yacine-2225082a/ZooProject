package Zoo.Animal;

public class Nymph extends Viviparous implements WalkingAnimal {

    public Nymph(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " se déplace gracieusement ");
    }
}
