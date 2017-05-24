package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao {

	public void ajouter(Produit p);

	public int supprimer(Produit p);

	public Produit modifier(Produit p);

	public Produit consulter(Produit p);
	
	public List<Produit> consulterAll();

}
