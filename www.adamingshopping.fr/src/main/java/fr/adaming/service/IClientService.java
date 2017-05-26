package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IClientService {

	public List<Categorie> getAllCategories();
	
	public Produit consulterP(int id);

	public Categorie consulter(int id);
	
	public List<Produit> getAllProduitByCategories(Categorie c);

	public Produit getProduitSelect(Produit P);

	public Produit getProduitByKeyWord(Produit p);

	public Produit addProduitToPanier(Produit p);

	public Produit deleteProduitPanier(Produit p);

}
