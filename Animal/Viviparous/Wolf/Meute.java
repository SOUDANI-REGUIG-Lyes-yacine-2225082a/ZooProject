package Zoo.Animal.Viviparous.Wolf;

import java.util.ArrayList;

import Zoo.Utils;

public class Meute {

	private WolfColony WolfColony;
	private WolfCouple WolfCouple;
	private ArrayList<Loup> loups;
	private String howl;
	
	public Meute(WolfColony WolfColony, WolfCouple WolfCouple, String howl) {
		super();
		this.WolfColony = WolfColony;
		this.WolfColony.addWoldPack(this);
		this.WolfCouple = WolfCouple;
		WolfCouple.setWolfPack(this);
		this.loups = new ArrayList<Loup>();
		this.howl = howl;
		System.out.println("Une nouvelle meute a été crée ! (Couple de la meute : " + this.WolfCouple.getWolfMale().getName() +
						   " & " + this.WolfCouple.getWolfFemale().getName() + ", cri : \"" + this.howl + "\")");
	}

	public void showWolfPack() {
		if (!WolfCouple.isEmpty()) {
			System.out.println("La meute de loups est constitué du couple :");
			this.WolfCouple.showCouple();
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
		System.out.println(this.WolfCouple.getWolfMale().toString());
		System.out.println(this.WolfCouple.getWolfFemale().toString());
		for (Loup Loup : loups) {
			System.out.println(Loup.toString());
		}
	}
	
	// Afficher la hiérarchie des loups de la meute
	public void showHierarchy() {
		System.out.println("Hiérarchie de la meute :");
		ArrayList newHierarchy = new ArrayList();
		
		// On parcourt tout les rangs de domination
		for (Object c : Utils.getListRankDomination()) {
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
		this.WolfCouple.setWolfMale(maleAlphaLoup);
		maleAlphaLoup.setWolfPack(this);
	}
	
	public void addWolf(Loup Loup) {
		// On n'ajoute pas un loupn déjà présent dans le couple
		if (!this.getWolfs().contains(Loup)) {
			loups.add(Loup);
			Loup.setWolfPack(this);
			System.out.println(Loup.getName() + " a été ajouté à la meute");
		}
	}
	
	public void removeWolf(Loup Loup) {
		if(loups.contains(Loup)) {
			loups.remove(Loup);
			Loup.setWolfPack(null);
			System.out.println(Loup.getName() + " a été retiré de la meute");
		}
	}
	
	public void setOmegaWolf(Loup Loup) {
		if(loups.contains(Loup)) {
			Loup.setRankDomination('ω');
			System.out.println(Loup.getName() + " est maintenant un loup Oméga");
		}
	}
	
	public String getHowl() {
		return howl;
	}

	public void giveBirth() {
		ArrayList<Loup> wolfsBorn = this.WolfCouple.giveBirth();
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
			Loup.setRankDomination(Utils.decreaseRank(Loup.getRankDomination()));
			System.out.println(Loup.getName() + " a vu son rang diminué (" +
					oldRank + " -> " + Loup.getRankDomination() + ")");
		}
		else {
			System.out.println("On ne peut baisser le rang d'un loup qui n'est pas la meute");
		}
	}

	public ArrayList<Loup> getWolfs() {
		ArrayList<Loup> allLoups = new ArrayList();
		allLoups.addAll(this.loups);
		allLoups.add(this.WolfCouple.getWolfMale());
		allLoups.add(this.WolfCouple.getWolfFemale());
		return allLoups;
	}

	public WolfCouple getWolfCouple() {
		return WolfCouple;
	}
}
