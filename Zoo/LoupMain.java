package Zoo;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Animal.Vivipaire.TDLoup.Colonie;
import Animal.Vivipaire.TDLoup.CoupleLoup;
import Animal.Vivipaire.TDLoup.Loup;
import Animal.Vivipaire.TDLoup.Meute;

public class LoupMain {
	public static void main(String[] args) {
		
	
	
	// Texte de présentation
	System.out.println("Vous avez décidé de lancer la simulation");
	System.out.println("Cinq types d'actions vont être lancées aléatoirement au fil du temps.");
	System.out.println("Nous vous laissons les découvrir au fur et à mesure de la simulation.");
	System.out.println("Bonne simulation !");

    // Compteur de randoms : définir l'évènement à produire
	int cptRandoms = 0;

	// Cela nous permet d'executer au moins une fois les actions au premier tour
	int randomOne = 1;
	int randomTwo = 1;
	int randomThree = 1;
	int randomFive = 1;

	// Ceci nous servira à lire les entrées clavier
	Scanner sc = new Scanner(System.in);

	// Création de la colonnie
	Colonie colonie = new Colonie();


	while (true) {
		// Définir les tâches à faire grâce au Random
		switch(cptRandoms) {

			// CREATION D'UNE NOUVELLE MEUTE
			case 0:

				// On fait une pause pour l'utilisateur
				SystemeLoup.takePause();

				// On décide si on crée une nouvelle meute (généré aléatoirement, 1 chance sur 2)
	            int randomPack = ThreadLocalRandom.current().nextInt(1,randomOne+1);
	            if (randomPack == 1) {

	            	System.out.println("");
	            	System.out.println("======== CREATION D'UNE NOUVELLE MEUTE DE LOUPS ========");
	            	System.out.println("Un nouveau couple de loups va être crée, nous avons besoin de vous!");

	            	// Création du male et de la femelle du couple
	            	System.out.println("Comment souhaitez-vous nommer le mâle du couple ?");
	            	String strMale = sc.nextLine();
	            	Loup male = new Loup(strMale, 'm', 36, 37,10, 'α');
					System.out.println("Comment souhaitez-vous nommer la femelle du couple ?");
	            	String strFemale = sc.nextLine();
	                Loup female = new Loup(strFemale, 'f', 36, 38,15,'α');

	                // Création du couple
	            	CoupleLoup coupleLoupApp = new CoupleLoup(male, female);

	                // Création de la meute
	            	System.out.println("Une nouvelle meute de loups va être créee, nous avons besoin de vous!");
	            	System.out.println("Quel cri de meute souhaitez-vous ? (exemple : \"Aoouuh\") ");
	            	String howl = sc.nextLine();
	            	Meute meuteApp = new Meute(colonie, coupleLoupApp, howl);
	            }
	            else {
	            	System.out.println("Il ne se passe rien...");
	            }

	            randomOne = 5; 
				cptRandoms += 1;

			// SAISON DES AMOURS, REPRODUCTION
			case 1:

				// On fait une pause pour l'utilisateur
				SystemeLoup.takePause();

				// On décide si c'est la saison des amours (généré aléatoirement, 1 chance sur 4)
	            int randomSeason = ThreadLocalRandom.current().nextInt(1,randomTwo+1);
	            if (randomSeason == 1) {

	            	System.out.println("");
	            	System.out.println("======== SAISON DES AMOURS ========");
	            	System.out.println("C'est la saison des amours, nous avons peut-être des loups nouveaux-nés !");

	            	// On vérifie si un/des couple(s) existent
	            	if (colonie.getWolfPacks().isEmpty()) {
	            		System.out.println("Aucun couple n'existe à l'instant t ! Aucune reproduction n'est possible !");
	            		break;
	            	} 
	            	else {
	                	// S'il des couples existent alors ils peuvent se reproduire
	            		int indexPack = 0;
	                	for (Meute Meute : colonie.getWolfPacks()) {

	                		if (Meute.getWolfCouple() != null) {
	                			System.out.println("Meute numéro " + (indexPack+1));
	                			++indexPack;
	                			Meute.giveBirth();
	                		}
	                		else {
	                			System.out.println("La meute n'as pas de couple !");
	                		}
	                	}
	            	}
	            }
	            else {
	            	System.out.println("Il ne se passe rien...");
	            }

	            randomTwo = 4;
				cptRandoms += 1;

			// EVOLUTION HIERARCHIE DES MEUTES
			case 2:

				// On fait une pause pour l'utilisateur
				SystemeLoup.takePause();

				// On décide si on doit faire évoluer naturellement la hierarchie (généré aléatoirement, 1 chance sur 4)
	            int randomHierarchy = ThreadLocalRandom.current().nextInt(1,randomThree+1);
	            int randomDomination;
	            int randomDecreaseRank;
	            if (randomHierarchy == 1) {

	            	System.out.println("");
	            	System.out.println("======== EVOLUTION NATURELLE DE LA HIERARCHIE ========");
	            	System.out.println("Les meutes évoluent et les hiérarchies vont peut-être changer !");

	            	// On vérifie si une/des meute(s) existent
	            	if (colonie.getWolfPacks().isEmpty()) {
	            		System.out.println("Aucune meute n'existe à l'instant t ! Les hierarchies ne peuvent évoluer !");
	            		break;
	            	} 
	            	else {
	                	// Si des meutes existent alors les hiérarchies peuvent évoluer
	                	for (Meute Meute : colonie.getWolfPacks()) {

	                		// Afficher la hiérarchie
	                		Meute.showHierarchy();

	                		// Si la meute comprend des loups
	                		if (!Meute.getWolfs().isEmpty()) {
	                			// On parcourt les loups de la meute
	                			for (Loup Loup : Meute.getWolfs()) {

	                    			randomDomination = ThreadLocalRandom.current().nextInt(1,5+1);

	                    			// On décide si on doit lancer une domination pour chaque loup (1 chance sur 5) 
	                    			if (randomDomination == 1) {

	                    				// On choisit le loup que l'on va essayer de dominer aléatoirement
	                    				Loup loupDominated = Loup;
	                    				int randomWolfDominated;

	                    				// On choisit un loup dans la meute (différent de celui qui lance la domination)
	                    				while (loupDominated == Loup) {
	                    					randomWolfDominated = ThreadLocalRandom.current().nextInt(1, Meute.getWolfs().size()+1);
	                    					loupDominated = Meute.getWolfs().get(randomWolfDominated-1);
	                    				}

	                    				Loup.dominate(loupDominated);
	                    			}

	                    			randomDecreaseRank = ThreadLocalRandom.current().nextInt(1,3+1);

	                    			// On décide si on baisse le rang de domination du loup (1 chance sur 3) 
	                    			if (randomDecreaseRank == 1) {
	                    				Meute.decreaseRank(Loup);
	                    			}
	                			}

	                			// Afficher la nouvelle hiérarchie
	                			Meute.showWolfs();
	                    		System.out.print("Nouvelle ");
	                			Meute.showHierarchy();
	                		}
	                		else {
	                			System.out.println("La meute n'a pas de loups !");
	                		}
	                	}
	            	}
	            }
	            else {
	            	System.out.println("Il ne se passe rien...");
	            }

	            randomThree = 4;
				cptRandoms += 1;

			// VIEILLISSEMENT DES LOUPS
			case 3:

				// On fait une pause pour l'utilisateur
				SystemeLoup.takePause();

				System.out.println("");
	        	System.out.println("======== VIEILLISSEMENT DES LOUPS ========");
	        	System.out.println("Le temps passe et les loups vieillissent !");

				// On vérifie si une/des meute(s) existent
	        	if (colonie.getWolfPacks().isEmpty()) {
	        		System.out.println("Aucune meute n'existe à l'instant t ! Aucun loup ne peut vieillir !");
	        		break;
	        	}
	        	else {
	        		int cptPack;
	        		int randomOld;

	            	// Si des meutes existent alors les loups peuvent vieillir
	            	for (Meute Meute : colonie.getWolfPacks()) {

	            		// Si la meute comprend des loups
	            		if (Meute.getWolfs() != null) {

	            			// On affiche les loups actuels de la meute
	                		System.out.println("Loups actuels de la meute :");
	                		Meute.showWolfs();

	            			// On parcourt les loups de la meute
	            			for (Loup Loup : Meute.getWolfs()) {

	                			// On fait vieillir tout les loups
	            				Loup.makeOld();
	            			}
	            			System.out.println("Les loups de la meute ont tous vieilli !");

	            			// On affiche les loups actuels de la meute
	                		System.out.println("Loups de la meute après vieillissement :");
	                		Meute.showWolfs();
	            		}
	            		else {
	            			System.out.println("La meute n'a pas de loups !");
	            		}
	            	}
	        	}

				cptRandoms += 1;

			// HURLEMENTS ENTRE LOUPS
			case 4:

				// On fait une pause pour l'utilisateur
				SystemeLoup.takePause();

				System.out.println("");
	        	System.out.println("======== HURLEMENT DES LOUPS ========");
	        	System.out.println("Certains loups peuvent hurler pour montrer leur appartenance à une meute !");

	        	// Variables utiles pour faire gueuler les loups (générées aléatoirement)
	            int randomHowlAll;
	            int randomHowlDomination;

	        	// On vérifie si une/des meute(s) existent
	        	if (colonie.getWolfPacks().isEmpty()) {
	        		System.out.println("Aucune meute n'existe à l'instant t ! Les loups ne peuvent pas hurler !");
	        		break;
	        	} 
	        	else {
	            	// Si des meutes existent alors les loups peuvent hurler
	            	for (Meute Meute : colonie.getWolfPacks()) {

	            		// Si la meute comprend des loups
	            		if (!Meute.getWolfs().isEmpty()) {
	            			// On parcourt les loups de la meute
	            			for (Loup Loup : Meute.getWolfs()) {

	            				randomHowlAll = ThreadLocalRandom.current().nextInt(1,randomFive+1);

	                			// On décide si le loup doit hurler pour montrer son appartenance à une meute (1 chance sur 5) 
	                			if (randomHowlAll == 1) {
	                				Loup.howlPack(false);
	                			}

	            				randomHowlDomination = ThreadLocalRandom.current().nextInt(1,randomFive+1);

	                			// On décide si le loup doit hurler pour essayer de dominer un autre loup (1 chance sur 5) 
	                			if (randomHowlDomination == 1) {

	                				// On choisit le loup que l'on va essayer de dominer aléatoirement
	                				Loup loupDominated = Loup;
	                				int randomWolfDominated;

	                				// On choisit un loup dans la meute (différent de celui qui lance la domination)
	                				while (loupDominated == Loup) {
	                					//System.out.println(WolfPack.getWolfs().size());
	                					randomWolfDominated = ThreadLocalRandom.current().nextInt(1, Meute.getWolfs().size()+1);
	                					loupDominated = Meute.getWolfs().get(randomWolfDominated-1);
	                				}

	                				Loup.howlDomination(loupDominated);
	                			}
	            			}
	            		}
	            		else {
	            			System.out.println("La meute n'a pas de loups !");
	            		}
	            	}
	        	}

	        	randomFive = 5;
				cptRandoms = 0;
		}
	}
	}
}

