package Zoo.Animal.Viviparous.Wolf;

import java.util.ArrayList;

public class WolfColony {
    private ArrayList<WolfPack> WolfPacks;

    public WolfColony() {
       this.WolfPacks = new ArrayList<WolfPack>();
    }

    public void showWolfs() {
        System.out.println("Voici les loups de la colonie :");
        for (WolfPack WolfPack : WolfPacks) {
            for(Wolf Wolf : WolfPack.getWolfs()) {
                System.out.println(Wolf);
            }
        }
    }

    public void addWoldPack(WolfPack WolfPack) {
        if(!this.WolfPacks.contains(WolfPack)) {
            this.WolfPacks.add(WolfPack);
        }
    }
    
    public ArrayList<WolfPack> getWolfPacks() {
    	return this.WolfPacks;
    }
}
