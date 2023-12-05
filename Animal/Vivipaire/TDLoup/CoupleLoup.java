package Animal.Vivipaire.TDLoup;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CoupleLoup {

    private Loup loupMale;
    private Loup loupFemale;

    public CoupleLoup(Loup loupMale, Loup loupFemale) {
    	this.loupMale = loupMale;
    	this.loupFemale = loupFemale;
    	System.out.println(loupMale.getName() + " et " + loupFemale.getName() + " forment un nouveau couple de loups !");
    }

    public void setWolfMale(Loup loupMale) {
        if('α' == loupMale.getRankDomination()) {
        	if('m' == loupMale.getSex()) {
        		this.loupMale = loupMale;
        	} else {
        	 System.out.println("Le loup mâle doit être un mâle");	
        	}            
        } else {
            System.out.println("Le loup mâle doit être Alpha");
        }

    }

    public void setWolfFemale(Loup loupFemale) {
        if('α' == loupFemale.getRankDomination()) {
        	if('f' == loupFemale.getSex()) {
        		this.loupFemale = loupFemale;
        	} else {
        	 System.out.println("Le loup femelle doit être un femelle");	
        	} 
        } else {
            System.out.println("Le loup femelle doit être Alpha");
        }
    }

    public void setWolfPack(Meute Meute) {
		this.loupMale.setWolfPack(Meute);
		this.loupFemale.setWolfPack(Meute);
	}

	public void showCouple() {
        System.out.println("Loup mâle : " + loupMale + "\nLoup femelle : " + loupFemale);
    }

    public ArrayList<Loup> giveBirth() {
    	
    	// On estime qu'un loup doit avoir 2 en âge pour procréer
    	if (this.loupMale.getAge() > 1 && this.loupFemale.getAge() > 1) {
	        // Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
	        int nbWolf = ThreadLocalRandom.current().nextInt(1,7+1);
	        System.out.println("Félicitations ! Vous avez " + nbWolf + " loups nouveaux-nés :");
	        System.out.println("Comment souhaitez-vous les nommer ?");
	        ArrayList<Loup> wolfsBorn = new ArrayList<Loup>();
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
	            Loup Loup = new Loup(str, charSex, 2, 7, 'β');
	            wolfsBorn.add(Loup);
	            System.out.println("Bébé " + Loup.getName() + " est arrivé ! Félicitations !");
	        }
	        return wolfsBorn;
    	}
    	else {
    		System.out.println("Le couple n'est pas assez âgé pour procréer !");
    		return null;
    	}
    }

	public Loup getWolfMale() {
		return loupMale;
	}

	public Loup getWolfFemale() {
		return loupFemale;
	}
    
    public boolean isEmpty() {
    	if (this.loupMale == null && this.loupFemale == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
