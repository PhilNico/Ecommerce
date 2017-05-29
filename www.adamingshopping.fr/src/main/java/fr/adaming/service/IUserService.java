package fr.adaming.service;

import java.util.List;

import fr.adaming.model.User;

public interface IUserService {

	public void ajouterUser(User u);
	public void supprimerUser(int id);
	public User getUserById(int id);
	public List<User> consulterAll();
	public void modifier(User u);
	
}
