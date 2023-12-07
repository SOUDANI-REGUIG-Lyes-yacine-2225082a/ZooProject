package Animal;

	
	// TODO : -add l'age fonct(viellissement, mort), -Revive des immortels(dragons, phoenixs, nymphes)
	// TODO : -add la période d'incubation ou gestation

public class Animal {
    private String name;
    private char sex; // m : male, f : female
    private int weight;
    private int size; // en centim�tres
    private int age;
    private boolean hunger; // FALSE = pas faim / TRUE = a faim
    private boolean sleep; // FALSE = ne dort pas / TRUE = dort
    private boolean health; // FALSE = mauvaise sant� / TRUE = bonne sante
    
    private boolean isAlive;

    public Animal(String name, char sex, int weight, int size, int age) {
        this.name = name;
        setSex(sex);
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.hunger = false;
        this.sleep = false;
        this.health = true;
    }

    public String eat() {
        if(this.hunger) {
            this.hunger = false;
            return(this.name + " est en train de manger");
        }
        return null;
    }

    public String sound() {
        return(this.name + " emet un son");
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(boolean health) {
    	this.health = health;
    }
    
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setAge(int age) {
    	this.age = age;
    }
    
    private void setSex(char sex) {
        if(sex == 'm' || sex == 'f') {
            this.sex = sex;
        } else {
            System.out.println("Le sexe doit �tre 'm' ou 'f' !");
        }
    }
    
    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }
    
    

    public boolean isHunger() {
    	return hunger;
    }
    public boolean isSleep() {
        return sleep;
    }

    public boolean isHealth() {
        return health;
    }
    
    
    public boolean isAlive() {
        return isAlive;
    }
    
    /*
    public void makeOld() {
        if(this.age == 3) {
            //this.leavePack();
            System.out.println(super.getName() + " meurt"); // TODO: détruire l'objet this
        } else {
            ++this.age;
            String ageStr = "";
            switch (this.age) {
                case 2:
                    ageStr = "adulte";
                    break;
                case 3:
                    ageStr = "vieux";
                    break;
            }
            System.out.println(super.getName() + " a grandit et est maintenant " + ageStr);
        }
    }
    */

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
                '}';
    }
}
