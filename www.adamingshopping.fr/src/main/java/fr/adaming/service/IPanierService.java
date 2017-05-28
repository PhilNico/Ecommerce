package fr.adaming.service;

import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

public interface IPanierService {
	
	public Panier ajouterAuPanier(Produit p, int quantite, Panier panier);

}
