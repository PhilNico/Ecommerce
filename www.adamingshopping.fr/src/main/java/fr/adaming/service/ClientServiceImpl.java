package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Categorie;
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
	public List<Produit> getAllProduitByCategories(Produit p) {
		// TODO Auto-generated method stub
		return cDao.getAllProduitByCategories(p);
	}

	@Override
	public Produit getProduitSelect(Produit P) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduitByKeyWord(Produit p) {
		// TODO Auto-generated method stub
		return cDao.getProduitByKeyWord(p);
	}

	@Override
	public Produit addProduitToPanier(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit deleteProduitPanier(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie consulter(int id) {
		// TODO Auto-generated method stub
		return cDao.consulter(id);
	}

	@Override
	public Produit consulterP(int id) {
		// TODO Auto-generated method stub
		return cDao.consulterP(id);
	}

}
