package fr.adaming.dao;

import fr.adaming.model.Produit;

public interface IProduitDao {

	public void ajouter(Produit P);

	public int supprimer(Produit p);

	public Produit modifier(Produit p);

	public Produit consulter(Produit p);

}
