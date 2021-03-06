package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;

	@OneToMany(mappedBy = "client")
	private List<Commande> listeCommande;

	public Client() {
		super();
	}

	public Client(String nomClient, String adresse, String email, String tel, Commande commande) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;

	}

	public Client(Long idClient, String nomClient, String adresse, String email, String tel, Commande commande) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;

	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the listeCommande
	 */
	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	/**
	 * @param listeCommande
	 *            the listeCommande to set
	 */
	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

}
