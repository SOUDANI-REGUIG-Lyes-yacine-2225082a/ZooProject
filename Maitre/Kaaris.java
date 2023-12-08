package Maitre;

import Animal.Animal;

import Enclos.Enclosure;

// Design Pattern : Singleton
public final class Kaaris {
    private String name;
    private char sex;
    private int age;
    

    public Kaaris(String name, char sex, int age){
        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
              
    }




    public void examineEnclosure(Enclosure enclosure) {
        enclosure.getInfos();
    }

    public void cleanEnclosure(Enclosure enclosure) {
        enclosure.clean();
        System.out.println(this.name + " a nettoy� l'enclos " + enclosure.getName());
    }

    public void feedAnimalsOfEnclosure(Enclosure enclosure) {
        enclosure.feedAnimals();
        System.out.println(this.name + " a nourri tous les animaux de l'enclos " + enclosure.getName());
    }

    public void moveAnimalFromEnclosure(Animal animal, Enclosure enclosure1, Enclosure enclosure2) {
        if(enclosure1.removeAnimal(animal)) {
            if(enclosure2.addAnimal(animal)) {
                System.out.println(this.name + " a d�plac� l'animal " + animal.getName() + " de l'enclos " + enclosure1.getName() + " a l'enclos " + enclosure2.getName());
            } else {
                enclosure1.addAnimal(animal);
            }
        }
        // TODO: voir autre fa�on de faire
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
