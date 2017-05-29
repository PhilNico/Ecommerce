package fr.adaming.service;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeService {

	public void ajouterLC(LigneCommande lc);

	public void supprimerLC(Long id);

	public LigneCommande getById(Long id);

}
