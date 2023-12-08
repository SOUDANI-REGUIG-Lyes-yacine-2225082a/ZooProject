java

package Animal;

/**
 * La classe abstraite Animal représente un être vivant dans le système du zoo.
 * Elle implémente l'interface Runnable pour permettre l'exécution asynchrone de certains comportements.
 * Cette classe forme la base pour la création d'objets spécifiques tels que les loups, licornes, nymphes, etc.
 * Les animaux ont des caractéristiques communes telles que le nom, le sexe, le poids, la taille, l'âge, la faim, etc.
 * Les actions possibles comprennent la gestion de la faim, l'alimentation, l'émission de sons, la guérison, la reproduction,
 * le sommeil, le réveil, le vieillissement, et d'autres.
 * Certains animaux peuvent être immortels, comme les dragons, les phénix, et les nymphes, et peuvent être ressuscités.
 * La classe inclut également un mécanisme de vieillissement avec un thread dédié.
 */
public abstract class Animal implements Runnable {
    private String name;
    private char sex; // 'm' pour mâle, 'f' pour femelle
    private int weight;
    private int size; // en centimètres
    private int age; // âge de l'animal
    private int hunger; // faim sur 100
    private boolean sleep; // FALSE = ne dort pas / TRUE = dort
    private boolean health; // FALSE = mauvaise santé / TRUE = bonne santé

    private boolean isAlive;

    /**
     * Constructeur de la classe Animal.
     *
     * @param name   Le nom de l'animal.
     * @param sex    Le sexe de l'animal ('m' pour mâle, 'f' pour femelle).
     * @param weight Le poids de l'animal.
     * @param size   La taille de l'animal en centimètres.
     * @param age    L'âge initial de l'animal.
     */
    public Animal(String name, char sex, int weight, int size, int age) {
        this.name = name;
        setSex(sex);
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.hunger = 100;
        this.sleep = false;
        this.health = true;
        this.isAlive = true;
    }
	
	/**
 	* Méthode pour gérer la faim de l'animal de manière asynchrone.
 	* Diminue progressivement le niveau de faim de l'animal et déclenche des alertes de faim.
 	* Marque l'animal comme mort s'il atteint un niveau de faim critique.
	 */
	public void hunger() {
		while (this.hunger > 0 && !Thread.interrupted()) {
			try {
				this.hunger = this.hunger - 1;
				Thread.sleep(2000);

				if (this.hunger <= 15) {
					System.out.println(this.name + " à besoin de manger car ça faim est à " + this.hunger);

					Thread.sleep(2000);
					if (this.hunger == 0) {
						System.out.println(this.name + " est mort de faim.");
						this.isAlive = false;
						break;
					}
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Rétablir le statut d'interruption
			}
		}
	}

	/**
	* Implémentation de l'interface Runnable pour gérer de manière asynchrone le niveau de faim de l'animal.
 	* La méthode {@code run()} appelle la méthode {@code hunger()} pour diminuer la faim de l'animal progressivement.
 	*/
	@Override
	public void run() {
    		hunger();
	}

	/**
 	* Méthode permettant à l'animal de se nourrir, augmentant son niveau de faim.
 	* Affiche un message indiquant que l'animal a été nourri et met à jour le niveau de faim.
 	* Ne permet pas de nourrir l'animal s'il est endormi ou si son niveau de faim est déjà au maximum.
	*/
	public void eat() {
    	if (isAlive) {
        	if (hunger < 100 && !sleep) {
            		hunger = hunger + 50;
            		System.out.println("Vous nourrissez " + name + " et sa faim est maintenant à " + hunger);
        	} else {
            		System.out.println("Vous ne pouvez pas nourrir " + name + " maintenant");
        	}
    	}
	}

	/**
 	* Méthode permettant à l'animal d'émettre un son.
 	* Affiche un message indiquant que l'animal émet un son.
 	*/
	public void sound() {
    		System.out.println(this.name + " émet un son");
	}

	/**
 	* Méthode permettant à l'animal de guérir. Si la santé de l'animal était mauvaise, elle est rétablie à bonne santé.
	*/
	public void heal() {
    		if (!this.health) {
        	    this.health = true;
    		}
	}

	public void giveBirth() {
		if(this.sex == 'f') {
			System.out.println(this.name + " pond des oeufs");
		}
	}

	public void sleep() {
		if(!this.sleep) {
			this.sleep = true;
			System.out.println(this.name + " s'endort et rejoins le monde des r�ves");
		}
	}

	public void wakeUp() {
		if(this.sleep) {
			this.sleep = false;
			System.out.println(this.name + " se r�veille !");
		}
	}

	public String getName() {
		return name;
	}

	public char getSex() {
		return sex;
	}

	void setName(String name) {
		this.name = name;
	}

	private void setSex(char sex) {
		if(sex == 'm' || sex == 'f') {
			this.sex = sex;
		} else {
			System.out.println("Le sexe doit etre 'm' ou 'f' !");
		}
	}

	public boolean isSleep() {
		return sleep;
	}

	public boolean isHealth() {
		return health;
	}

	public void setHealth(boolean health) {
		this.health = health;
	}

	public void setAlive(boolean alive) {
		isAlive = alive;
	}

	public boolean isAlive() {
		return isAlive;
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public void makeOld() {
		if(isAlive) {
			if(this.age >= 10 || this.age == 0) {
				//this.leavePack();
				System.out.println(this.getName() + " meurt"); // TODO: détruire l'objet this
			} else if (this.age <= 10 || this.age > 0){
				++this.age;
				String ageStr = "";
				if (age < 5) ageStr = "jeune";
				else if (age > 5) ageStr = "adulte";
				else if (age >= 8) ageStr = "vieux";
				System.out.println(this.getName() + " a grandit et est maintenant " + ageStr);
				}
			++age; // TODO: implementer l'incrementation de l'age avec le thread
			}else System.out.println(this.name + " est mort");
		}
	


	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", sex=" + sex +
				", weight=" + weight +
				", size=" + size +
				", hunger=" + hunger +
				", sleep=" + sleep +
				", health=" + health +
				", age=" + age +
				'}';
	}
}

