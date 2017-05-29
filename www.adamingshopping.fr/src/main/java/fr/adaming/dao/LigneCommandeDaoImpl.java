package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;

@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	private Session s;

	@Override
	public void ajouterLC(LigneCommande lc) {
		s = sf.getCurrentSession();
		s.save(lc);
	}

	@Override
	public void supprimerLC(Long id) {
		s = sf.getCurrentSession();
		LigneCommande lc = (LigneCommande) s.get(LigneCommande.class, id);
		s.delete(lc);
	}

	@Override
	public LigneCommande getById(Long id) {
		s=sf.getCurrentSession();
		LigneCommande lc= (LigneCommande) s.get(LigneCommande.class, id);
		return lc;
	}

}
