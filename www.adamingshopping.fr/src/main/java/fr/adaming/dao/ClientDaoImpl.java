package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository
public class ClientDaoImpl implements IClientDao{

	@Autowired
	private SessionFactory sf;
	
	private Session s;
	
	/**
	 * @param sf the sf to set
	 */
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Categorie> getAllCategories() {
		s=sf.getCurrentSession();
		String req="FROM Categorie";
		Query query=s.createQuery(req);
		return query.list();
	}

	@Override
	public List<Produit> getAllProduitByCategories(Produit p) {
		s=sf.getCurrentSession();
		String req="FROM Produit as p WHERE p.categorie=p:pC";
		Query query=s.createQuery(req);
		query.setParameter("pC", p.getCategorie());
		List<Produit> listeProduit=query.list();
		return listeProduit;
	}

	@Override
	public Produit getProduitSelect(Produit P) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduitByKeyWord(Produit p) {
		// TODO Auto-generated method stub
		return null;
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

	
}
