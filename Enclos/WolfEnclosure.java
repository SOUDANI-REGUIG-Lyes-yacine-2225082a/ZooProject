package Enclos;

import Animal.Vivipaire.TDLoup.Loup;
import Animal.Vivipaire.TDLoup.Meute;

/**
 * Classe représentant un enclos spécifique destiné à héberger des loups.
 *
 * @param <T> Type d'animal autorisé dans l'enclos (doit être un loup).
 */
public class WolfEnclosure<T extends Loup> extends Enclosure<T> {
    private Meute meute;

    /**
     * Constructeur de la classe WolfEnclosure.
     *
     * @param name      Nom de l'enclos.
     * @param area      Superficie de l'enclos.
     * @param maxAnimal Nombre maximum de loups que peut accueillir l'enclos.
     * @param meute     Meute de loups associée à l'enclos.
     */
    public WolfEnclosure(String name, int area, int maxAnimal, Meute meute) {
        super(name, area, maxAnimal);
        this.meute = meute;
    }

    /**
     * Affiche la meute de loups présente dans l'enclos.
     */
    public void showWolfs() {
        System.out.println("L'enclos " + this.getName() + " contient les loups :");
        this.meute.showWolfPack();
    }

    /**
     * Ajoute un loup à la meute de l'enclos.
     *
     * @param wolf Loup à ajouter à la meute.
     * @return Vrai si le loup a été ajouté avec succès, sinon faux.
     */
    @Override
    public boolean addAnimal(T wolf) {
        this.meute.addWolf(wolf);
        return true;
    }

    /**
     * Retire un loup de la meute de l'enclos.
     *
     * @param wolf Loup à retirer de la meute.
     * @return Vrai si le loup a été retiré avec succès, sinon faux.
     */
    @Override
    public boolean removeAnimal(T wolf) {
        this.meute.removeWolf(wolf);
        return true;
    }
}
