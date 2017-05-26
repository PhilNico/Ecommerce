package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;


public interface IClientDao {
	
	public List<Categorie> getAllCategories();
	
	public Categorie consulter(int id);
	
	public Produit consulterP(int id);
	
	public List<Produit> getAllProduitByCategories(Categorie c);
	
	public Produit getProduitSelect(Produit p);
	
	public Produit getProduitByKeyWord (Produit p);
	
	public Produit addProduitToPanier(Produit p, Client c);
	
	public Produit deleteProduitPanier(Produit p, Client c);
	
	public Commande enregisterCommande(Panier panier, Client c);
	

}
