package fr.adaming.service;

import fr.adaming.model.Produit;

public interface IProduitService {
	
	public Produit ajouter();
	public Produit supprimer();
	public Produit modifier();
	public int consulter();
	
}
