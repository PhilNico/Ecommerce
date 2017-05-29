package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

@Service
@Transactional
public class PanierService implements IPanierService {

	@Autowired
	IProduitDao produitDao;

	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	@Override
	public Panier ajouterAuPanier(Produit p, int quantite, Panier panier) {
		
		
		p=produitDao.consulter(p);
		
	if(quantite <= p.getQuantite()){
			
			p.setQuantite(p.getQuantite()-quantite);
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p);
			lc.setPrix(p.getPrix()*quantite);
			lc.setQuantite(quantite);
			int i = 0;
			List<LigneCommande> listeLignesCommande= new ArrayList<LigneCommande>();
			listeLignesCommande=panier.getListeLignesCommande();
			
			for(LigneCommande ligneCommande : listeLignesCommande){
				if(lc.getProduit().getDesignation()==ligneCommande.getProduit().getDesignation()){
				ligneCommande.setQuantite(ligneCommande.getQuantite()+quantite);
					i = 1;
					 }
			}if(i==0){
			
				listeLignesCommande=panier.getListeLignesCommande();
			
			listeLignesCommande.add(lc);
			
			panier.setListeLignesCommande(listeLignesCommande);
		}
			return panier;
	}else{
			return panier;
	}
		
		
		
		
		
//		LigneCommande lc = produitPanier.get(p.getIdProduit());
//		if (lc == null) {
//
//			LigneCommande article = new LigneCommande();
//			article.setProduit(p);
//			article.setQuantite(quantite);
//			article.setPrix(p.getPrix());
//			produitPanier.put(p.getIdProduit(), article);
//		} else {
//			lc.setQuantite(lc.getQuantite() + quantite);
//		}
		
	}

}
