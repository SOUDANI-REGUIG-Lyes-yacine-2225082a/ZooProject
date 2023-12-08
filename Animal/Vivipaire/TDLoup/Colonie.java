package Animal.Vivipaire.TDLoup;

import java.util.ArrayList;

/**
 * La classe Colonie représente une colonie de loups composée de plusieurs meutes.
 * Elle permet de gérer les meutes de loups au sein de la colonie.
 */
public class Colonie {
    private ArrayList<Meute> meutes;
	

    /**
     * Constructeur de la classe Colonie.
     * Initialise la liste des meutes de loups.
     */
    public Colonie() {
        this.meutes = new ArrayList<Meute>();
    }

    public void showWolfs() {
        System.out.println("Voici les loups de la colonie :");
        for (Meute meute : meutes) {
            for (Loup loup : meute.getWolfs()) {
                System.out.println(loup);
            }
        }
    }

    /**
     * Ajoute une meute à la colonie si elle n'existe pas déjà.
     *
     * @param meute La meute à ajouter.
     */
    public void addWoldPack(Meute meute) {
        if (!this.meutes.contains(meute)) {
            this.meutes.add(meute);
        }
    }

    /**
     * Retourne la liste des meutes de loups présentes dans la colonie.
     *
     * @return Une liste d'objets Meute représentant les meutes de loups.
     */
    public ArrayList<Meute> getWolfPacks() {
        return this.meutes;
    }
}
