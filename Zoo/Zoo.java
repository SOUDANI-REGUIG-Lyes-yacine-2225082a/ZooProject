package Zoo;

import java.util.ArrayList;


import Enclos.Enclosure;
import Maitre.Kaaris;

// Design Pattern : Singleton
public final class Zoo {
    private String name;
    private Kaaris kaaris;
    private int maxEnclosure;
    private ArrayList<Enclosure> enclosures;
    
    public Zoo(String name, Kaaris kaaris, int maxEnclosure) {
        this.name = name;
        this.kaaris = kaaris;
        this.maxEnclosure = maxEnclosure;
        this.enclosures = new ArrayList<Enclosure>();
    }


    public void addEnclosure(Enclosure enclosure) {
        if(this.enclosures.size() <= this.maxEnclosure) {
        	this.enclosures.add(enclosure);
            System.out.println("L'enclos " + enclosure.getName() + " a ete ajoute au Zoo " + this.name);
        }else
        	System.out.println("Il y a deja trop d'enclos");
    }
    	
    public String showNbAnimals() {
        int nbAnimals = 0;
        for(Enclosure enclosure : this.enclosures) {
            nbAnimals += enclosure.getNbAnimal();
        }
        return("Le zoo " + this.name + " a " + nbAnimals + " animaux");
    }

    public void showAllAnimals() {
        System.out.println("=== Tous les animaux du zoo " + this.name + " ===");
        for(Enclosure enclosure : this.enclosures) {
            System.out.println("Animaux de l'enclos " +  enclosure.getName() +  " : " + enclosure.getAnimals());
        }
    }
    
    

    public ArrayList<Enclosure> getEnclosures() {
		return enclosures;
	}


	public void setName(String name) {
        this.name = name;
    }

    public void setMaxEnclosure(int maxEnclosure) {
        this.maxEnclosure = maxEnclosure;
    }

    public void setEnclosures(ArrayList<Enclosure> enclosures) {
        this.enclosures = enclosures;
    }

    public void setEmployee(Kaaris kaaris) {
        this.kaaris = kaaris;
    }
}
