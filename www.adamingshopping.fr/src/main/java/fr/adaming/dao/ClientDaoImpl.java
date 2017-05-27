package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
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
	public List<Produit> getAllProduitByCategories(Categorie c) {
		s=sf.getCurrentSession();
		String req="FROM Produit as p WHERE p.categorie=p:pC";
		Query query=s.createQuery(req);
		query.setParameter("pC", c.getIdCategorie());
		List<Produit> listeProduit=query.list();
		return listeProduit;
	}

	@Override
	public Produit getProduitSelect(Produit p) {
		s=sf.getCurrentSession();
		return (Produit) s.get(Produit.class, p.getIdProduit() );
	}

	@Override
	public Produit getProduitByKeyWord(Produit p) {
		s=sf.getCurrentSession();
		Produit p_rec=(Produit) s.get(Produit.class, p.getDesignation());
		return p_rec;
//		String req="FROM Produit as p WHERE p.designation=p:pD";
//		Query query=s.createQuery(req);
//		query.setParameter("pD", p.getDesignation());
//		return (Produit) query.uniqueResult();
	}

	@Override
	public Produit addProduitToPanier(Produit p, Client c) {
		s=sf.getCurrentSession();
		s.save(p);
		return null;
	}

	@Override
	public Produit deleteProduitPanier(Produit p, Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande enregisterCommande(Panier panier, Client c) {
		s=sf.getCurrentSession();
		s.save(c);
		Commande commande=new Commande();
		commande.setClient(c);
		commande.setListeLigneCommande((List<LigneCommande>) panier.getItems());
		return commande;
	}

	@Override
	public Categorie consulter(int id) {
		s=sf.getCurrentSession();
		Categorie c = (Categorie) s.get(Categorie.class, id);
		return c;
		}
	
	@Override
	public Produit consulterP(int id) {
		s=sf.getCurrentSession();
		Produit p = (Produit) s.get(Produit.class, id);
		return p;
		}
	}



	
