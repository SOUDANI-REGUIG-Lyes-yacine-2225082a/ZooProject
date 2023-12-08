package Animal.Vivipaire;

import Animal.Animal;
import Animal.AnimalTerrestre;
import Animal.Resurrection;

/**
 * La classe Nymphe représente une créature imaginaire vivipare, terrestre et capable de résurrection.
 * Elle hérite de la classe Vivipaire et implémente les interfaces AnimalTerrestre et Resurrection.
 */
public class Nymphe extends Vivipaire implements AnimalTerrestre, Resurrection {

    /**
     * Constructeur de la classe Nymphe.
     *
     * @param name   Le nom de la nymphe.
     * @param sex    Le sexe de la nymphe ('m' pour mâle, 'f' pour femelle).
     * @param weight Le poids de la nymphe.
     * @param size   La taille de la nymphe.
     * @param age    L'âge de la nymphe.
     */
    public Nymphe(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode walk() de l'interface AnimalTerrestre.
     *
     * @return Une chaîne de caractères indiquant que la nymphe se déplace gracieusement.
     */
    @Override
    public String walk() {
        return super.getName() + " se déplace gracieusement";
    }

    /**
     * Implémentation de la méthode revive() de l'interface Resurrection.
     *
     * @param creature L'animal à ressusciter.
     * @return Une chaîne de caractères indiquant si l'animal est en train de ressusciter ou s'il est vivant.
     */
    @Override
    public String revive(Animal creature) {
        if (!creature.isAlive()) {
            return creature.getName() + " est en train de ressusciter";
        } else {
            return creature.getName() + " est vivant";
        }
    }
}
