package Zoo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.platform.engine.TestDescriptor.Visitor;

import Animal.Animal;
import Animal.AnimalMarin;
import Animal.AnimalVolant;
import Animal.Ovipaire.*;
import Animal.Vivipaire.*;
import Animal.Vivipaire.TDLoup.*;
import Enclos.Aquarium;
import Enclos.Enclos;
import Enclos.Enclosure;
import Enclos.Voliere;
import Maitre.Kaaris;


public class Main {

    private static final Scanner scanner  = new Scanner(System.in);
	private static final List<Thread> creatureThreads = new ArrayList<>();
	static Enclos<Animal> ViceCity = new Enclos<Animal>("ViceCity", 400, 10);
	static Voliere<AnimalVolant> FlyCity = new Voliere<AnimalVolant>("FlyCity", 500, 4, 500);
	static Aquarium<AnimalMarin> SwimCity = new Aquarium<AnimalMarin>("SwimCity", 500, 8, 1000);
	
	
	static Kaaris Gourou = new Kaaris("Lyes",'m',10);
	static Zoo ZOO = new Zoo("ZOO",Gourou,10);
	static GererAnimaux managerAnimal = new GererAnimaux(ViceCity, FlyCity, SwimCity, ZOO, Gourou);
	public static void main(String[] args) {
        int mainChoice;
        do {
            GererAnimaux.MainMenu();
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                	managerAnimal.runAnimalMenu();
                    break;
                case 2:
                	managerAnimal.runEnclosMenu();
                    break;
                case 3:
                    // Ajouter la logique pour simuler le passage du temps
                    System.out.println("Simulation du passage du temps...");
                    startCreatureThreads(); // Démarrer les threads des créatures
                    break;
                case 4:
                    stopCreatureThreads(); // Arrêter les threads des créatures avant de quitter
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        } while (mainChoice != 4);
        managerAnimal.stopScanner();
    }

    private static void startCreatureThreads() {
        for (Animal animal : ViceCity.showAnimals()) {
            Thread creatureThread = new Thread(animal);
            creatureThreads.add(creatureThread);
            creatureThread.start();
        }
    }

    private static void stopCreatureThreads() {
        for (Thread thread : creatureThreads) {
            thread.interrupt();
        }
    }

    // ATTENTION: Main du dessous est un test celui du dessus marche et simule avec des menus
    
    //public static void main(String[] args){
        // Initialisation du maitre
//        Kaaris kaaris = new Kaaris("Kaaris", 'M', 45);
//        // Initialisation du zoo
//        Zoo zoo = new Zoo("Zoo de la mort", kaaris, 10);
//        
//        // Initialisation du scanner
//        Scanner scanner = new Scanner(System.in);
//        // Initialisation du random
//        Random random = new Random();
//        // Initialisation du tableau d'enclos
//        Enclosure<Animal> enclosures = new Enclosure<Animal>("Enclos 1", 10, 10);
//        // Initialisation du tableau d'animaux
//        Animal[] animals = new Animal[10];
//        
//
//
//        // generate Animals and add them to the zoo
//        for(int i = 0; i < 10; i++){
//            int randomInt = ThreadLocalRandom.current().nextInt(0, 10);
//            if(randomInt < 2){
//                animals[i] = new Dragon("Dragon" + i, 'm', 100, 100, 100);
//                animals[i].setAlive(false);
//                animals[i].setHealth(false);
//            }else if(randomInt < 4){
//                animals[i] = new Phoenix("Phoenix" + i, 'f', 100, 100, 100);
//            }else if(randomInt < 6){
//                animals[i] = new Nymphe("Nymph" + i, 'f', 100, 100, 100);
//            }else if(randomInt < 8){
//                animals[i] = new Loup("Loup" + i, 'm', 100, 100, 100, 'α');
//            }
//            zoo.addEnclosure(enclosures);
//        }
//    
//
//        // generate the usage of the method for each Enclosure
//        for(int i = 0; i < 10; i++){
//            int randomInt = ThreadLocalRandom.current().nextInt(0, 10);
//            if(randomInt < 2){
//                enclosures[i].clean();
//            }else if(randomInt < 4){
//                enclosures[i].feedAnimals();
//            }else if(randomInt < 6){
//                enclosures[i].addAnimal();
//            }else if(randomInt < 8){
//                enclosures[i].removeAnimal();
//            }else{
//                enclosures[i].getInfos();
//            }
//
//        
//        }

        


    //}
}
