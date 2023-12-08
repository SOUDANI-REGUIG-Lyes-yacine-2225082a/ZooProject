package Animal.Vivipaire.TDLoup;

import java.util.ArrayList;


import Zoo.SystemeLoup;

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

	public void showWolfPack() {
		if (!CoupleLoup.isEmpty()) {
			System.out.println("La meute de loups est constitué du couple :");
			this.CoupleLoup.showCouple();
		}
		if (!loups.isEmpty()) {
			System.out.println("et des loups : ");
			for(Loup Loup : loups) {
				System.out.println(Loup.getName() + " : " + Loup);
			}
		}
		else {
			System.out.println();
		}
	}
	
	public void showWolfs() {
		System.out.println("Caractéristiques des loups "
				+ "de la meute :");
		System.out.println(this.CoupleLoup.getWolfMale().toString());
		System.out.println(this.CoupleLoup.getWolfFemale().toString());
		for (Loup Loup : loups) {
			System.out.println(Loup.toString());
		}
	}
	
	// Afficher la hiérarchie des loups de la meute
	public void showHierarchy() {
		System.out.println("Hiérarchie de la meute :");
		ArrayList newHierarchy = new ArrayList();
		
		// On parcourt tout les rangs de domination
		for (Object c : SystemeLoup.getListRankDomination()) {
			for (Loup Loup : this.getWolfs()) {
				if ((char) c == Loup.getRankDomination()) {
					newHierarchy.add(c);
					break;
				}
			}
		}
		System.out.println(newHierarchy);
	}
	
	// Constituer un nouveau couple
	public void constituteCouple(Loup maleAlphaLoup) {
		this.CoupleLoup.setWolfMale(maleAlphaLoup);
		maleAlphaLoup.setWolfPack(this);
	}
	
	public String addWolf(Loup Loup) {
		// On n'ajoute pas un loupn déjà présent dans le couple
		if (!this.getWolfs().contains(Loup)) {
			loups.add(Loup);
			Loup.setWolfPack(this);
			return(Loup.getName() + " a ete ajouté à la meute");
		}else
		return(Loup.getName() + " est déjà dans la meute");
	}
	
	public void removeWolf(Loup Loup) {
		if(loups.contains(Loup)) {
			loups.remove(Loup);
			Loup.setWolfPack(null);
			System.out.println(Loup.getName() + " a ete retiré de la meute");
		}
	}
	
	public String setOmegaWolf(Loup Loup) {
		if(loups.contains(Loup)) {
			Loup.setRankDomination('ω');
			return(Loup.getName() + " est maintenant un loup Omega");
		}else
		return(Loup.getName() + " n'est pas dans la meute");
	}
	
	public String getHowl() {
		return howl;
	}

	public void giveBirth() {
		ArrayList<Loup> wolfsBorn = this.CoupleLoup.giveBirth();
		if (wolfsBorn != null) {
			for (Loup Loup : wolfsBorn) {
				this.addWolf(Loup);
			}
		}
	}
	
	// TODO: Permet de décroitre les rangs de domination d'un loup naturellement
	public void decreaseRank(Loup Loup) {
		if(this.getWolfs().contains(Loup)) {
			char oldRank = Loup.getRankDomination();
			Loup.setRankDomination(SystemeLoup.decreaseRank(Loup.getRankDomination()));
			System.out.println(Loup.getName() + " a vu son rang diminue (" +
					oldRank + " -> " + Loup.getRankDomination() + ")");
		}
		else {
			System.out.println("On ne peut baisser le rang d'un loup qui n'est pas la meute");
		}
	}

	public ArrayList<Loup> getWolfs() {
		ArrayList<Loup> allLoups = new ArrayList();
		allLoups.addAll(this.loups);
		allLoups.add(this.CoupleLoup.getWolfMale());
		allLoups.add(this.CoupleLoup.getWolfFemale());
		return allLoups;
	}

	public CoupleLoup getWolfCouple() {
		return CoupleLoup;
	}
}
