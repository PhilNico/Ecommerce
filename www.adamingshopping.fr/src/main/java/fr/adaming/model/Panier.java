package fr.adaming.model;

import java.util.List;

import javax.persistence.OneToMany;

public class Panier {
	
	@OneToMany(mappedBy="panier")
	private List<LigneCommande> liseLigneCommande;

	public Panier() {
		super();
	}

	public Panier(List<LigneCommande> liseLigneCommande) {
		super();
		this.liseLigneCommande = liseLigneCommande;
	}

	/**
	 * @return the liseLigneCommande
	 */
	public List<LigneCommande> getLiseLigneCommande() {
		return liseLigneCommande;
	}

	/**
	 * @param liseLigneCommande the liseLigneCommande to set
	 */
	public void setLiseLigneCommande(List<LigneCommande> liseLigneCommande) {
		this.liseLigneCommande = liseLigneCommande;
	}
	
	

}
