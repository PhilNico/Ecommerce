package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

public class ProduitServiceImpl implements IProduitService{
	
	@Autowired
	private IProduitDao pDao;
	
	@Override
	public void ajouter(Produit P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int supprimer(Produit p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produit modifier(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit consulter(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}


}
