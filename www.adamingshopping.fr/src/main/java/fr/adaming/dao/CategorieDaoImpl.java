package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;


@Repository
public class CategorieDaoImpl implements ICategorieDao{
	
	@Autowired
	private SessionFactory sf;
	
	private Session s;

	@Override
	public void ajouter(Categorie c) {
		s = sf.getCurrentSession();
		s.save(c);
		
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void supprimer(Categorie c) {
		s =sf.getCurrentSession();
		s.delete(c);
		
	}

	@Override
	public void modifier(Categorie c) {
		s=sf.getCurrentSession();
		s.update(c);
		
	}

	@Override
	public Categorie consulter(Long id) {
		s=sf.getCurrentSession();
		Categorie c = (Categorie) s.get(Categorie.class, id);
		return c;
	}

	@Override
	public List<Categorie> consulterAll() {
		s=sf.getCurrentSession();
		
		String req= "FROM Categorie";
							
		
		Query query = s.createQuery(req);
		return query.list();
	}
	
	

}//
