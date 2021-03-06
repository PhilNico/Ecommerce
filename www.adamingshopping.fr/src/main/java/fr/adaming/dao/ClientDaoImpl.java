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
	public List<Produit> getAllProduitByCategories(Long idCategorie) {
		s=sf.getCurrentSession();
		String req="FROM Produit as p WHERE p.categorie.idCategorie=:pC";
		Query query=s.createQuery(req);
		query.setParameter("pC", idCategorie);
		return query.list();
	}

	@Override
	public List<Produit> getProduitSelect() {
		String req="FROM Produit as p WHERE p.selectionne=true";
		Query query=s.createQuery(req);
		return query.list();
	}

	@Override
	public List<Produit> getProduitByKeyWord(String mc) {
		s=sf.getCurrentSession();
//		Produit p_rec=(Produit) s.get(Produit.class, p.getDesignation());
//		return p_rec;
		String req="SELECT p FROM Produit AS p WHERE p.designation LIKE :x OR p.description LIKE :x OR p.categorie.nom LIKE :x";;
		Query query=s.createQuery(req);
		query.setParameter("x", "%" + mc + "%");
		return query.list();
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
//		s=sf.getCurrentSession();
//		s.save(c);
//		Commande commande=new Commande();
//		commande.setClient(c);
//		commande.setListeLigneCommande((List<LigneCommande>) panier.getItems());
		return null;
	}

	@Override
	public Categorie consulter(Categorie c) {
		s=sf.getCurrentSession();
		String req="FROM Categorie as c WHERE c.idCategorie=:pC";
		Query query=s.createQuery(req);
		query.setParameter("pC", c.getIdCategorie());
		return (Categorie) query.uniqueResult();
		}
	
	@Override
	public Produit consulterP(Produit p) {
		s=sf.getCurrentSession();
		Produit p_rec=(Produit) s.get(Produit.class, p.getIdProduit());
		return p_rec;
	}


	}//



	
