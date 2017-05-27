package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

public interface IClientService {

	public List<Categorie> getAllCategories();

	public Produit consulterP(Produit p);

	public Categorie consulter(Categorie c);

	public List<Produit> getAllProduitByCategories(Long idCategorie);

	public List<Produit> getProduitSelect();

	public Produit getProduitByKeyWord(Produit p);

	public Produit addProduitToPanier(Produit p, Client c);

	public Produit deleteProduitPanier(Produit p, Client c);

	public Commande enregisterCommande(Panier panier, Client c);

}
