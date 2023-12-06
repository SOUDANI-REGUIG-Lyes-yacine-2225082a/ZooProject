package Animal.Vivipaire;
import Animal.Animal;
import Animal.AnimalTerrestre;
import Animal.Resurrection;

public class Nymphe extends Vivipaire implements AnimalTerrestre, Resurrection {

	public Nymphe(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

	@Override
	public String walk() {
		return(super.getName() + " se déplace gracieusement ");
	}//.
//..
	@Override 
	public String revive(Animal creature) {
		if (!creature.isAlive()) {
			return creature.getName() + " est en train de ressusciter";

		} else {
			return creature.getName() + " est vivant";
		}
	}
}
