package Enclos;

import Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Enclosure <T> {
	private String name;
	private int area;
	private int maxAnimal; // nombre maximums d'animaux
	private int nbAnimal; // nombre d'animaux en temps r�el
	private ArrayList<T> animals;
	private int cleanliness; // 3 = propre / 2 = �tat moyen / 1 = sale

	public Enclosure(String name, int area, int maxAnimal) {
		this.name = name;
		this.area = area;
		this.maxAnimal = maxAnimal;
		this.nbAnimal = 0;
		this.animals = new ArrayList<T>();
		this.cleanliness = 1;
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
		this.cleanliness = 3;
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

	public int getCleanliness(){
		return cleanliness;
	}

	public String getInfos() {
		if (animals.isEmpty()) {
			System.out.println("Aucune créature dans l'enclos pour l'instant");
		}	
		return 	"Enclos=" + this.name + '\'' +
				", Superficie=" + this.area +
				", Nombre max d'animaux=" + this.maxAnimal +
				", Nombre actuels d'animaux=" + this.nbAnimal +
				", Niveau de proprete=" + this.cleanliness +  
				'}';
		
		

	}

	
	
	
}


