package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao{

	@Autowired
	private SessionFactory sf;
	private Session s;
	
	
	@Override
	public void ajouter(Produit p) {
		s=sf.getCurrentSession();
		s.save(p)
		
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
