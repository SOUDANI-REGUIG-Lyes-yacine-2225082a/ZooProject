package Animal;

/**
 * Interface représentant un animal volant.
 */
public interface AnimalVolant {
	public boolean volant = true;

    /**
     * Méthode décrivant l'action de voler de l'animal.
     *
     * @return Une chaîne de caractères décrivant l'action de voler.
     */
    String fly();
}
