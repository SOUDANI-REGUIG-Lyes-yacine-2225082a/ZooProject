package Animal;

	
	// TODO : -add l'age fonct(viellissement, mort), -Revive des immortels(dragons, phoenixs, nymphes)
	// TODO : -add la période d'incubation ou gestation

    public abstract class Animal implements Runnable{
	private String name;
	private char sex; // m : male, f : female
	private int weight;
	private int size; // en centimetres
	private int age; // age de l'animal
	private int hunger; // faim sur 100
	private boolean sleep; // FALSE = ne dort pas / TRUE = dort
	private boolean health; // FALSE = mauvaise sante / TRUE = bonne sante

	private boolean isAlive;

	public Animal(String name, char sex, int weight, int size, int age) {
		this.name = name;
		setSex(sex);
		this.weight = weight;
		this.size = size;
		this.age = age;
		this.hunger = 100;
		this.sleep = false;
		this.health = true;
	}

	public void eat() {
		if (isAlive) {
			if (hunger < 100 && !sleep) {
				hunger = hunger + 100;
				System.out.println("Vous nourrissez " + name + " et sa faim et maintenant à " + hunger);
			} else {
				System.out.println("Vous ne pouvez pas nourrir " + name + " maintenant");
			}
		}
	}

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
	
	
	
	

	@Override
	public void run() {
		hunger();
	}

	public void sound() {
		System.out.println(this.name + " emet un son");
	}

	public void heal() {
		if(!this.health) {
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

