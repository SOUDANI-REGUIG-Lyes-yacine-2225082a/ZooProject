package Zoo.Enclos;

import Zoo.Animal.Animal;
import Zoo.Animal.Vivipaire.TDLoup.*;

public class WolfEnclosure<T extends Animal> extends Enclosure<T> {
	private Meute Meute;
	
    public WolfEnclosure(String name, int area, int maxAnimal, Meute Meute) {
        super(name, area, maxAnimal);
        this.Meute = Meute;
    }
    
    public void showAnimals() {
    	System.out.println("L'enclos " + this.getName() + " contient les loups :");
    	this.Meute.showWolfPack();
    }
    
    // r��criture de la m�thode addAnimal() pour ajouter le Wolf directement dans la meute
    public boolean addAnimal(T Wolf) {
    	Meute.addWolf((Loup) Wolf);
		return true;
    }
    
    // r��criture de la m�thode removeAnimal() pour retirer le Wolf directement de la meute
    public boolean removeAnimal(T Wolf) {
    	Meute.removeWolf((Loup) Wolf);
    	return true;
    }
}
