package Zoo.Animal;

public class Phoenix extends Oviparous implements FlyingAnimal {

    public Phoenix(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " vole de manière royal !");
    }
}
