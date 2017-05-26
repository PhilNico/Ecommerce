package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;



@Service("cService")
@Transactional
public class CategorieServiceImpl implements ICategorieService{
	
	@Autowired
	ICategorieDao categorieDao;
	
	

	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;

}



	@Override
	public void ajouter(Categorie c) {
		categorieDao.ajouter(c);
		
	}



	@Override
	public void supprimer(Categorie c) {
		categorieDao.supprimer(c);
	}



	@Override
	public void modifier(Categorie c) {
		categorieDao.modifier(c);
	}



	@Override
	public Categorie consulter(int id) {
	
		return categorieDao.consulter(id);
	}



	@Override
	public List<Categorie> consulterAll() {
		
		return categorieDao.consulterAll();
	}
}
