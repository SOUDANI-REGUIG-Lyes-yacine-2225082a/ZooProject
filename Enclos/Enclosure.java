package Enclos;

import Animal.Animal;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD

public class Enclosure <T> {
	private String name;
	private int area;
	private int maxAnimal; // nombre maximums d'animaux
	private int nbAnimal; // nombre d'animaux en temps r�el
	private ArrayList<T> animals;
	private int cleanliness; // 3 = propre / 2 = etat moyen / 1 = sale

	/**
	 * Classe abstraite représentant un enclos destiné à héberger des animaux.
	 *
	 * @param <T> Type d'animal autorisé dans l'enclos.
	 */
=======
public abstract class Enclosure <T> {
    private String name;
    private int area;
    private int maxAnimal; // nombre maximums d'animaux
    private int nbAnimal; // nombre d'animaux en temps r�el
    private ArrayList<T> animals; // Animaux présent dans l'enclos
    private int cleanliness; // 3 = mauvais / 2 = correct / 1 = bon
>>>>>>> branch 'main' of https://github.com/SOUDANI-REGUIG-Lyes-yacine-2225082a/ZooProject.git

<<<<<<< HEAD

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
		this.cleanliness = 3;
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

	public ArrayList<T> getAnimals() {
		return animals;
	}

	public int getCleanliness(){
		return cleanliness;
	}

	/**
	 * Affiche les informations détaillées sur l'enclos.
	 * @return 
	 */
	public String getInfos() {
=======
    public Enclosure(String name, int area, int maxAnimal) {
        this.name = name;
        this.area = area;
        this.maxAnimal = maxAnimal;
        this.nbAnimal = 0;
        this.animals = new ArrayList<T>();
        this.cleanliness = 1;
    }

    public void getInfos() {
		System.out.println("Enclos : "+ this.name);
		System.out.println("Superficie " + this.area);
		System.out.println("Nombre max d'animaux : " + this.maxAnimal);
		System.out.println("Nombre actuels d'animaux : " + this.nbAnimal);
		System.out.println("Niveau de proprete : " + this.cleanliness + "/3");
		System.out.println("Créatures présentes : ");
>>>>>>> branch 'main' of https://github.com/SOUDANI-REGUIG-Lyes-yacine-2225082a/ZooProject.git
		if (animals.isEmpty()) {
			System.out.println("Aucune créature dans l'enclos pour l'instant");
		}else {
			for(T animal : animals) {
				System.out.println(animal);
			}
		}
	}

    public boolean addAnimal(T animal) {
        if(this.nbAnimal + 1 <= this.maxAnimal) {
            if(!this.animals.contains(animal)) {
                this.animals.add(animal);
                ++this.nbAnimal;
                System.out.println(((Animal) animal).getName() + " a �t� ajout� �l'enclos " + this.name + " ("+ this.nbAnimal +"/"+ this.maxAnimal +")");
            } else {
                System.out.println(((Animal) animal).getName() + " est d�j� dans l'enclos " + this.name);
                return false;
            }
        } else {
            System.out.println("Nombre maximal d'animaux atteint pour l'enclos " + this.name + " !");
            return false;
        }
        return true;
    }

    public boolean removeAnimal(T animal) {
        if(this.animals.contains(animal)) {
            this.animals.remove(animal);
            --this.nbAnimal;
           System.out.println(((Animal) animal).getName() + " a �t� enlev� � l'enclos " + this.name);
        } else {
            System.out.println("L'animal n'est pas dans l'enclos " + this.name);
            return false;
        }
        return true;
    }

    public void feedAnimals() {
        for(T animal : animals) {
            ((Animal) animal).eat();
        }
        System.out.println("Tous les animaux de l'enclos " + this.name + " ont ete nourris");
    }

    public void clean() {
        this.cleanliness = 1;
        System.out.println("L'enclos " + this.name + " est maintenant propre");
    }

    public List<T> showAnimals() {
		return animals;
	}

    public String getName() {
        return name;
    }

    public int getNbAnimal() {
        return nbAnimal;
    }

    public ArrayList<T> getAnimals() {
        return animals;
    }
}
