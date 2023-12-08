package Maitre;

import Animal.Animal;
import Enclos.Enclosure;

/**
 * Classe représentant un maître, utilisant le design pattern Singleton.
 */
public final class Kaaris {

    private String name;
    private char sex;
    private int age;

    /**
     * Constructeur de la classe Kaaris.
     *
     * @param name Nom du maître.
     * @param sex  Sexe du maître.
     * @param age  Âge du maître.
     */
    public Kaaris(String name, char sex, int age) {
        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
    }

    /**
     * Méthode permettant d'examiner les informations d'un enclos.
     *
     * @param enclosure L'enclos à examiner.
     */
    public void examineEnclosure(Enclosure enclosure) {
        enclosure.getInfos();
    }

    /**
     * Méthode permettant de nettoyer un enclos.
     *
     * @param enclosure L'enclos à nettoyer.
     */
    public void cleanEnclosure(Enclosure enclosure) {
        enclosure.clean();
        System.out.println(this.name + " a nettoyé l'enclos " + enclosure.getName());
    }

    /**
     * Méthode permettant de nourrir les animaux d'un enclos.
     *
     * @param enclosure L'enclos dont les animaux doivent être nourris.
     */
    public void feedAnimalsOfEnclosure(Enclosure enclosure) {
        enclosure.feedAnimals();
        System.out.println(this.name + " a nourri tous les animaux de l'enclos " + enclosure.getName());
    }

    /**
     * Méthode permettant de déplacer un animal d'un enclos à un autre.
     *
     * @param animal     L'animal à déplacer.
     * @param enclosure1 L'enclos source.
     * @param enclosure2 L'enclos de destination.
     */
    public void moveAnimalFromEnclosure(Animal animal, Enclosure enclosure1, Enclosure enclosure2) {
        if (enclosure1.removeAnimal(animal)) {
            if (enclosure2.addAnimal(animal)) {
                System.out.println(this.name + " a déplacé l'animal " + animal.getName() + " de l'enclos " + enclosure1.getName() + " à l'enclos " + enclosure2.getName());
            } else {
                enclosure1.addAnimal(animal);
            }
        }
        // TODO: voir une autre façon de gérer cela
    }

    /**
     * Méthode permettant de définir le nom du maître.
     *
     * @param name Le nom du maître.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Méthode permettant de définir le sexe du maître.
     *
     * @param sex Le sexe du maître.
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * Méthode permettant de définir l'âge du maître.
     *
     * @param age L'âge du maître.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
