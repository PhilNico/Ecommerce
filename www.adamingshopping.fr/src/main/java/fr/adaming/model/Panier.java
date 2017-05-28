package fr.adaming.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Panier {
	
	private List<LigneCommande> listeLignesCommande;

	public Panier() {
		super();
	}

	public Panier(List<LigneCommande> listeLignesCommande) {
		super();
		this.listeLignesCommande = listeLignesCommande;
	}

	public List<LigneCommande> getListeLignesCommande() {
		return listeLignesCommande;
	}

	public void setListeLignesCommande(List<LigneCommande> listeLignesCommande) {
		this.listeLignesCommande = listeLignesCommande;
	}

	@Override
	public String toString() {
		return "Panier [listeLignesCommande=" + listeLignesCommande + "]";
	}
	
	
	
	
	
	
	
	

	// @OneToMany(mappedBy="panier")
	// private List<LigneCommande> listeLigneCommande;
	//
	// public Panier() {
	// super();
	// }
	//
	// public Panier(List<LigneCommande> liseLigneCommande) {
	// super();
	// this.listeLigneCommande = liseLigneCommande;
	// }
	//
	// /**
	// * @return the liseLigneCommande
	// */
	// public List<LigneCommande> getLiseLigneCommande() {
	// return listeLigneCommande;
	// }
	//
	// /**
	// * @param liseLigneCommande the liseLigneCommande to set
	// */
	// public void setLiseLigneCommande(List<LigneCommande> liseLigneCommande) {
	// this.listeLigneCommande = liseLigneCommande;
	// }
	//
	//

//	private Map<Long, LigneCommande> produitPanier = new HashMap<Long, LigneCommande>();
//
//	public void addProduitPanier(Produit p, int quantite) {
//
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
//	}
//	
//	public Collection<LigneCommande> getItems(){
//		return produitPanier.values();
//	}
//	
//	public int getSize(){
//		return produitPanier.size();
//	}
//	
//	public double getTotal(){
//		double total=0;
//		for (LigneCommande lc:produitPanier.values()){
//			total=lc.getPrix()*lc.getQuantite();
//		}
//		return total;
//	}
//
//	public void deleteItems(Long idProduit){
//		produitPanier.remove(idProduit);
//	}
}//
