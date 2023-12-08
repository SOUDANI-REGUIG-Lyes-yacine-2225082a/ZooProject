package Animal.Ovipaire;

import Animal.Animal;

/**
 * La classe  Ovipaire représente les animaux qui sont ovipares c'est-à-dire qu'ils se reproduisent en pondant des œufs.
 * Elle est une sous-classe de la classe abstraite Animal.
 */
public abstract class Ovipaire extends Animal {

    /**
     * Constructeur de la classe Ovipaire.
     *
     * @param name   Le nom de l'ovipare.
     * @param sex    Le sexe de l'ovipare.
     * @param weight Le poids de l'ovipare.
     * @param size   La taille de l'ovipare.
     * @param age    L'âge de l'ovipare.
     */
    public Ovipaire(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Méthode permettant à l'ovipare de se balader.
     */
    public void wander() {
        System.out.println(super.getName() + " vagabonde");
    }

    /**
     * Méthode permettant à l'ovipare de donner naissance à des œufs.
     * Affiche un message de félicitations si l'ovipare est de sexe féminin.
     */
    public void giveBirth() {
        if (super.getSex() == 'f') {
            System.out.println("Félicitations ! " + super.getName() + " a pondu un œuf !");
        }
    }
}
