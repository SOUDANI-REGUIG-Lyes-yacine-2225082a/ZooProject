package Animal.Vivipaire;

import Animal.AnimalMarin;

/**
 * La classe Sirene représente une créature imaginaire vivipare et marine.
 * Elle hérite de la classe Vivipaire et implémente l'interface AnimalMarin.
 */
public class Sirene extends Vivipaire implements AnimalMarin {

    /**
     * Constructeur de la classe Sirene.
     *
     * @param name   Le nom de la sirène.
     * @param sex    Le sexe de la sirène.
     * @param weight Le poids de la sirène.
     * @param size   La taille de la sirène.
     * @param age    L'âge de la sirène.
     */
    public Sirene(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode swim() de l'interface AnimalMarin.
     *
     * @return Une chaîne de caractères indiquant que la sirène nage.
     */
    @Override
    public String swim() {
        return super.getName() + " nage";
    }
}
