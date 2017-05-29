package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_r")
	private int id;
	
	@Column(name="rolename")
	private String roleName;
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName="id_u")
	private User user;

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param rolename
	 */
	public Role(String rolename) {
		super();
		this.roleName = rolename;
	}

	/**
	 * @param id
	 * @param rolename
	 */
	public Role(int id, String rolename) {
		super();
		this.id = id;
		this.roleName = rolename;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return roleName;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.roleName = rolename;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
}
