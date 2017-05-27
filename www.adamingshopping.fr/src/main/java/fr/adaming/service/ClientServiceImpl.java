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
		// TODO Auto-generated method stub
		return cDao.getAllProduitByCategories(idCategorie);
	}

	@Override
	public List<Produit> getProduitSelect() {
		
		return cDao.getProduitSelect();
	}

	@Override
	public Produit getProduitByKeyWord(Produit p) {
		// TODO Auto-generated method stub
		return cDao.getProduitByKeyWord(p);
	}


	@Override
	public Categorie consulter(Categorie c) {
		// TODO Auto-generated method stub
		return cDao.consulter(c);
	}

	@Override
	public Produit consulterP(Produit p) {
		// TODO Auto-generated method stub
		return cDao.consulterP(p);
	}

	@Override
	public Produit addProduitToPanier(Produit p, Client c) {
		// TODO Auto-generated method stub
		return cDao.addProduitToPanier(p, c);
	}

	@Override
	public Produit deleteProduitPanier(Produit p, Client c) {
		// TODO Auto-generated method stub
		return cDao.deleteProduitPanier(p, c);
	}

	@Override
	public Commande enregisterCommande(Panier panier, Client c) {
		// TODO Auto-generated method stub
		return cDao.enregisterCommande(panier, c);
	}



}
