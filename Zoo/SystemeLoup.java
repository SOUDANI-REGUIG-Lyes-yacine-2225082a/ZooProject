package Zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public final class SystemeLoup {
    private static ArrayList listRankDomination = new ArrayList<>(Arrays.asList('α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ', 'ι', 'κ', 'λ',
    		'μ', 'ν', 'ξ', 'ο', 'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω'));

    public static ArrayList getListRankDomination() {
        return listRankDomination;
    }

    public static boolean isInListRank(char c) {
        if(listRankDomination.contains(c)) {
            return true;
        }
        return false;
    }

    public static boolean isDominant(char c1, char c2) {
        if(isInListRank(c1) && isInListRank(c2)) {
            if(listRankDomination.indexOf(c1) > listRankDomination.indexOf(c2)) {
                return true;
            }
        }
        return false;
    }
    
    // Décrémenter le rang
    public static char decreaseRank(char c) {
    	if (isInListRank(c)) {
    		int rank = listRankDomination.indexOf(c);
    		++rank;
    		return (char) listRankDomination.get(rank);
    	}
    	return (Character) null;
    }
    
    // Mets la première lettre d'une String en majuscule
    public static String toTitle (String s) {
    	String s1 = s.substring(0,1).toUpperCase();
        String sTitle = s1 + s.substring(1);
    	return sTitle;
    }
    
    // Permet de faire une pause dans l'execution du code en demandant à l'utilisateur de confirmer par Entrée (ou autre touche)
    public static void takePause() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("");
    	System.out.print("Appuyez sur Entrée pour continuer.");
    	String responsePause = sc.nextLine();
    }
}
