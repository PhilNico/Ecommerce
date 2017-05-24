package fr.adaming.service;

import fr.adaming.model.Produit;

public interface IProduitService {

	public void ajouter(Produit P);

	public int supprimer(Produit p);

	public Produit modifier(Produit p);

	public Produit consulter(Produit p);
}
