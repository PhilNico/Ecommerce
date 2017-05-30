package fr.adaming.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier {

	private List<LigneCommande> listeLignesCommande;

	public Panier() {
		super();
	}

	public Panier(List<LigneCommande> listeLignesCommande) {
		super();
		this.listeLignesCommande = listeLignesCommande;
	}

	public List<LigneCommande> getListeLignesCommande() {
		return listeLignesCommande;
	}

	public void setListeLignesCommande(List<LigneCommande> listeLignesCommande) {
		this.listeLignesCommande = listeLignesCommande;
	}

	@Override
	public String toString() {
		return "Panier [listeLignesCommande=" + listeLignesCommande + "]";
	}

}
