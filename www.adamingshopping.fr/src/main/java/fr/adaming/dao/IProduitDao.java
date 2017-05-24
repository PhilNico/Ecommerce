package fr.adaming.dao;

import fr.adaming.model.Produit;

public interface IProduitDao {
	
	public Produit ajouter();
	public Produit supprimer();
	public Produit modifier();
	public int consulter();

}
