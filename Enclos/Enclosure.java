package Enclos;

import Animal.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un enclos destiné à héberger des animaux.
 *
 * @param <T> Type d'animal autorisé dans l'enclos.
 */
public abstract class Enclosure<T> {
    private String name;
    private int area;
    private int maxAnimal; // Nombre maximum d'animaux
    private int nbAnimal; // Nombre d'animaux en temps réel
    private ArrayList<T> animals; // Animaux présents dans l'enclos
    private int cleanliness; // 3 = mauvais / 2 = correct / 1 = bon

    /**
     * Constructeur de la classe Enclosure.
     *
     * @param name      Nom de l'enclos.
     * @param area      Superficie de l'enclos.
     * @param maxAnimal Nombre maximum d'animaux que peut accueillir l'enclos.
     */
    public Enclosure(String name, int area, int maxAnimal) {
        this.name = name;
        this.area = area;
        this.maxAnimal = maxAnimal;
        this.nbAnimal = 0;
        this.animals = new ArrayList<>();
        this.cleanliness = 1;
    }

    /**
     * Affiche les informations détaillées sur l'enclos.
     */
    public void getInfos() {
        System.out.println("Enclos : " + this.name);
        System.out.println("Superficie " + this.area);
        System.out.println("Nombre max d'animaux : " + this.maxAnimal);
        System.out.println("Nombre actuel d'animaux : " + this.nbAnimal);
        System.out.println("Niveau de propreté : " + this.cleanliness + "/3");
        System.out.println("Créatures présentes : ");
        if (animals.isEmpty()) {
            System.out.println("Aucune créature dans l'enclos pour l'instant");
        } else {
            for (T animal : animals) {
                System.out.println(animal);
            }
        }
    }

    /**
     * Ajoute un animal à l'enclos.
     *
     * @param animal Animal à ajouter.
     * @return true si l'ajout a réussi, false sinon.
     */
    public boolean addAnimal(T animal) {
        if (this.nbAnimal + 1 <= this.maxAnimal) {
            if (!this.animals.contains(animal)) {
                this.animals.add(animal);
                ++this.nbAnimal;
                System.out.println(((Animal) animal).getName() + " a été ajouté à l'enclos " + this.name + " (" + this.nbAnimal + "/" + this.maxAnimal + ")");
            } else {
                System.out.println(((Animal) animal).getName() + " est déjà dans l'enclos " + this.name);
                return false;
            }
        } else {
            System.out.println("Nombre maximal d'animaux atteint pour l'enclos " + this.name + " !");
            return false;
        }
        return true;
    }

    /**
     * Retire un animal de l'enclos.
     *
     * @param animal Animal à retirer.
     * @return true si le retrait a réussi, false sinon.
     */
    public boolean removeAnimal(T animal) {
        if (this.animals.contains(animal)) {
            this.animals.remove(animal);
            --this.nbAnimal;
            System.out.println(((Animal) animal).getName() + " a été enlevé de l'enclos " + this.name);
        } else {
            System.out.println("L'animal n'est pas dans l'enclos " + this.name);
            return false;
        }
        return true;
    }

    /**
     * Nourrit tous les animaux de l'enclos.
     */
    public void feedAnimals() {
        for (T animal : animals) {
            ((Animal) animal).eat();
        }
        System.out.println("Tous les animaux de l'enclos " + this.name + " ont été nourris");
    }

    /**
     * Nettoie l'enclos.
     */
    public void clean() {
        this.cleanliness = 1;
        System.out.println("L'enclos " + this.name + " est maintenant propre");
    }

    /**
     * Affiche la liste des animaux présents dans l'enclos.
     *
     * @return Liste des animaux.
     */
    public List<T> showAnimals() {
        return animals;
    }

    /**
     * Obtient le nom de l'enclos.
     *
     * @return Nom de l'enclos.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtient le nombre d'animaux présents dans l'enclos.
     *
     * @return Nombre d'animaux.
     */
    public int getNbAnimal() {
        return nbAnimal;
    }

    /**
     * Obtient la liste des animaux présents dans l'enclos.
     *
     * @return Liste des animaux.
     */
    public ArrayList<T> getAnimals() {
        return animals;
    }
}
