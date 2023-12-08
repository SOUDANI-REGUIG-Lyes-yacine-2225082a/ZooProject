package Animal.Vivipaire.TDLoup;

import java.util.ArrayList;
import Zoo.SystemeLoup;

/**
 * La classe Meute représente un groupe de loups qui vivent ensemble dans une hiérarchie sociale.
 */
public class Meute {

	private Colonie Colonie;
	private CoupleLoup CoupleLoup;
	private ArrayList<Loup> loups;
	private String howl;
	
	public Meute() {
		super();
	}
	
	public Meute(Colonie Colonie, CoupleLoup CoupleLoup, String howl) {
		super();
		this.Colonie = Colonie;
		this.Colonie.addWoldPack(this);
		this.CoupleLoup = CoupleLoup;
		CoupleLoup.setWolfPack(this);
		this.loups = new ArrayList<Loup>();
		this.howl = howl;
		System.out.println("Une nouvelle meute a ett crée ! (Couple de la meute : " + this.CoupleLoup.getWolfMale().getName() +
						   " & " + this.CoupleLoup.getWolfFemale().getName() + ", cri : \"" + this.howl + "\")");
	}


    /**
     * Constructeur de la classe Meute.
     *
     * @param Colonie    La colonie à laquelle la meute est affiliée.
     * @param CoupleLoup Le couple alpha de la meute.
     * @param howl       Le cri distinctif de la meute.
     */
   

    /**
     * Affiche les loups de la meute, y compris le couple alpha et les autres membres.
     */
    public void showWolfPack() {
        if (!CoupleLoup.isEmpty()) {
            System.out.println("La meute de loups est constituée du couple :");
            this.CoupleLoup.showCouple();
        }
        if (!loups.isEmpty()) {
            System.out.println("et des loups : ");
            for (Loup Loup : loups) {
                System.out.println(Loup.getName() + " : " + Loup);
            }
        } else {
            System.out.println();
        }
    }

    /**
     * Affiche les caractéristiques des loups de la meute, y compris le couple alpha et les autres membres.
     */
    public void showWolfs() {
        System.out.println("Caractéristiques des loups de la meute :");
        System.out.println(this.CoupleLoup.getWolfMale().toString());
        System.out.println(this.CoupleLoup.getWolfFemale().toString());
        for (Loup Loup : loups) {
            System.out.println(Loup.toString());
        }
    }

    /**
     * Affiche la hiérarchie des loups de la meute basée sur leurs rangs de domination.
     */
    public void showHierarchy() {
        System.out.println("Hiérarchie de la meute :");
        ArrayList<Character> newHierarchy = new ArrayList<>();

        // On parcourt tous les rangs de domination
        for (Object c : SystemeLoup.getListRankDomination()) {
            for (Loup Loup : this.getWolfs()) {
                if ((char) c == Loup.getRankDomination()) {
                    newHierarchy.add((char) c);
                    break;
                }
            }
        }
        System.out.println(newHierarchy);
    }

    /**
     * Constitue un nouveau couple alpha dans la meute.
     *
     * @param maleAlphaLoup Le loup mâle alpha de la meute.
     */
    public void constituteCouple(Loup maleAlphaLoup) {
        this.CoupleLoup.setWolfMale(maleAlphaLoup);
        maleAlphaLoup.setWolfPack(this);
    }

    /**
     * Ajoute un loup à la meute.
     *
     * @param Loup Le loup à ajouter à la meute.
     * @return Un message indiquant si le loup a été ajouté avec succès ou s'il était déjà dans la meute.
     */
    public String addWolf(Loup Loup) {
        // On n'ajoute pas un loup déjà présent dans le couple
        if (!this.getWolfs().contains(Loup)) {
            loups.add(Loup);
            Loup.setWolfPack(this);
            return (Loup.getName() + " a été ajouté à la meute");
        } else
            return (Loup.getName() + " est déjà dans la meute");
    }

    /**
     * Retire un loup de la meute.
     *
     * @param Loup Le loup à retirer de la meute.
     */
    public void removeWolf(Loup Loup) {
        if (loups.contains(Loup)) {
            loups.remove(Loup);
            Loup.setWolfPack(null);
            System.out.println(Loup.getName() + " a été retiré de la meute");
        }
    }

    /**
     * Définit le rang de domination d'un loup comme étant l'omega de la meute.
     *
     * @param Loup Le loup à désigner comme étant l'omega.
     * @return Un message indiquant si le loup a été désigné comme omega avec succès ou s'il n'était pas dans la meute.
     */
    public String setOmegaWolf(Loup Loup) {
        if (loups.contains(Loup)) {
            Loup.setRankDomination('ω');
            return (Loup.getName() + " est maintenant un loup Omega");
        } else
            return (Loup.getName() + " n'est pas dans la meute");
    }

    /**
     * Obtient le cri distinctif de la meute.
     *
     * @return Le cri distinctif de la meute.
     */
    public String getHowl() {
        return howl;
    }

    /**
     * Donne naissance à une nouvelle portée de loups dans la meute.
     */
    public void giveBirth() {
        ArrayList<Loup> wolfsBorn = this.CoupleLoup.giveBirth();
        if (wolfsBorn != null) {
            for (Loup Loup : wolfsBorn) {
                this.addWolf(Loup);
            }
        }
    }

    /**
     * Diminue le rang de domination d'un loup naturellement dans la meute.
     *
     * @param Loup Le loup dont le rang de domination doit être diminué.
     */
    public void decreaseRank(Loup Loup) {
        if (this.getWolfs().contains(Loup)) {
            char oldRank = Loup.getRankDomination();
            Loup.setRankDomination(SystemeLoup.decreaseRank(Loup.getRankDomination()));
            System.out.println(Loup.getName() + " a vu son rang diminué (" +
                    oldRank + " -> " + Loup.getRankDomination() + ")");
        } else {
            System.out.println("On ne peut pas baisser le rang d'un loup qui n'est pas dans la meute");
        }
    }

    /**
     * Obtient la liste de tous les loups dans la meute, y compris le couple alpha et les autres membres.
     *
     * @return La liste de tous les loups dans la meute.
     */
    public ArrayList<Loup> getWolfs() {
        ArrayList<Loup> allLoups = new ArrayList<>();
        allLoups.addAll(this.loups);
        allLoups.add(this.CoupleLoup.getWolfMale());
        allLoups.add(this.CoupleLoup.getWolfFemale());
        return allLoups;
    }

    /**
     * Obtient le couple alpha de la meute.
     *
     * @return Le couple alpha de la meute.
     */
    public CoupleLoup getWolfCouple() {
        return CoupleLoup;
    }
}
