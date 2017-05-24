package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Service("pService")
@Transactional
public class ProduitServiceImpl implements IProduitService{
	
	@Autowired
	private IProduitDao pDao;
	
	@Override
	public void ajouter(Produit p) {
		pDao.ajouter(p);
		
	}

	@Override
	public int supprimer(Produit p) {
		// TODO Auto-generated method stub
		return pDao.supprimer(p);
	}

	@Override
	public Produit modifier(Produit p) {
		// TODO Auto-generated method stub
		return pDao.modifier(p);
	}

	@Override
	public Produit consulter(Produit p) {
		// TODO Auto-generated method stub
		return pDao.consulter(p);
	}

	@Override
	public List<Produit> consulterAll() {
		// TODO Auto-generated method stub
		return pDao.consulterAll();
	}
	


}
