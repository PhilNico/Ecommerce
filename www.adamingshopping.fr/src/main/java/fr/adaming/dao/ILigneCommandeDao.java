package fr.adaming.dao;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeDao {
	
	public void ajouterLC(LigneCommande lc);
	
	public void supprimerLC(Long id);
	
	public LigneCommande getById(Long id);
	
}
