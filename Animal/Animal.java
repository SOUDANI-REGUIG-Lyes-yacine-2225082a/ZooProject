/**
 * Classe abstraite représentant un animal générique.
 * Cette classe implémente l'interface Runnable pour la gestion des threads.
 * Chaque instance d'Animal possède des caractéristiques telles que le nom, le sexe, le poids,
 * la taille, l'âge, la faim, l'état de sommeil, la santé, et une indication sur sa vie.
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
     * @param name   Nom de l'animal.
     * @param sex    Sexe de l'animal (m : mâle, f : femelle).
     * @param weight Poids de l'animal.
     * @param size   Taille de l'animal en centimètres.
     * @param age    Âge initial de l'animal.
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

    // Méthodes avec thread

    /**
     * Gestion de la faim de l'animal. Le thread est utilisé pour réduire la faim périodiquement.
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
     * Méthode run de l'interface Runnable. Appelle la méthode hunger pour gérer la faim.
     */
    @Override
    public void run() {
        hunger();
    }

    /**
     * Méthode permettant de nourrir l'animal. La faim augmente de 50, sauf s'il dort ou est mort.
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
     * Méthode simulant le fait que l'animal émet un son.
     */
    public void sound() {
        System.out.println(this.name + " émet un son");
    }

    /**
     * Méthode de guérison de l'animal. Change l'état de santé de mauvaise à bonne.
     */
    public void heal() {
        if (!this.health) {
            this.health = true;
        }
    }

    /**
     * Méthode simulant le fait que l'animal femelle donne naissance (pond des œufs).
     */
    public void giveBirth() {
        if (this.sex == 'f') {
            System.out.println(this.name + " pond des œufs");
        }
    }

    /**
     * Méthode simulant le fait que l'animal s'endort.
     */
    public void sleep() {
        if (!this.sleep) {
            this.sleep = true;
            System.out.println(this.name + " s'endort et rejoint le monde des rêves");
        }
    }

    /**
     * Méthode simulant le fait que l'animal se réveille.
     */
    public void wakeUp() {
        if (this.sleep) {
            this.sleep = false;
            System.out.println(this.name + " se réveille !");
        }
    }

    // Getters et Setters

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
        if (sex == 'm' || sex == 'f') {
            this.sex = sex;
        } else {
            System.out.println("Le sexe doit être 'm' ou 'f' !");
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

    /**
     * Méthode simulant le vieillissement de l'animal. Si l'animal a atteint l'âge limite (10 ans),
     * il meurt, sinon son âge augmente et son état est mis à jour (jeune, adulte, vieux).
     */
    public void makeOld() {
        if (isAlive) {
            if (this.age >= 10 || this.age == 0) {
                System.out.println(this.getName() + " meurt"); // TODO: détruire l'objet this
            } else if (this.age <= 10 || this.age > 0) {
                ++this.age;
                String ageStr = "";
                if (age < 5) ageStr = "jeune";
                else if (age > 5) ageStr = "adulte";
                else if (age >= 8) ageStr = "vieux";
                System.out.println(this.getName() + " a grandi et est maintenant " + ageStr);
            }
            ++age; // TODO: implémenter l'incrémentation de l'âge avec le thread
        } else System.out.println(this.name + " est mort");
    }

    /**
     * Méthode toString pour obtenir une représentation textuelle de l'objet Animal.
     *
     * @return Une chaîne de caractères représentant les attributs de l'objet Animal.
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
