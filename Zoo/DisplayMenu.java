package Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Animal.Animal;
import Animal.Ovipaire.Dragon;
import Enclos.Enclos;
import Enclos.Enclosure;

public class DisplayMenu {

	private static List<Animal> animals;
	private static List<Thread> animalThreads;
	private static Enclos enclosParDefaut;
	private static final Scanner scanner  = new Scanner(System.in);
	
	public DisplayMenu(Enclos enclosParDefaut) {
		DisplayMenu.enclosParDefaut = enclosParDefaut;
		DisplayMenu.animals = new ArrayList<>();
		DisplayMenu.animalThreads = new ArrayList<>();
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
		System.out.println("3. Retour au menu principal");
	}

	public static void AnimalMenu() {

		System.out.println("===== Gérer les Créatures =====s");
		System.out.println("1. Afficher les créatures");
		System.out.println("2. Ajouter une créature");
		System.out.println("4. Retour au menu principal");
	}

	public static void CreationAnimalsMenu() {
		System.out.println("1. Dragon");

        System.out.println("2. Retour au menu Gestion Creature");
	}

	public static void addAnimal(Animal animal) {
		animals.add(animal);

		Thread animalThread = new Thread(animal);
		animalThreads.add(animalThread);
		animalThread.start();
	}

	public void removeAnimal(Animal animal) {
		enclosParDefaut.removeAnimal(animal);
	}
	
	// get isAlive 

	void runEnclosMenu() {

		int enclosureChoice;

		do {
			EnclosMenu();
			System.out.print("Choisissez une option : ");
			enclosureChoice = scanner.nextInt();

			switch (enclosureChoice) {
			case 1:
				// Ajouter la logique pour afficher les enclos
				enclosParDefaut.getInfos();
				break;
			case 2:
				// Ajouter la logique pour ajouter un enclos
				System.out.println("Ajout d'un enclos...");
				break;
			case 3:
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
				System.out.println("Affichage des créatures...");
				for(Animal animal : animals) {
					System.out.println(animal);
				}
				break;
			case 2:
				System.out.println("Ajout d'une créature...");
				AjouterAnimalManuellement();
				break;
			case 3:
				System.out.println("Soigner une créature...");
				break;
			case 4:
				System.out.println("Retour au menu principal.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir à nouveau.");
			}
		} while (animalChoice != 4);
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
			while (!sexe.equals("m") || !sexe.equals("f")) {
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
				char sexe = 'f';
				int height = 110;
				int weight = 80;

				boolean type = false;

				name = nomAnimal();
				sexe = sexeAnimal();
				weight = weightAnimal();
				height = heightAnimal();
				age = ageAnimal();


				Dragon newDragon = new Dragon(name, sexe, weight, height, age);

				addAnimal(newDragon);

				Thread animalThread = new Thread(newDragon);
				animalThreads.add(animalThread);
				enclosParDefaut.addAnimal(newDragon);
				animalThread.start();

				System.out.println("Dragon ajouté avec succès !");
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
	
	

	public static void stopScanner() {
		scanner.close();
	}
	
	private static boolean isNumeric(String str) {
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}
}
