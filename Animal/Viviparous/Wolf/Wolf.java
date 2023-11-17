package Zoo.Animal.Viviparous.Wolf;
import Zoo.Utils;
import Zoo.Animal.Viviparous.Viviparous;
import Zoo.Animal.WalkingAnimal;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Viviparous implements WalkingAnimal{

    private int age; // 1 = jeune / 2 = adulte / 3 = vieux
    private int strength; // 1 = pas fort / 2 = moyen fort / 3 = très fort
    private int domination; // facteur de domination TODO: correspondant a  la difference entre les dominations exercees et celles subies)
    private char rankDomination; // TODO: lettre de l'alphabet grec qui represente le niveau de domination dans la meute du loup
    private int level; // TODO: correspondant au critere de qualite subjectif d'un loup, male comme femelle
    // calculé en fonction de la catégorie d'âge, de la force, du facteur de domination et du rang
    private int violence; // TODO: facteur de violence (impétuosité)
    // TODO: Trouver autre chose que donnée membre
    private WolfPack WolfPack;

    public Wolf(String name, char sex, int weight, int size, char rankDomination) {
        super(Utils.toTitle(name), sex, weight, size);
        
        // On détermine la force à 3 si le loup est un alphal
        if (rankDomination == 'α') {
        	this.strength = 3;
        }
        else {
        	this.strength = 1;
        }
        this.age = 1;
        this.level = 1;
        this.domination = 0;
        // Le facteur de violence est généré aléatoirement (compris entre 1 et 5)
        this.violence = ThreadLocalRandom.current().nextInt(1,5+1);
        if(Utils.isInListRank(rankDomination)) {
            this.rankDomination = rankDomination;
        }
    }

    public void sound(String howl)  { // howl = hurlement
        System.out.println(super.getName() + " hurle \"" + howl + "\"");
    }

    public void sound() {
    	if (this.WolfPack != null) {
    		this.sound(WolfPack.getHowl());
    	} else {
    		this.sound("Aoouuuuuh");
    	}
    }

    public void hear() {
        if(!super.isSleep() && super.isHealth()) {
            System.out.println(super.getName() + " entend des hurlements (peut-Ãªtre)");
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

    private void winDomination(Wolf Wolf) {
        // On réequilibre le facteur de domination
        this.incDomination();
        Wolf.decDomination();
        // On intervertit le rang de domination
        this.switchRankDomination(Wolf);
        // On réequilibre le level
        this.incLevel();
        Wolf.decLevel();
        System.out.println(super.getName() + " a dominé le loup " + Wolf.getName());
    }

    private void loseDomination(Wolf Wolf) {
        // On réequilibre le facteur de domination
        this.decDomination();
        Wolf.incDomination();
        // On intervertit le rang de domination
        Wolf.switchRankDomination(this);
        // On réequilibre le level
        this.decLevel();
        Wolf.incLevel();
        System.out.println(super.getName() + " se fait dominé par " + Wolf.getName());
    }

    // TODO : if alpha loup gagne alors pas de changement de couple sinon oui
    public void dominate(Wolf Wolf) {
        if(this.violence >= Wolf.getViolence() && Wolf.getRankDomination() != 'α') {
            if(this.level > Wolf.getLevel() || Wolf.getRankDomination() == 'ω') {
                this.winDomination(Wolf);
            }
            
            // TODO : Lorsque le facteur de domination est en dessous d’un certain seuil, le loup perd naturellement un
            // rang de domination s’il n’est pas le dernier de son sexe dans la meute à l’avoir (par exemple : le
            //		dernier mâle β d’une meute ne pourra pas devenir un mâle γ).
            
            // On considére que lorsqu'il y a égalité dans la domination, le verdict s'effectue aléatoirement
            else if(this.level == Wolf.getLevel()) {
                System.out.println(super.getName() + " et " + Wolf.getName() + " sont à  égalité, le combat est donc " +
                        "aléatoire !");
                // Retourne 0 ou 1
                long aleat = Math.round(Math.random());
                // 1 = this gagne, 0 = this perd
                if (0 < aleat) {
                    this.winDomination(Wolf);
                } else {
                    this.loseDomination(Wolf);
                }
            }
            else {
                this.loseDomination(Wolf);
            }
        } else {
            this.loseDomination(Wolf);
        }
    }

    private void incDomination() {
        ++this.domination;
    }

    private void decDomination() {
        if (this.domination != 0) {
            --this.domination;
        }
    }

    private void incLevel() {
        ++this.level;
    }

    private void decLevel() {
        if (this.level != 0) {
            --this.level;
        }
    }

    private void switchRankDomination(Wolf Wolf) {
        // on considére qu'un échange de rang s'effectue si l'agresseur a un rang inférieur à la cible
        if(Utils.isDominant(this.rankDomination, Wolf.getRankDomination())) {
            char rankDominationTemp = this.rankDomination;
            this.rankDomination = Wolf.getRankDomination();
            Wolf.setRankDomination(rankDominationTemp);
        }
    }
    
    public void showCarac() {
    	System.out.println("Regardes comment je suis bg : " + this.toString());
    }
    
    // Hurler pour exprimer son appartenance à une meute
    public void howlPack(boolean isAnswer) {
    	if (this.getWolfPack() != null) {
    		sound();
    		System.out.println("*Je suis le loup " + this.getName() + " et j'appartiens à la meute des plus forts!*");
    		this.showCarac();
    		if(!isAnswer) {
    		    callOtherWolfs(true);
            }
    	}
    	else {
    		System.out.println("Aouuuuh ! *Je suis le loup " + this.getName() + " et je suis solitaire*");
    		this.showCarac();
    	}
    }

    // Demande aux autres loups un hurlement réponse et non un hurlement d'appel
    public void callOtherWolfs(boolean isAnswer) {
        if(isAnswer) {
            if(this.WolfPack != null) {
                for(Wolf Wolf : WolfPack.getWolfs()) {
                    if(Wolf != this) {
                        Wolf.howlPack(isAnswer);
                    }
                }
            }
        }
    }
    
    // Hurler pour exprimer sa domination
    public void howlDomination(Wolf WolfMenaced) {
    	sound();
		System.out.println("*Je suis le loup " + this.getName() + " et je veux te dominer " + WolfMenaced.getName() + "*");
		this.showCarac();
    }   
    
    // Hurler pour répondre à la domination (soumission)
    public void howlSoumission(Wolf WolfAttacker) {
    	sound();
		System.out.println("*Je suis le loup " + this.getName() + " et je suis soumis à toi " + WolfAttacker.getName() + "*");
		this.showCarac();
    }
    
    // Hurler pour répondre à la domination (domination)
    public void howlAggresive(Wolf WolfAttacker) {
    	sound();
		System.out.println("*Je suis le loup " + this.getName() + " et je TE domine " + WolfAttacker.getName() + "*");
		this.showCarac();
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonde !");
    }

    public int getLevel() {
        return level;
    }

    public int getViolence() {
        return violence;
    }

    public char getRankDomination() {
        return rankDomination;
    }
    
    public WolfPack getWolfPack() {
    	return WolfPack;
    }
    
    public int getAge() {
		return age;
	}

	public void setWolfPack(WolfPack WolfPack) {
    	this.WolfPack = WolfPack;
    }

    public void setRankDomination(char rankDomination) {
        this.rankDomination = rankDomination;
    }

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
                ", meute=" + (this.WolfPack != null ? "oui":"non") +
                "}";
    }
}
