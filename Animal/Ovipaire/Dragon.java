package Animal.Ovipaire;

import Animal.AnimalVolant;
import Animal.Resurrection;
import Animal.Animal;
import Animal.AnimalMarin;

/**
 * La classe Dragon simulre un dragon qui est un ovipare.
 * Il vole et nage et possède la capacité de résurrection.
 * Elle hérite de la classe Ovipaire et implémente les interfaces AnimalVolant,
 * Resurrection et AnimalMarin.
 */
public class Dragon extends Ovipaire implements AnimalVolant, AnimalMarin, Resurrection {

    /**
     * Constructeur de la classe Dragon.
     *
     * @param name   Le nom du dragon.
     * @param sex    Le sexe du dragon.
     * @param weight Le poids du dragon.
     * @param size   La taille du dragon.
     * @param age    L'âge du dragon.
     */
    public Dragon(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode fly() de l'interface AnimalVolant.
     *
     * @return Une chaîne de caractères représentant l'action de vol du dragon.
     */
    @Override
    public String fly() {
        return super.getName() + " vole majestueusement !";
    }

    /**
     * Implémentation de la méthode swim() de l'interface AnimalMarin.
     *
     * @return Une chaîne de caractères représentant l'action de nage du dragon.
     */
    @Override
    public String swim() {
        return super.getName() + " nage parce que pourquoi pas";
    }

    /**
     * Implémentation de la méthode revive() de l'interface Resurrection.
     * Cette méthode permet de vérifier et d'indiquer si l'animal passé en
     * paramètre est en train de ressusciter ou s'il est vivant.
     *
     * @param creature L'animal à vérifier.
     * @return Une chaîne de caractères indiquant l'état de résurrection de l'animal.
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
