package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IUserDao;
import fr.adaming.model.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDao userDao;

	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void ajouterUser(User u) {
		userDao.ajouterUser(u);
		
	}

	@Override
	public void supprimerUser(int id) {
		userDao.supprimerUser(id);
		
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> consulterAll() {
		return userDao.consulterAll();
	}

	@Override
	public void modifier(User u) {
		userDao.modifier(u);
		
	}

}
