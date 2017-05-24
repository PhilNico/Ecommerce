package fr.adaming.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCommande;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	private List<LigneCommande> listeLigneCommande;

	//Constructeur vide
	public Commande() {
		super();
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(int idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	/// comm
	

}
