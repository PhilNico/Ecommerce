package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	@Override
	public void ajouter(Produit p) {
		s = sf.getCurrentSession();
		s.save(p);

	}

	@Override
	public int supprimer(Produit p) {
		s = sf.getCurrentSession();
		Produit p_rec = (Produit) s.get(Produit.class, p.getIdProduit());
		if (p_rec != null) {
			s.delete(p_rec);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Produit modifier(Produit p) {
		s=sf.getCurrentSession();
		s.update(p);
		return p;
	}

	@Override
	public Produit consulter(Produit p) {
		s=sf.getCurrentSession();
		Produit p_rec=(Produit) s.get(Produit.class, p.getIdProduit());
		return p_rec;
	}

	@Override
	public List<Produit> consulterAll() {
		s=sf.getCurrentSession();
		String req="FROM Produit";
		Query query=s.createQuery(req);
		List<Produit> listeProduits=query.list();
		return listeProduits;
	}

	
}
