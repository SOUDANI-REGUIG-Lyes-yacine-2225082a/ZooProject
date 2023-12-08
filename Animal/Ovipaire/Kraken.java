package Animal.Ovipaire;

import Animal.AnimalMarin;

/**
 * La classe Kraken simule un kraken un animal ovipare
 * Animal marin simple
 * Elle hérite de la classe Ovipaire et implémente l'interface AnimalMarin.
 */
public class Kraken extends Ovipaire implements AnimalMarin {

    /**
     * Constructeur de la classe Kraken.
     *
     * @param name   Le nom du kraken.
     * @param sex    Le sexe du kraken.
     * @param weight Le poids du kraken.
     * @param size   La taille du kraken.
     * @param age    L'âge du kraken.
     */
    public Kraken(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode swim() de l'interface AnimalMarin.
     *
     * @return Une chaîne de caractères représentant l'action de nage du kraken.
     */
    @Override
    public String swim() {
        return super.getName() + " nage";
    }
}
