package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneCommandes")
public class LigneCommande {

	private int id;
	private int quantite;
	private int prix;

	@ManyToOne
	private Produit produit;

	@ManyToOne
	private Commande commade;

	// Constructeur vide
	public LigneCommande() {
		super();
	}

	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public LigneCommande(int id, int quantite, int prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the commade
	 */
	public Commande getCommade() {
		return commade;
	}

	/**
	 * @param commade the commade to set
	 */
	public void setCommade(Commande commade) {
		this.commade = commade;
	}
	
	

}
