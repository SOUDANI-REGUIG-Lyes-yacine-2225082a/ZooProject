package Animal;

/**
 * Classe abstraite représentant un animal et implémentant l'interface Runnable.
 * Les animaux ont des caractéristiques telles que le nom, le sexe, le poids, la taille, l'âge, la faim, le sommeil et la santé.
 * Ils peuvent effectuer diverses actions telles que manger, émettre un son, guérir, donner naissance, dormir et se réveiller.
 */
public abstract class Animal implements Runnable {
    private String name;
    private char sex; // m : male, f : female
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
    }

    /**
     * Méthode décrivant l'action de faim de l'animal. Utilisée comme thread pour simuler la faim.
     */
    public void hunger() {
        while (this.hunger > 0 && !Thread.interrupted()) {
            try {
                this.hunger = this.hunger - 1;
                Thread.sleep(2000);

                if (this.hunger <= 15) {
                    System.out.println(this.name + " a besoin de manger car sa faim est à " + this.hunger);

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
     * Méthode exécutée lorsqu'un thread Animal est démarré.
     */
    @Override
    public void run() {
        hunger();
        eat();
    }

    /**
     * Méthode décrivant l'action de manger de l'animal.
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
     * Méthode décrivant l'émission d'un son par l'animal.
     */
    public void sound() {
        System.out.println(this.name + " emet un son");
    }

    /**
     * Méthode de guérison de l'animal. Si l'animal n'est pas en bonne santé, la méthode le guérit.
     */
    public void heal() {
        if (!this.health) {
            this.health = true;
        }
    }

    /**
     * Méthode décrivant le processus de mise bas pour les animaux de sexe féminin.
     */
    public void giveBirth() {
        if (this.sex == 'f') {
            System.out.println(this.name + " pond des oeufs");
        }
    }

    /**
     * Méthode indiquant que l'animal s'endort et entre dans le monde des rêves.
     */
    public void sleep() {
        if (!this.sleep) {
            this.sleep = true;
            System.out.println(this.name + " s'endort et rejoint le monde des rêves");
        }
    }

    /**
     * Méthode indiquant que l'animal se réveille.
     */
    public void wakeUp() {
        if (this.sleep) {
            this.sleep = false;
            System.out.println(this.name + " se réveille !");
        }
    }

    /**
     * Méthode permettant d'obtenir le nom de l'animal.
     *
     * @return Le nom de l'animal.
     */
    public String getName() {
        return name;
    }

    /**
     * Méthode permettant d'obtenir le sexe de l'animal.
     *
     * @return Le sexe de l'animal ('m' pour mâle, 'f' pour femelle).
     */
    public char getSex() {
        return sex;
    }

    /**
     * Méthode permettant de définir le nom de l'animal.
     *
     * @param name Le nouveau nom de l'animal.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Méthode permettant de définir le sexe de l'animal. Le sexe doit être 'm' ou 'f'.
     *
     * @param sex Le nouveau sexe de l'animal.
     */
    private void setSex(char sex) {
        if (sex == 'm' || sex == 'f') {
            this.sex = sex;
        } else {
            System.out.println("Le sexe doit etre 'm' ou 'f' !");
        }
    }

    /**
     * Méthode permettant de vérifier si l'animal dort.
     *
     * @return Vrai si l'animal dort, faux sinon.
     */
    public boolean isSleep() {
        return sleep;
    }

    /**
     * Méthode permettant de vérifier si l'animal est en bonne santé.
     *
     * @return Vrai si l'animal est en bonne santé, faux sinon.
     */
    public boolean isHealth() {
        return health;
    }

    /**
     * Méthode permettant de définir l'état de santé de l'animal.
     *
     * @param health Le nouvel état de santé de l'animal.
     */
    public void setHealth(boolean health) {
        this.health = health;
    }

    /**
     * Méthode permettant de définir si l'animal est en vie ou non.
     *
     * @param alive Vrai si l'animal est en vie, faux sinon.
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Méthode permettant de vérifier si l'animal est en vie.
     *
     * @return Vrai si l'animal est en vie, faux sinon.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Méthode permettant d'obtenir l'âge de l'animal.
     *
     * @return L'âge de l'animal.
     */
    public int getAge() {
        return age;
    }

    /**
     * Méthode permettant de définir l'âge de l'animal.
     *
     * @param age Le nouvel âge de l'animal.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Méthode permettant d'obtenir le niveau de faim de l'animal.
     *
     * @return Le niveau de faim de l'animal.
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Méthode permettant de définir le niveau de faim de l'animal.
     *
     * @param hunger Le nouveau niveau de faim de l'animal.
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * Méthode permettant de faire vieillir l'animal.
     * Si l'animal est vivant, il vieillit, et s'il atteint l'âge maximal, il meurt.
     */
    public void makeOld() {
        if (isAlive) {
            if (this.age >= 10 || this.age == 0) {
                System.out.println(this.getName() + " meurt"); // TODO: détruire l'objet this
                // Peut-être gérer la destruction de l'objet ou l'ajout d'une notification de décès.
            } else if (this.age <= 10 || this.age > 0) {
                ++this.age;
                String ageStr = "";
                if (age < 5) ageStr = "jeune";
                else if (age > 5) ageStr = "adulte";
                else if (age >= 8) ageStr = "vieux";
                System.out.println(this.getName() + " a grandi et est maintenant " + ageStr);
            }
            ++age; // TODO: implementer l'incrementation de l'age avec le thread
        } else System.out.println(this.name + " est mort");
    }

    /**
     * Méthode permettant de vérifier si l'animal est un animal volant.
     *
     * @return Vrai si l'animal est volant, faux sinon.
     */
    public boolean isVolant() {
        return AnimalVolant.volant;
    }

    /**
     * Méthode permettant de vérifier si l'animal est un animal marin.
     *
     * @return Vrai si l'animal est marin, faux sinon.
     */
    public boolean isMarin() {
        return AnimalMarin.marin;
    }

    /**
     * Méthode permettant d'obtenir une représentation textuelle de l'objet Animal.
     *
     * @return Une chaîne de caractères représentant l'objet Animal.
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
                ", age=" + age +
                '}';
    }
}
