package Zoo.Animal;

public class Dragon extends Oviparous implements FlyingAnimal{

    public Dragon(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " vole majestueusement !");
    }
}
