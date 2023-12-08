package Enclos;

import Animal.Animal;

/**
 * Classe représentant un enclos générique destiné à héberger des animaux.
 *
 * @param <T> Type d'animal autorisé dans l'enclos.
 */
public class Enclos<T extends Animal> extends Enclosure<T> {

    /**
     * Constructeur de la classe Enclos.
     *
     * @param name       Nom de l'enclos.
     * @param area       Superficie de l'enclos.
     * @param maxAnimal  Nombre maximum d'animaux que peut accueillir l'enclos.
     */
    public Enclos(String name, int area, int maxAnimal) {
        super(name, area, maxAnimal);
    }
}
