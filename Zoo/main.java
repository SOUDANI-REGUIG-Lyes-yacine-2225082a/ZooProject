package Zoo;

import java.util.Scanner;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.platform.engine.TestDescriptor.Visitor;

import Animal.Animal;
import Animal.Ovipaire.*;
import Animal.Vivipaire.*;
import Animal.Vivipaire.TDLoup.*;
import Enclos.Enclos;
import Enclos.Enclosure;
import Enclos.Voliere;
import Maitre.Kaaris;


public class main {
    public static void main(String[] args){
        // Initialisation du maitre
        Kaaris kaaris = new Kaaris("Kaaris", 'M', 45);
        // Initialisation du zoo
        Zoo zoo = new Zoo("Zoo de la mort", kaaris, 10);
        
        // Initialisation du scanner
        Scanner scanner = new Scanner(System.in);
        // Initialisation du random
        Random random = new Random();
        // Initialisation du tableau d'enclos
        Enclosure<Animal> enclosures = new Enclosure<Animal>("Enclos 1", 10, 10);
        // Initialisation du tableau d'animaux
        Animal[] animals = new Animal[10];
        


        // generate Animals and add them to the zoo
        for(int i = 0; i < 10; i++){
            int randomInt = ThreadLocalRandom.current().nextInt(0, 10);
            if(randomInt < 2){
                animals[i] = new Dragon("Dragon" + i, 'm', 100, 100, 100);
                animals[i].setAlive(false);
                animals[i].setHealth(false);
            }else if(randomInt < 4){
                animals[i] = new Phoenix("Phoenix" + i, 'f', 100, 100, 100);
            }else if(randomInt < 6){
                animals[i] = new Nymphe("Nymph" + i, 'f', 100, 100, 100);
            }else if(randomInt < 8){
                animals[i] = new Loup("Loup" + i, 'm', 100, 100, 100, 'α');
            }
            zoo.addEnclosure(enclosures);
        }
    

        // generate the usage of the method for each Enclosure
        for(int i = 0; i < 10; i++){
            int randomInt = ThreadLocalRandom.current().nextInt(0, 10);
            if(randomInt < 2){
                enclosures[i].clean();
            }else if(randomInt < 4){
                enclosures[i].feedAnimals();
            }else if(randomInt < 6){
                enclosures[i].addAnimal();
            }else if(randomInt < 8){
                enclosures[i].removeAnimal();
            }else{
                enclosures[i].getInfos();
            }

        
        }

        


    }
}