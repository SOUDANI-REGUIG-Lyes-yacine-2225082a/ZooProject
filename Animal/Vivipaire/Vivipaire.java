package Animal.Vivipaire;

import Animal.Animal;

/**
 * La classe Vivipaire représente une catégorie d'animaux vivipares.
 * Elle étend la classe Animal.
 */
public abstract class Vivipaire extends Animal {

    /**
     * Constructeur de la classe Vivipaire.
     *
     * @param name   Le nom de l'animal vivipare.
     * @param sex    Le sexe de l'animal vivipare.
     * @param weight Le poids de l'animal vivipare.
     * @param size   La taille de l'animal vivipare.
     * @param age    L'âge de l'animal vivipare.
     */
    public Vivipaire(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Méthode permettant à l'animal vivipare de vagabonder.
     */
    public void wander() {
        System.out.println(super.getName() + " vagabonde");
    }

    /**
     * Méthode permettant à l'animal vivipare de donner naissance à des petits.
     * Affiche un message de félicitations si l'animal est de sexe femelle.
     */
    public void giveBirth() {
        if (super.getSex() == 'f') {
            System.out.println("Félicitations ! " + super.getName() + " a mis bas !");
        }
    }
}
