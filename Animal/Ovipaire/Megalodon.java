package Animal.Ovipaire;

import Animal.AnimalMarin;

/**
 * La classe Megalodon simule un megalodon, un animal ovipare
 * Animal marin simple.
 * Elle hérite de la classe Ovipaire et implémente l'interface AnimalMarin.
 */
public class Megalodon extends Ovipaire implements AnimalMarin {

    /**
     * Constructeur de la classe Megalodon.
     *
     * @param name   Le nom du megalodon.
     * @param sex    Le sexe du megalodon.
     * @param weight Le poids du megalodon.
     * @param size   La taille du megalodon.
     * @param age    L'âge du megalodon.
     */
    public Megalodon(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode swim() de l'interface AnimalMarin.
     *
     * @return Une chaîne de caractères représentant l'action de nage du megalodon.
     */
    @Override
    public String swim() {
        return super.getName() + " nage à la recherche de nourriture";
    }
}
