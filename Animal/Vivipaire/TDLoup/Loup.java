package Animal.Vivipaire.TDLoup;

import Animal.AnimalTerrestre;
import Animal.Vivipaire.Vivipaire;
import Zoo.SystemeLoup;
import Animal.Vivipaire.TDLoup.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * La classe Loup représente un loup, qui est à la fois un animal vivipare et terrestre.
 * Elle gère les caractéristiques spécifiques des loups, telles que l'âge, la force, la domination, etc.
 */
public class Loup extends Vivipaire implements AnimalTerrestre {

	private int age; // 1 = jeune / 2 = adulte / 3 = vieux
    private int strength; // 1 = pas fort / 2 = moyen fort / 3 = très fort

    private int domination; 
    private char rankDomination; 
    private int level;
    
    private int violence; 
    
    private Meute Meute;

   


    /**
     * Constructeur de la classe Loup.
     *
     * @param name             Le nom du loup.
     * @param sex              Le sexe du loup (caractère).
     * @param weight           Le poids du loup.
     * @param size             La taille du loup.
     * @param age              L'âge du loup (1 = jeune / 2 = adulte / 3 = vieux).
     * @param rankDomination   Le rang de domination du loup (lettre de l'alphabet grec).
     */
    public Loup(String name, char sex, int weight, int size, int age, char rankDomination) {
        super(name, sex, weight, size, age);
        this.rankDomination = rankDomination;

        // On détermine la force à 3 si le loup est un alpha
        if (rankDomination == 'α') {
            this.strength = 3;
        } else {
            this.strength = 1;
        }
        this.age = 1;
        this.level = 1;
        this.domination = 0;
        // Le facteur de violence est généré aléatoirement (compris entre 1 et 5)
        this.violence = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        if (SystemeLoup.isInListRank(rankDomination)) {
            this.rankDomination = rankDomination;
        }
    }

    /**
     * Produit le son d'un hurlement du loup.
     *
     * @param howl Le son spécifique d'un hurlement.
     */
    public void sound(String howl) {
        System.out.println(super.getName() + " hurle \"" + howl + "\"");
    }

    
    public void soundLoup() {
    	if (this.Meute != null) {
    		this.sound(Meute.getHowl());
    	} else {
    		this.sound("Aoouuuuuh");
    	}
    }

  
   

    /**
     * Réagit au son d'hurlements en entendant d'autres loups de la meute.
     */
    public void hear() {
        if (!super.isSleep() && super.isHealth()) {
            System.out.println(super.getName() + " entend des hurlements (peut-être)");
            // TODO: entend TOUS les loups de LA meute émettent un son
        }
    }

   /* public void leavePack() {
        if(this.pack != null) {
            pack.removeWolf(this);
            this.pack = null;
            System.out.println(super.getName() + " a quitté sa meute");
        }
    }*/

    
        

    public void loseDomination(Loup Loup) {
        // On réequilibre le facteur de domination
        this.decDomination();
        Loup.incDomination();
        // On intervertit le rang de domination
        Loup.switchRankDomination(this);
        // On réequilibre le level
        this.decLevel();
        Loup.incLevel();
        System.out.println(super.getName() + " se fait dominé par " + Loup.getName());
    }
   

    public void winDomination(Loup Loup) {
        // On réequilibre le facteur de domination
        this.incDomination();
        Loup.decDomination();
        // On intervertit le rang de domination
        this.switchRankDomination(Loup);
        // On réequilibre le level
        this.incLevel();
        Loup.decLevel();
        System.out.println(super.getName() + " a dominé le loup " + Loup.getName());
    }

  

    // TODO : if alpha loup gagne alors pas de changement de couple sinon oui
    public void dominate(Loup Loup) {
        if(this.violence >= Loup.getViolence() && Loup.getRankDomination() != 'α') {
            if(this.level > Loup.getLevel() || Loup.getRankDomination() == 'ω') {
                this.winDomination(Loup);
            }
            
            // TODO : Lorsque le facteur de domination est en dessous d’un certain seuil, le loup perd naturellement un
            // rang de domination s’il n’est pas le dernier de son sexe dans la meute à l’avoir (par exemple : le
            //		dernier mâle β d’une meute ne pourra pas devenir un mâle γ).
            
            // On considére que lorsqu'il y a égalité dans la domination, le verdict s'effectue aléatoirement
            else if(this.level == Loup.getLevel()) {
                System.out.println(super.getName() + " et " + Loup.getName() + " sont à  égalité, le combat est donc " +
                        "aléatoire !");
 

                // Retourne 0 ou 1
                long aleat = Math.round(Math.random());
                // 1 = this gagne, 0 = this perd
                if (1 < aleat) {
                    this.winDomination(Loup);
                } else {
                    this.loseDomination(Loup);
                }
            } else {
                this.loseDomination(Loup);
            }
        } else {
            this.loseDomination(Loup);
        }
    }

    /**
     * Augmente le facteur de domination du loup.
     */
    public void incDomination() {
        ++this.domination;
    }


    

    /**
     * Diminue le facteur de domination du loup.
     */
    public void decDomination() {

        if (this.domination != 0) {
            --this.domination;
        }
    }


  

    /**
     * Augmente le niveau du loup.
     */
    public void incLevel() {

        ++this.level;
    }

    public void decLevel() {

        if (this.level != 0) {
            --this.level;
        }
    }



    /**
     * Échange le rang de domination entre deux loups.
     *
     * @param loup Le loup avec lequel le rang de domination est échangé.
     */
    public void switchRankDomination(Loup loup) {
        // On considère qu'un échange de rang s'effectue si l'agresseur a un rang inférieur à la cible
        if (SystemeLoup.isDominant(this.rankDomination, loup.getRankDomination())) {
            char rankDominationTemp = this.rankDomination;
            this.rankDomination = loup.getRankDomination();
            loup.setRankDomination(rankDominationTemp);
        }
    }

    /**
     * Affiche les caractéristiques du loup.
     */
    public void showCarac() {
        System.out.println("Regardez comment je suis bg : " + this.toString());
    }

    /**
     * Hurler pour exprimer son appartenance à une meute.
     *
     * @param isAnswer Indique s'il s'agit d'une réponse à un hurlement.
     */
    public void howlPack(boolean isAnswer) {
        if (this.getWolfPack() != null) {
            sound();
            System.out.println("*Je suis le loup " + this.getName() + " et j'appartiens à la meute des plus forts!*");
            this.showCarac();
            if (!isAnswer) {
                callOtherWolfs(true);
            }
        } else {
            System.out.println("Aouuuuh ! *Je suis le loup " + this.getName() + " et je suis solitaire*");
            this.showCarac();
        }
    }

    /**
     * Demande aux autres loups un hurlement réponse et non un hurlement d'appel.
     *
     * @param isAnswer Indique s'il s'agit d'une réponse à un hurlement.
     */
    public void callOtherWolfs(boolean isAnswer) {
        if (isAnswer) {
            if (this.Meute != null) {
                for (Loup loup : this.Meute.getWolfs()) {
                    if (loup != this) {
                        loup.howlPack(isAnswer);
                    }
                }
            }
        }
    }

    /**
     * Hurler pour exprimer sa domination.
     *
     * @param loupMenaced Le loup sur lequel la domination est exprimée.
     */
    public void howlDomination(Loup loupMenaced) {
        sound();
        System.out.println("*Je suis le loup " + this.getName() + " et je veux te dominer " + loupMenaced.getName() + "*");
        this.showCarac();
    }

    /**
     * Hurler pour répondre à la domination (soumission).
     *
     * @param loupAttacker Le loup qui exprime la domination.
     */
    public void howlSoumission(Loup loupAttacker) {
        sound();
        System.out.println("*Je suis le loup " + this.getName() + " et je suis soumis à toi " + loupAttacker.getName() + "*");
        this.showCarac();
    }

    /**
     * Hurler pour répondre à la domination (domination).
     *
     * @param loupAttacker Le loup qui exprime la domination.
     */
    public void howlAggresive(Loup loupAttacker) {
        sound();
        System.out.println("*Je suis le loup " + this.getName() + " et je TE domine " + loupAttacker.getName() + "*");
        this.showCarac();
    }

    /**
     * Retourne une chaîne de caractères représentant le déplacement du loup.
     *
     * @return Une chaîne de caractères représentant le déplacement du loup.
     */
    @Override
    public String walk() {
        return (super.getName() + " vagabonde !");
    }

        /**
     * Retourne le niveau du loup.
     *
     * @return Le niveau du loup.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Retourne le niveau de violence du loup.
     *
     * @return Le niveau de violence du loup.
     */
    public int getViolence() {
        return violence;
    }

    /**
     * Retourne le rang de domination du loup.
     *
     * @return Le rang de domination du loup.
     */
    public char getRankDomination() {
        return rankDomination;
    }

    /**
     * Retourne la meute à laquelle le loup appartient.
     *
     * @return La meute du loup, ou null si le loup est solitaire.
     */
    public Meute getWolfPack() {
    	return Meute;
    }

    /**
     * Retourne l'âge du loup.
     *
     * @return L'âge du loup.
     */
    public int getAge() {
		return age;
	}

    public void setLevel(int level) {
    	this.level = level;
    }
    

	public void setWolfPack(Meute Meute) {
    	this.Meute = Meute;
    }

    /**
     * Définit le rang de domination du loup.
     *
     * @param rankDomination Le rang de domination à définir.
     */
    public void setRankDomination(char rankDomination) {
        this.rankDomination = rankDomination;
    }

    /**
     * Redéfinition de la méthode toString pour afficher les caractéristiques du loup.
     *
     * @return Une chaîne de caractères représentant les caractéristiques du loup.
     */
    @Override
    public String toString() {
        return "Wolf {" +
        		"Nom=" + this.getName() + 
        		", age=" + age +
                ", force=" + strength +
                ", domination=" + domination +
                ", rangDomination=" + rankDomination +
                ", niveau=" + level +
                ", violence=" + violence +
                ", meute=" + (this.Meute != null ? "oui":"non") +
                "}";
    }
}
