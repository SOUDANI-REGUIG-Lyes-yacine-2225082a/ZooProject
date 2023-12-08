package Animal.Ovipaire;

import Animal.Animal;
import Animal.AnimalVolant;
import Animal.Resurrection;

/**
 * La classe Phoenix représente un phénix qui est un animal ovipare.
 * Il vole et possède la capacité de résurrection.
 * Elle hérite donc de la classe Ovipaire et implémente les interfaces AnimalVolant et Resurrection.
 */
public class Phoenix extends Ovipaire implements AnimalVolant, Resurrection {

    /**
     * Constructeur de la classe Phoenix.
     *
     * @param name   Le nom du phénix.
     * @param sex    Le sexe du phénix (caractère).
     * @param weight Le poids du phénix.
     * @param size   La taille du phénix.
     * @param age    L'âge du phénix.
     */
    public Phoenix(String name, char sex, int weight, int size, int age) {
        super(name, sex, weight, size, age);
    }

    /**
     * Implémentation de la méthode fly() de l'interface AnimalVolant.
     *
     * @return Une chaîne de caractères simulant l'envol du phénix.
     */
    @Override
    public String fly() {
        return super.getName() + " vole de manière royale !";
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
