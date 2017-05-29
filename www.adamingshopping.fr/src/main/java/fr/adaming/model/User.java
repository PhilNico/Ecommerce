package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_u")
	private int id;

	@Column(name = "username")
	private String userName;
	private String password;
	private boolean actived;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Role> listeRole;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 * @param actived
	 */
	public User(String username, String password, boolean actived) {
		super();
		this.userName = username;
		this.password = password;
		this.actived = actived;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param actived
	 */
	public User(int id, String username, String password, boolean actived) {
		super();
		this.id = id;
		this.userName = username;
		this.password = password;
		this.actived = actived;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return userName;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.userName = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the actived
	 */
	public boolean isActived() {
		return actived;
	}

	/**
	 * @param actived
	 *            the actived to set
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	/**
	 * @return the listeRole
	 */
	public List<Role> getListeRole() {
		return listeRole;
	}

	/**
	 * @param listeRole
	 *            the listeRole to set
	 */
	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}

}
