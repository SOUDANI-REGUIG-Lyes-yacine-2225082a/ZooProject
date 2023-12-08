package Animal;

/**
 * Interface représentant la capacité de résurrection d'un animal.
 */
public interface Resurrection {

    /**
     * Méthode permettant à l'animal de ressusciter.
     *
     * @param animal L'animal à ressusciter.
     * @return Une chaîne de caractères indiquant le résultat de la résurrection.
     */
    String revive(Animal animal);
}
