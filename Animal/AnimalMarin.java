package Animal;

/**
 * Interface représentant un animal marin, capable de nager.
 */
public interface AnimalMarin {
	public boolean marin = true;

    /**
     * Méthode décrivant l'action de nager de l'animal marin.
     *
     * @return Une chaîne de caractères décrivant l'action de nager.
     */
    String swim();
}
