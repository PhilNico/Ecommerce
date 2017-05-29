package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.LigneCommande;


@Service
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService{
	
	@Autowired
	ILigneCommandeDao ligneCommandeDao;
	

	public void setLigneCommandeDao(ILigneCommandeDao ligneCommandeDao) {
		this.ligneCommandeDao = ligneCommandeDao;
	}

	@Override
	public void ajouterLC(LigneCommande lc) {
		ligneCommandeDao.ajouterLC(lc);		
	}

	@Override
	public void supprimerLC(Long id) {
		ligneCommandeDao.supprimerLC(id);
	}

	@Override
	public LigneCommande getById(Long id) {
		return ligneCommandeDao.getById(id);
	}

}
