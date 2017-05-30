package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao cDao;
	
	
	@Override
	public List<Categorie> getAllCategories() {
		
		return cDao.getAllCategories();
	}

	@Override
	public List<Produit> getAllProduitByCategories(Long idCategorie){
	
		return cDao.getAllProduitByCategories(idCategorie);
	}

	@Override
	public List<Produit> getProduitSelect() {
		
		return cDao.getProduitSelect();
	}

	@Override
	public List<Produit> getProduitByKeyWord(String mc) {

		return cDao.getProduitByKeyWord(mc);
	}


	@Override
	public Categorie consulter(Categorie c) {
	
		return cDao.consulter(c);
	}

	@Override
	public Produit consulterP(Produit p) {

		return cDao.consulterP(p);
	}

	@Override
	public Produit addProduitToPanier(Produit p, Client c) {
		
		return cDao.addProduitToPanier(p, c);
	}

	@Override
	public Produit deleteProduitPanier(Produit p, Client c) {
		
		return cDao.deleteProduitPanier(p, c);
	}

	@Override
	public Commande enregisterCommande(Panier panier, Client c) {
		
		return cDao.enregisterCommande(panier, c);
	}



}
