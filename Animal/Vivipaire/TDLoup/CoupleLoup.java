package Animal.Vivipaire.TDLoup;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * La classe CoupleLoup représente un couple de loups, composé d'un loup mâle et d'un loup femelle.
 * Elle gère la reproduction du couple et la création de nouveaux loups-nés.
 */
public class CoupleLoup {

    private Loup loupMale;
    private Loup loupFemale;

    /**
     * Constructeur de la classe CoupleLoup.
     *
     * @param loupMale   Le loup mâle du couple.
     * @param loupFemale Le loup femelle du couple.
     */
    public CoupleLoup(Loup loupMale, Loup loupFemale) {
        this.loupMale = loupMale;
        this.loupFemale = loupFemale;
        System.out.println(loupMale.getName() + " et " + loupFemale.getName() + " forment un nouveau couple de loups !");
    }

    /**
     * Définit le loup mâle du couple.
     *
     * @param loupMale Le loup mâle à définir.
     */
    public void setWolfMale(Loup loupMale) {
        if ('α' == loupMale.getRankDomination()) {
            if ('m' == loupMale.getSex()) {
                this.loupMale = loupMale;
            } else {
                System.out.println("Le loup mâle doit être un mâle");
            }
        } else {
            System.out.println("Le loup mâle doit être Alpha");
        }
    }

    /**
     * Définit le loup femelle du couple.
     *
     * @param loupFemale Le loup femelle à définir.
     */
    public void setWolfFemale(Loup loupFemale) {
        if ('α' == loupFemale.getRankDomination()) {
            if ('f' == loupFemale.getSex()) {
                this.loupFemale = loupFemale;
            } else {
                System.out.println("Le loup femelle doit être une femelle");
            }
        } else {
            System.out.println("Le loup femelle doit être Alpha");
        }
    }

    /**
     * Associe le couple à une meute.
     *
     * @param meute La meute à laquelle le couple appartient.
     */
    public void setWolfPack(Meute meute) {
        this.loupMale.setWolfPack(meute);
        this.loupFemale.setWolfPack(meute);
    }

    /**
     * Affiche les informations sur le couple de loups.
     */
    public void showCouple() {
        System.out.println("Loup mâle : " + loupMale + "\nLoup femelle : " + loupFemale);
    }

    /**
     * Génère une portée de loups-nés de manière aléatoire.
     *
     * @return Une liste d'objets Loup représentant les loups-nés.
     */
    public ArrayList<Loup> giveBirth() {
        // On estime qu'un loup doit avoir 2 en âge pour procréer
        if (this.loupMale.getAge() > 1 && this.loupFemale.getAge() > 1) {
            // Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
            int nbWolf = ThreadLocalRandom.current().nextInt(1, 7 + 1);
            System.out.println("Félicitations ! Vous avez " + nbWolf + " loups nouveaux-nés :");
            System.out.println("Comment souhaitez-vous les nommer ?");
            ArrayList<Loup> wolfsBorn = new ArrayList<Loup>();
            for (int i = 0; i < nbWolf; ++i) {
                int sex = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                char charSex = 'm';
                switch (sex) {
                    case 1:
                        charSex = 'm';
                        break;
                    case 2:
                        charSex = 'f';
                        break;
                }
                Scanner sc = new Scanner(System.in);
                System.out.println("Veuillez saisir un nom pour le loup " + (i + 1) + " : ");
                String str = sc.nextLine();
                Loup loup = new Loup(str, charSex, 2, 7, 5, 'β');
                wolfsBorn.add(loup);
                System.out.println("Bébé " + loup.getName() + " est arrivé ! Félicitations !");
            }
            return wolfsBorn;
        } else {
            System.out.println("Le couple n'est pas assez âgé pour procréer !");
            return null;
        }
    }

    /**
     * Retourne le loup mâle du couple.
     *
     * @return Le loup mâle.
     */
    public Loup getWolfMale() {
        return loupMale;
    }

    /**
     * Retourne le loup femelle du couple.
     *
     * @return Le loup femelle.
     */
    public Loup getWolfFemale() {
        return loupFemale;
    }

    /**
     * Vérifie si le couple de loups est vide (non initialisé).
     *
     * @return true si le couple est vide, sinon false.
     */
    public boolean isEmpty() {
        return this.loupMale == null && this.loupFemale == null;
    }
}
