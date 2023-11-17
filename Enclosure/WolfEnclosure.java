package Zoo.Enclosure;

import Zoo.Animal.Animal;
import Zoo.Animal.Wolf;
import Zoo.Animal.WolfPack;

import java.util.ArrayList;

public class WolfEnclosure<T extends Animal> extends Enclosure<T> {
	private WolfPack WolfPack;
	
    public WolfEnclosure(String name, int area, int maxAnimal, WolfPack WolfPack) {
        super(name, area, maxAnimal);
        this.WolfPack = WolfPack;
    }
    
    public void showAnimals() {
    	System.out.println("L'enclos " + this.getName() + " contient les loups :");
    	this.WolfPack.showWolfPack();
    }
    
    // r��criture de la m�thode addAnimal() pour ajouter le Wolf directement dans la meute
    public boolean addAnimal(T Wolf) {
    	WolfPack.addWolf((Wolf) Wolf);
		return true;
    }
    
    // r��criture de la m�thode removeAnimal() pour retirer le Wolf directement de la meute
    public boolean removeAnimal(T Wolf) {
    	WolfPack.removeWolf((Wolf) Wolf);
    	return true;
    }
}
