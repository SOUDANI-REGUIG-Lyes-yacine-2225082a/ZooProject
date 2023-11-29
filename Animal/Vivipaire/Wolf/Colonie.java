package Zoo.Animal.Vivipaire.Wolf;

import java.util.ArrayList;

public class Colonie {
    private ArrayList<Meute> meutes;

    public Colonie() {
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
