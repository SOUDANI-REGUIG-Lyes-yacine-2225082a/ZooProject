package Zoo;

import java.util.Scanner;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Animal.Ovipaire.*;
import Animal.Vivipaire.*;
import Animal.Vivipaire.TDLoup.*;
import Enclos.Enclos;
import Enclos.Enclosure;
import Enclos.Voliere;
import Maitre.Kaaris;

public class EssaieClassAnimauxMain {
	public static void main(String [ ] args) {

		System.out.println("======== Bienvenue sur l'application Zoo ! ========");

		

		// En-dessous se trouve un exemple pour montrer que les classes d'animaux, d'enclos et d'employé fonctionnent
		// Vous pouvez tout à fait la décommenter pour voir le résultat escompté

		/*
        Enclosure<Wolf> enclosure = new StandardEnclosure<Wolf>("Forêt des loups", 42, 2);
        Enclosure<Tiger> enclosure2 = new StandardEnclosure<Tiger>("Famille Tigrou", 56, 1);
        Enclosure<GoldFish> enclosure3 = new AquariumEnclosure<GoldFish>("Aquarium des petits poissons", 58,3, 5);
        Enclosure<Eagle> enclosure4 = new AviaryEnclosure<Eagle>("Volière volante", 60, 5, 35);
        Enclosure<GoldFish> enclosure5 = new AquariumEnclosure<GoldFish>("Petit aquarium", 20, 1, 3);
        Tiger tiger = new Tiger("Tigrou", 'm', 62, 189);
        GoldFish goldFish = new GoldFish("Nemo", 'm', 1, 2);
        GoldFish goldFish2 = new GoldFish("Marin", 'm', 1, 3);
        GoldFish goldFish3 = new GoldFish("Dory", 'f', 1,3);
        Eagle eagle = new Eagle("Royal", 'f', 5, 2);
        zoo.setEmployee(employee);
        zoo.addEnclosure(enclosure);
        zoo.addEnclosure(enclosure2);
        zoo.addEnclosure(enclosure3);
        zoo.addEnclosure(enclosure4);
        zoo.addEnclosure(enclosure5);
        enclosure2.addAnimal(tiger);
        enclosure2.addAnimal(tiger);
        enclosure3.addAnimal(goldFish);
        enclosure3.addAnimal(goldFish2);
        enclosure3.addAnimal(goldFish3);
        enclosure3.feedAnimals();
        enclosure4.addAnimal(eagle);
        employee.moveAnimalFromEnclosure(goldFish2, enclosure3, enclosure5);
        employee.moveAnimalFromEnclosure(goldFish, enclosure5, enclosure3);
        zoo.showAllAnimals();
        enclosure.feedAnimals();

		 */

		// Lancement de la simulation
		Scanner sc = new Scanner(System.in);
		String responseSimu = "a";
		while (responseSimu != "O" || responseSimu != "o" || responseSimu != "N" || responseSimu != "n") {
			System.out.println("Souhaitez-vous démarrer la simulation ? (O/N)");
			responseSimu = sc.nextLine();
			switch(responseSimu) {
			case "O":
			case "o":
				System.out.println("Très bien. La simulation va se lancer.");
				//launchSimulation();
				mainSimu();

				break;
			case "N":
			case "n":
				System.out.println("Tant pis pour vous, à bientôt!");
				System.exit(0);
			default:
				System.out.println("Caractère incorrect, veuillez réessayer.");
			}
		}
	} // main

	//je crée un autre laucnSIMULATION en gardant celui des loups plus bas dans le fichier au cas où:

	//simulateDay simule les activités du zoo en général
	private static void simulateDay(Zoo zoo) {


	}



	private static void simulateDragonDay1(Voliere<Dragon> dragonEnclos, Dragon dragon) {
		dragonEnclos.feedAnimals();
		dragon.eat();
		dragon.fly();

	}
	private static void simulateDragonDay2() {
		System.out.println("Les dragons dorment\n");
	}

	private static void mainSimu() {
		// Texte de présentation
		System.out.println("Vous avez décidé de lancer la simulation");
		System.out.println("Nous vous laissons les découvrir au fur et à mesure de la simulation.");
		System.out.println("Bonne simulation !\n");
		Kaaris kaaris = new Kaaris("Zoubida", 'f', 89);
		Zoo zoo = new Zoo("Zoo GrindLP", kaaris, 10);

		Dragon dragon1 = new Dragon("Drako", 'm', 150, 1,10);
		Voliere<Dragon> dragonEnclos = new Voliere("Enclos des dragons", 500, 10, 500);
		zoo.addEnclosure(dragonEnclos);
		dragonEnclos.addAnimal(dragon1);


		

		// Ceci nous servira à lire les entrées clavier
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i < 4) {
			Random rand = new Random();
			int randNbr = rand.nextInt(2);
			if(randNbr == 0) {
				simulateDragonDay2();
			}
			else {
				simulateDragonDay1(dragonEnclos, dragon1);
			}
			
			++i;
		}
	}
}
