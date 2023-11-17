package Zoo.Animal.Viviparous.Wolf;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WolfCouple {

    private Wolf WolfMale;
    private Wolf WolfFemale;

    public WolfCouple(Wolf WolfMale, Wolf WolfFemale) {
    	this.WolfMale = WolfMale;
    	this.WolfFemale = WolfFemale;
    	System.out.println(WolfMale.getName() + " et " + WolfFemale.getName() + " forment un nouveau couple de loups !");
    }

    public void setWolfMale(Wolf WolfMale) {
        if('α' == WolfMale.getRankDomination()) {
        	if('m' == WolfMale.getSex()) {
        		this.WolfMale = WolfMale;
        	} else {
        	 System.out.println("Le loup mâle doit être un mâle");	
        	}            
        } else {
            System.out.println("Le loup mâle doit être Alpha");
        }

    }

    public void setWolfFemale(Wolf WolfFemale) {
        if('α' == WolfFemale.getRankDomination()) {
        	if('f' == WolfFemale.getSex()) {
        		this.WolfFemale = WolfFemale;
        	} else {
        	 System.out.println("Le loup femelle doit être un femelle");	
        	} 
        } else {
            System.out.println("Le loup femelle doit être Alpha");
        }
    }

    public void setWolfPack(WolfPack WolfPack) {
		this.WolfMale.setWolfPack(WolfPack);
		this.WolfFemale.setWolfPack(WolfPack);
	}

	public void showCouple() {
        System.out.println("Loup mâle : " + WolfMale + "\nLoup femelle : " + WolfFemale);
    }

    public ArrayList<Wolf> giveBirth() {
    	
    	// On estime qu'un loup doit avoir 2 en âge pour procréer
    	if (this.WolfMale.getAge() > 1 && this.WolfFemale.getAge() > 1) {
	        // Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
	        int nbWolf = ThreadLocalRandom.current().nextInt(1,7+1);
	        System.out.println("Félicitations ! Vous avez " + nbWolf + " loups nouveaux-nés :");
	        System.out.println("Comment souhaitez-vous les nommer ?");
	        ArrayList<Wolf> WolfsBorn = new ArrayList<Wolf>();
	        for(int i = 0; i < nbWolf; ++i) {
	        	int sex = ThreadLocalRandom.current().nextInt(1,2+1);
	        	char charSex = 'm';
	        	switch(sex) {
	        		case 1:
	        			charSex = 'm';
	        			break;
	        		case 2:
	        			charSex = 'f';
	        			break;
	        	}
	        	Scanner sc = new Scanner(System.in);
	        	System.out.println("Veuillez saisir un nom pour le loup " + (i+1) + " : ");
	        	String str = sc.nextLine();
	            Wolf Wolf = new Wolf(str, charSex, 2, 7, 'β');
	            WolfsBorn.add(Wolf);
	            System.out.println("Bébé " + Wolf.getName() + " est arrivé ! Félicitations !");
	        }
	        return WolfsBorn;
    	}
    	else {
    		System.out.println("Le couple n'est pas assez âgé pour procréer !");
    		return null;
    	}
    }

	public Wolf getWolfMale() {
		return WolfMale;
	}

	public Wolf getWolfFemale() {
		return WolfFemale;
	}
    
    public boolean isEmpty() {
    	if (this.WolfMale == null && this.WolfFemale == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
