package Enclos;

import Animal.AnimalMarin;

/**
 * Classe représentant un aquarium destiné à héberger des animaux marins.
 *
 * @param <T> Type d'animal marin autorisé dans l'aquarium.
 */
public class Aquarium<T extends AnimalMarin> extends Enclosure {

    private int depth;
    private int cleanlinessWater; // 1 = bon / 2 = correct / 3 = mauvais

    /**
     * Constructeur de la classe Aquarium.
     *
     * @param name       Nom de l'aquarium.
     * @param area       Superficie de l'aquarium.
     * @param maxAnimal  Nombre maximum d'animaux que peut accueillir l'aquarium.
     * @param depth      Profondeur de l'aquarium.
     */
    public Aquarium(String name, int area, int maxAnimal, int depth) {
        super(name, area, maxAnimal);
        this.depth = depth;
        this.cleanlinessWater = 1;
    }
}
