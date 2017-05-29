package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.User;

public interface IUserDao {
	
	public void ajouterUser(User u);
	public void supprimerUser(int id);
	public User getUserById(int id);
	public List<User> consulterAll();
	public void modifier(User u);

}
