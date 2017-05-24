package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;


public interface IClientDao {
	
	public List<Categorie> getAllCategories();
	
	public List<Produit> getAllProduitByCategories(Produit p);
	
	public Produit getProduitSelect(Produit P);
	
	public Produit getProduitByKeyWord (Produit p);
	
	public Produit addProduitToPanier(Produit p);
	
	public Produit deleteProduitPanier(Produit p);
	
//	ENREGISTRER PANIER
	

}
