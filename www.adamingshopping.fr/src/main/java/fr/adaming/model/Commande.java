package fr.adaming.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> listeLigneCommande;
	
	@ManyToOne
	@JoinColumn(name="clientId",referencedColumnName="idClient")
	private Client client;

	//Constructeur vide
	public Commande() {
		super();
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(Long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the listeLigneCommande
	 */
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	/**
	 * @param collection the listeLigneCommande to set
	 */
	public void setListeLigneCommande(List<LigneCommande> ligneCommande) {
		this.listeLigneCommande =ligneCommande;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}


	

}//
