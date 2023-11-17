package Zoo.Animal.Viviparous.Wolf;

import java.util.ArrayList;

import Zoo.Utils;

public class WolfPack {

	private WolfColony WolfColony;
	private WolfCouple WolfCouple;
	private ArrayList<Wolf> Wolfs;
	private String howl;
	
	public WolfPack(WolfColony WolfColony, WolfCouple WolfCouple, String howl) {
		super();
		this.WolfColony = WolfColony;
		this.WolfColony.addWoldPack(this);
		this.WolfCouple = WolfCouple;
		WolfCouple.setWolfPack(this);
		this.Wolfs = new ArrayList<Wolf>();
		this.howl = howl;
		System.out.println("Une nouvelle meute a été crée ! (Couple de la meute : " + this.WolfCouple.getWolfMale().getName() +
						   " & " + this.WolfCouple.getWolfFemale().getName() + ", cri : \"" + this.howl + "\")");
	}

	public void showWolfPack() {
		if (!WolfCouple.isEmpty()) {
			System.out.println("La meute de loups est constitué du couple :");
			this.WolfCouple.showCouple();
		}
		if (!Wolfs.isEmpty()) {
			System.out.println("et des loups : ");
			for(Wolf Wolf : Wolfs) {
				System.out.println(Wolf.getName() + " : " + Wolf);
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
		for (Wolf Wolf : Wolfs) {
			System.out.println(Wolf.toString());
		}
	}
	
	// Afficher la hiérarchie des loups de la meute
	public void showHierarchy() {
		System.out.println("Hiérarchie de la meute :");
		ArrayList newHierarchy = new ArrayList();
		
		// On parcourt tout les rangs de domination
		for (Object c : Utils.getListRankDomination()) {
			for (Wolf Wolf : this.getWolfs()) {
				if ((char) c == Wolf.getRankDomination()) {
					newHierarchy.add(c);
					break;
				}
			}
		}
		System.out.println(newHierarchy);
	}
	
	// Constituer un nouveau couple
	public void constituteCouple(Wolf maleAlphaWolf) {
		this.WolfCouple.setWolfMale(maleAlphaWolf);
		maleAlphaWolf.setWolfPack(this);
	}
	
	public void addWolf(Wolf Wolf) {
		// On n'ajoute pas un loupn déjà présent dans le couple
		if (!this.getWolfs().contains(Wolf)) {
			Wolfs.add(Wolf);
			Wolf.setWolfPack(this);
			System.out.println(Wolf.getName() + " a été ajouté à la meute");
		}
	}
	
	public void removeWolf(Wolf Wolf) {
		if(Wolfs.contains(Wolf)) {
			Wolfs.remove(Wolf);
			Wolf.setWolfPack(null);
			System.out.println(Wolf.getName() + " a été retiré de la meute");
		}
	}
	
	public void setOmegaWolf(Wolf Wolf) {
		if(Wolfs.contains(Wolf)) {
			Wolf.setRankDomination('ω');
			System.out.println(Wolf.getName() + " est maintenant un loup Oméga");
		}
	}
	
	public String getHowl() {
		return howl;
	}

	public void giveBirth() {
		ArrayList<Wolf> WolfsBorn = this.WolfCouple.giveBirth();
		if (WolfsBorn != null) { 
			for (Wolf Wolf: WolfsBorn) {
				this.addWolf(Wolf);
			}
		}
	}
	
	// TODO: Permet de décroitre les rangs de domination d'un loup naturellement
	public void decreaseRank(Wolf Wolf) {
		if(this.getWolfs().contains(Wolf)) {
			char oldRank = Wolf.getRankDomination();
			Wolf.setRankDomination(Utils.decreaseRank(Wolf.getRankDomination()));
			System.out.println(Wolf.getName() + " a vu son rang diminué (" + 
					oldRank + " -> " + Wolf.getRankDomination() + ")");
		}
		else {
			System.out.println("On ne peut baisser le rang d'un loup qui n'est pas la meute");
		}
	}

	public ArrayList<Wolf> getWolfs() {
		ArrayList<Wolf> allWolfs = new ArrayList();
		allWolfs.addAll(this.Wolfs);
		allWolfs.add(this.WolfCouple.getWolfMale());
		allWolfs.add(this.WolfCouple.getWolfFemale());
		return allWolfs;
	}

	public WolfCouple getWolfCouple() {
		return WolfCouple;
	}
}
