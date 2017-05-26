package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;


public interface ICategorieDao {
	
	public void ajouter(Categorie c);
	
	public void supprimer(Categorie c);

	public void modifier(Categorie c);

	public Categorie consulter(int id);
	
	public List<Categorie> consulterAll();

}
