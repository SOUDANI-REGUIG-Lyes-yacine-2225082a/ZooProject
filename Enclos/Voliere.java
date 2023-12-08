package Enclos;

import Animal.AnimalVolant;

/**
 * Classe représentant une volière destinée à héberger des animaux volants.
 *
 * @param <T> Type d'animal volant autorisé dans la volière.
 */
public class Voliere<T extends AnimalVolant> extends Enclosure<T> {
    private int height;

    /**
     * Constructeur de la classe Voliere.
     *
     * @param name      Nom de la volière.
     * @param area      Superficie de la volière.
     * @param maxAnimal Nombre maximum d'animaux que peut accueillir la volière.
     * @param height    Hauteur de la volière.
     */
    public Voliere(String name, int area, int maxAnimal, int height) {
        super(name, area, maxAnimal);
        this.height = height;
    }
}
