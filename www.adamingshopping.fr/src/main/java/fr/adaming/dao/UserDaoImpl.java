package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.User;

@Repository
public class UserDaoImpl implements IUserDao{

	@Autowired
	private SessionFactory sf;
	
	private Session s;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void ajouterUser(User u) {
		s=sf.getCurrentSession();
		s.save(u); 
	}

	@Override
	public void supprimerUser(int id) {
		s=sf.getCurrentSession();
		s.delete(s.get(User.class, id));
		
	}

	@Override
	public User getUserById(int id) {
		s=sf.getCurrentSession();
		User urec=(User) s.get(User.class, id);
		return urec;
	}

	@Override
	public List<User> consulterAll() {
		s=sf.getCurrentSession();
		 String req = "FROM User";
		 Query query = s.createQuery(req);
		
		return query.list();
	}

	@Override
	public void modifier(User u) {
		s=sf.getCurrentSession();
		s.update(u);
	}
	
	

}
