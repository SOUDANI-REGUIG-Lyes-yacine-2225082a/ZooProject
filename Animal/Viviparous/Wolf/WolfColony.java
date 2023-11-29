package Zoo.Animal.Viviparous.Wolf;

import java.util.ArrayList;

public class WolfColony {
    private ArrayList<Meute> meutes;

    public WolfColony() {
       this.meutes = new ArrayList<Meute>();
    }

    public void showWolfs() {
        System.out.println("Voici les loups de la colonie :");
        for (Meute Meute : meutes) {
            for(Loup Loup : Meute.getWolfs()) {
                System.out.println(Loup);
            }
        }
    }

    public void addWoldPack(Meute Meute) {
        if(!this.meutes.contains(Meute)) {
            this.meutes.add(Meute);
        }
    }
    
    public ArrayList<Meute> getWolfPacks() {
    	return this.meutes;
    }
}
