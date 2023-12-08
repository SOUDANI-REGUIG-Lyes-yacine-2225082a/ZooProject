package Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Animal.Animal;
import Animal.AnimalMarin;
import Animal.AnimalTerrestre;
import Animal.AnimalVolant;
import Animal.Ovipaire.Dragon;
import Enclos.Aquarium;
import Enclos.Enclos;
import Enclos.Enclosure;
import Enclos.Voliere;
import Maitre.Kaaris;

public class GererAnimaux {

	private static List<Animal> animals;
	
	private static List<Thread> animalThreads;
	private static List<Thread> enclosThreads;
	private static Zoo zoo;
	private static Enclos<Animal> enclosParDefaut;
	private static Voliere<AnimalVolant> voliereParDefaut;
	private static Aquarium<AnimalMarin> aquariumParDefaut;
	private static List<Enclosure> enclosures; //[enclosParDefaut, voliereParDefaut, aquariumParDefaut]
	private static Kaaris Maitre;
	private static Thread enclosThread = new Thread();
	private static Thread animauxThread = new Thread();
	private static final Scanner scanner  = new Scanner(System.in);
	
	public GererAnimaux(Enclos enclosParDefaut, Voliere voliereParDefaut, Aquarium aquariumParDefaut, Zoo zoo, Kaaris maitre) {
	    GererAnimaux.enclosParDefaut = enclosParDefaut;
	    GererAnimaux.voliereParDefaut = voliereParDefaut;
	    GererAnimaux.aquariumParDefaut = aquariumParDefaut;
	    GererAnimaux.zoo = zoo;
	    GererAnimaux.animals = new ArrayList<>();
	    GererAnimaux.animalThreads = new ArrayList<>();
	    GererAnimaux.enclosures = new ArrayList<>();
	    GererAnimaux.enclosThreads = new ArrayList<>();
	    GererAnimaux.Maitre = maitre;
	}

	public static void MainMenu() {
		System.out.println("===== Zoo Fantastique Menu =====");
		System.out.println("1. Gérer les créatures");
		System.out.println("2. Gérer les enclos");
		System.out.println("3. Simuler le temps");
		System.out.print("Choisissez votre option : ");
	}

	public static void EnclosMenu() {
		System.out.println("===== Gérer les Enclos =====");
		System.out.println("1. Afficher les enclos");
		System.out.println("2. Ajouter un enclos");
		System.out.println("3. Nourrir les animaux de l'enclos");
		System.out.println("4. Retour au menu principal");
	}

	public static void AnimalMenu() {

		System.out.println("===== Gérer les Créatures =====");
		System.out.println("1. Afficher les créatures");
		System.out.println("2. Ajouter une créature");
		System.out.println("3. Soigner les animaux");
		System.out.println("4. Retour au menu principal");
	}

	public static void CreationAnimalsMenu() {
		System.out.println("1. Dragon");

        System.out.println("2. Retour au menu Gestion Creature");
	}
	
	public static void CreationEnclosuresMenu() {
		System.out.println("1. Voliere");
		System.out.println("2. Aquarium");
		System.out.println("3. Enclos terrestre");
        System.out.println("4. Retour au menu Gestion Enclos");
	}
	
	public static void NourrirAnimalsMenu() {
		System.out.println("===== Nourrir les Enclos =====");
		System.out.println("1. Enclos terrestre");
		System.out.println("2. Voliere");
		System.out.println("3. Aquarium");
		System.out.println("4. Retour au menu Gestion Creature");
	}
	
	public static void addEnclosure(Enclosure enclo) {
	    if (zoo != null) {
	        zoo.addEnclosure(enclo);
	        enclosures.add(enclo);
	    } else {
	        System.out.println("Erreur : l'objet zoo n'a pas été initialisé.");
	    }
	}

	public static void addAnimal(Animal animal) {
		if (animal.isVolant()) {
			voliereParDefaut.addAnimal(animal);
			animals.add(animal);
		}else if(animal.isMarin()) {
			aquariumParDefaut.addAnimal(animal);
			animals.add(animal);
		}else {
			enclosParDefaut.addAnimal(animal);
			animals.add(animal);
		}

		Thread animalThread = new Thread(animal);
		animalThreads.add(animalThread);
		animalThread.start();
	}

	public void removeAnimal(Animal animal) {
		if (animal.isVolant()) {
			voliereParDefaut.removeAnimal(animal);
			animals.remove(animal);
		}else if(animal.isMarin()) {
			aquariumParDefaut.removeAnimal(animal);
			animals.remove(animal);
		}else
			enclosParDefaut.removeAnimal(animal);
			animals.remove(animal);
		
		
	}
	
	// get isAlive 

	void runEnclosMenu() {

		int enclosureChoice;

		do {
			EnclosMenu();
			System.out.print("Votre zoo comporte de base un enclo terrestre une voliere et un aquarium \nChoisissez une option : ");
			enclosureChoice = scanner.nextInt();

			switch (enclosureChoice) {
			case 1:
				// Ajouter la logique pour afficher les enclos
				enclosParDefaut.getInfos();
				System.out.println("\n");
				voliereParDefaut.getInfos();
				System.out.println("\n");
				aquariumParDefaut.getInfos();
				System.out.println("\n");
				break;
			case 2:
				// Ajouter la logique pour ajouter un enclos
				System.out.println("Ajout d'un enclos...");
				AjouterEnclosureManuellement();
				break;
			case 3:
				// Ajouter la logique pour ajouter un enclos
				System.out.println("Nourrir les animaux d'un enclos...");
				nourrirAnimauxEnclos();
				break;
			case 4:
				System.out.println("Retour au menu principal.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir à nouveau.");
			}
		} while (enclosureChoice != 3);
	}

	void runAnimalMenu() {

		int animalChoice;

		do {
			
			AnimalMenu();
			System.out.print("Choisissez une option : ");
			animalChoice = scanner.nextInt();
			
			switch (animalChoice) {
			case 1:
				System.out.println("Affichage des animaux...");
				for(Animal animal : animals) {
					System.out.println(animal);
				}
				break;
			case 2:
				System.out.println("Ajout d'un animal...");
				AjouterAnimalManuellement();
				break;
			case 3:
				System.out.println("Soigner les animaux...");
				soignerAnimaux();
				break;
			case 4:
				System.out.println("Retour au menu principal.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir à nouveau.");
			}
		} while (animalChoice != 4);
	}

	static void AjouterEnclosureManuellement() {
		int numEnclosureChoice;

		do {
			System.out.println("Quelle enclos souhaitez-vous créer? ");
			CreationEnclosuresMenu();

			while (!scanner.hasNextInt()) {
				System.out.println("Veuillez entrer un nombre entier.");
				scanner.next(); // Consommer l'entrée incorrecte
			}

			numEnclosureChoice = scanner.nextInt();
			scanner.nextLine(); // Lire la ligne vide après la saisie du nombre

			switch (numEnclosureChoice) {
			case 1:
				String nameVoliere = "name";
				int areaVoliere = 250;
				int maxAnimauxVoliere = 10;
				int hauteur = 300;

				nameVoliere = nomEnclos();
				areaVoliere = areaEnclos();
				maxAnimauxVoliere = maxAnimalEnclos();
				hauteur = hauteurVoliere();


				Voliere<AnimalVolant> newVoliere = new Voliere<AnimalVolant>(nameVoliere, areaVoliere, maxAnimauxVoliere, hauteur);

				addEnclosure(newVoliere);

				
				enclosThreads.add(enclosThread);
				enclosThread.start();

				
				break;
			case 2:
				String nameAquarium = "name";
				int areaAquarium = 250;
				int maxAnimauxAquarium = 10;
				int profondeur = 300;

				nameAquarium = nomEnclos();
				areaAquarium = areaEnclos();
				maxAnimauxAquarium = maxAnimalEnclos();
				profondeur = profondeurAquarium();


				Voliere<AnimalVolant> newAquarium = new Voliere<AnimalVolant>(nameAquarium, areaAquarium, maxAnimauxAquarium, profondeur);

				addEnclosure(newAquarium);

				
				enclosThreads.add(enclosThread);
				enclosThread.start();

				
				break;
			case 3:
				String name = "name";
				int area = 250;
				int maxAnimaux = 10;

				name = nomEnclos();
				area = areaEnclos();
				maxAnimaux = maxAnimalEnclos();


				Enclos<Animal> newEnclos = new Enclos<Animal>(name, area, maxAnimaux);

				addEnclosure(newEnclos);

				animalThreads.add(enclosThread);
				enclosThread.start();

				
				break;
			case 4:
				System.out.println("Retour au menu principal.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir à nouveau.");
			}

			if (numEnclosureChoice == 4) {
				break;
			}
		} while (numEnclosureChoice != 4);
	}

	static void AjouterAnimalManuellement() {
		int animalChoice;

		do {
			System.out.println("Quelle animal souhaitez-vous créer? ");
			CreationAnimalsMenu();

			while (!scanner.hasNextInt()) {
				System.out.println("Veuillez entrer un nombre entier.");
				scanner.next(); // Consommer l'entrée incorrecte
			}

			animalChoice = scanner.nextInt();
			scanner.nextLine(); // Lire la ligne vide après la saisie du nombre

			switch (animalChoice) {
			case 1:
				String name = "name";
				int age = 1;
				char sexe;
				int height = 110;
				int weight = 80;

				name = nomAnimal();
				sexe = sexeAnimal();
				weight = weightAnimal();
				height = heightAnimal();
				age = ageAnimal();


				Dragon newDragon = new Dragon(name, sexe, weight, height, age);

				addAnimal(newDragon);

				
				animalThreads.add(animauxThread);
				animauxThread.start();

				
				break;
			case 2:
				System.out.println("Retour au menu principal.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir à nouveau.");
			}

			if (animalChoice == 2) {
				break;
			}
		} while (animalChoice != 2);
	}
	
	static void soignerAnimaux() {
		for (Animal animal : animals) {
			animal.heal();
		}
	}
	
	static void nourrirAnimauxEnclos() {
		int enclosureChoice;
		
		do {
			System.out.println("Quel enclos souhaitez vous nourrir ?");
			NourrirAnimalsMenu();

			while (!scanner.hasNextInt()) {
				System.out.println("Veuillez entrer un nombre entier.");
				scanner.next(); // Consommer l'entrée incorrecte
			}

			enclosureChoice = scanner.nextInt();
			scanner.nextLine(); // Lire la ligne vide après la saisie du nombre

			switch (enclosureChoice) {
			case 1:
				Maitre.feedAnimalsOfEnclosure(enclosParDefaut);
				break;
			case 2:
				Maitre.feedAnimalsOfEnclosure(voliereParDefaut);
				break;
			case 3:
				Maitre.feedAnimalsOfEnclosure(aquariumParDefaut);
				break;
			case 4:
				System.out.println("Retour au menu principal.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir à nouveau.");
			}

			if (enclosureChoice == 4) {
				break;
			}
		} while (enclosureChoice != 4);
	}
	
	
	public static String nomEnclos() {
		System.out.print("Nom de l'enclos : ");
		String name = scanner.nextLine().trim();
		while (name.isEmpty() || name.isBlank()) {
			System.out.println("Il faut donner un nom à l'enclos !");
			System.out.print("Nom de l'enclos : ");
			name = scanner.nextLine().trim();
		}
		System.out.println("Nom : " + name);
		return name;
	}
	
	public static int areaEnclos() {
		System.out.print("Entrez la zone de l'enclos en m²: ");
		String zone = scanner.nextLine().trim();
		if (!zone.isEmpty()) {
			while (!isNumeric(zone)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Entrez la zone de l'enclos en m²: ");
				zone = scanner.nextLine().trim();
			}
			System.out.println("Zone : " + zone);
			return Integer.parseInt(zone);
		}else { 
			while (zone.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				zone = scanner.nextLine().trim();
			} 
			System.out.println("Zone : " + zone);
			return Integer.parseInt(zone);
		}

	}
	
	public static int maxAnimalEnclos() {
		System.out.print("Entrez le nombre maximum d'animaux que peux contenir l'enclos : ");
		String max = scanner.nextLine().trim();
		if (!max.isEmpty()) {
			while (!isNumeric(max)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Entrez le nombre maximum d'animaux que peux contenir l'enclos : ");
				max = scanner.nextLine().trim();
			}
			System.out.println("Max : " + max);
			return Integer.parseInt(max);
		}else { 
			while (max.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				max = scanner.nextLine().trim();
			} 
			System.out.println("Max : " + max);
			return Integer.parseInt(max);
		}

	}
	
	public static int hauteurVoliere() {
		System.out.print("Entrez la hauteur de la voliere : ");
		String hauteur = scanner.nextLine().trim();
		if (!hauteur.isEmpty()) {
			while (!isNumeric(hauteur)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Entrez la hauteur de la voliere : ");
				hauteur = scanner.nextLine().trim();
			}
			System.out.println("Hauteur : " + hauteur);
			return Integer.parseInt(hauteur);
		}else { 
			while (hauteur.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				hauteur = scanner.nextLine().trim();
			} 
			System.out.println("Hauteur : " + hauteur);
			return Integer.parseInt(hauteur);
		}

	}
	
	public static int profondeurAquarium() {
		System.out.print("Entrez la pronfondeur de l'enclos : ");
		String profondeur = scanner.nextLine().trim();
		if (!profondeur.isEmpty()) {
			while (!isNumeric(profondeur)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Entrez la pronfondeur de l'enclos : ");
				profondeur = scanner.nextLine().trim();
			}
			System.out.println("Profondeur : " + profondeur);
			return Integer.parseInt(profondeur);
		}else { 
			while (profondeur.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				profondeur = scanner.nextLine().trim();
			} 
			System.out.println("Profondeur : " + profondeur);
			return Integer.parseInt(profondeur);
		}

	}
	
	
	
	public static String nomAnimal() {
		System.out.print("Nom de la créature : ");
		String name = scanner.nextLine().trim();
		while (name.isEmpty() || name.isBlank()) {
			System.out.println("Il faut donner un nom à la créature !");
			System.out.print("Nom de la créature : ");
			name = scanner.nextLine().trim();
		}
		System.out.println("Nom : " + name);
		return name;
	}

	public static char sexeAnimal() {
		System.out.println("Choisir le sexe de l'animal : \"m\" ou \"f\" ");
		String sexe = scanner.nextLine().trim();
		if (!sexe.isEmpty()) {
			while (!sexe.equals('m') || !sexe.equals("f")) {
				System.out.println("Caractere saisi incorrect");
				System.out.print("Male(m) ou Femelle(f) : ");
				sexe = scanner.nextLine().trim();
				if ("m".equals(sexe)) {
					System.out.println("Type choisi : Male");
					return 'm';
				} else if ("f".equals(sexe)) {
					System.out.println("Type choisi : Femelle");
					return 'f';
				}
			}
		}
		if ("m".equals(sexe)) {
			System.out.println("Type : Male");
			return 'm';
		} else if ("f".equals(sexe)) {
			System.out.println("Type : Femelle");
			return 'f';
		}else
			return 0;
	}
	

	public static int ageAnimal() {
		System.out.print("Entrez l'age de l'animal : ");
		String age = scanner.nextLine().trim();
		if (!age.isEmpty()) {
			while (!isNumeric(age)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Entrez l'age de l'animal : ");
				age = scanner.nextLine().trim();
			}
			System.out.println("Age : " + age);
			return Integer.parseInt(age);
		}else { 
			while (age.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				age = scanner.nextLine().trim();
			} 
			System.out.println("Age : " + age);
			return Integer.parseInt(age);
		}

	}

	public static int heightAnimal() {
		System.out.print("Entrez la taille de l'animal : ");
		String height = scanner.nextLine().trim();
		if (!height.isEmpty()) {
			while (!isNumeric(height)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Taille de la créature : ");
				height = scanner.nextLine().trim();
			}
			System.out.println("Taille : " + height);
			return Integer.parseInt(height);
		}else { 
			while (height.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				height = scanner.nextLine().trim();
			} 
			System.out.println("Taille : " + height);
			return Integer.parseInt(height);
		}
	}

	public static int weightAnimal() {
		System.out.print("Entrez le poids de l'animal : ");
		String weight = scanner.nextLine().trim();
		if (!weight.isEmpty()) {
			while (!isNumeric(weight)) {
				System.out.println("Veuillez entrer un nombre correcte.");
				System.out.print("Poids de l'animal : ");
				weight = scanner.nextLine().trim();
			}
			System.out.println("Poids : " + weight);
			return Integer.parseInt(weight);
		}else { 
			while (weight.isEmpty()) {
				System.out.println("Fais un effort entre au moins un charactere : ");
				weight = scanner.nextLine().trim();
			} 
			System.out.println("Poids : " + weight);
			return Integer.parseInt(weight);
		}
	}
	public static void stopScanner() {
		scanner.close();
	}
	
	private static boolean isNumeric(String str) {
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}
}
