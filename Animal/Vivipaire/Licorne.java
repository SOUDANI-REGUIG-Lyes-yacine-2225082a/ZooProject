package Animal.Vivipaire;

import Animal.AnimalTerrestre;

/**
 * La classe Licorne représente une créature imaginaire vivipare et terrestre.
 * Elle hérite de la classe Vivipaire et implémente l'interface AnimalTerrestre.
 */
public class Licorne extends Vivipaire implements AnimalTerrestre {

    /**
     * Constructeur de la classe Licorne.
     *
     * @param name   Le nom de la licorne.
     * @param sex    Le sexe de la licorne ('m' pour mâle, 'f' pour femelle).
     * @param weight Le poids de la licorne.
     * @param size   La taille de la licorne.
     * @param age    L'âge de la licorne.
     */
    public Licorne(String name, char sex, int weight, int size, int age) {
        // Appel du constructeur de la classe parente (Vivipaire) avec les paramètres fournis
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode walk() de l'interface AnimalTerrestre.
     *
     * @return Une chaîne de caractères indiquant que la licorne vagabonde.
     */
    @Override
    public String walk() {
        return super.getName() + " vagabonde !";
    }
}
