package space.earth.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import space.earth.dao.RoleDAO;
import space.earth.dao.UserDAO;
import space.earth.entities.PrimaryAccount;
import space.earth.entities.SavingsAccount;
import space.earth.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired 
	private RoleDAO roleRepository; 
	
	
	public void create(User user, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) {
		user.setPrimaryAccount(primaryAccount);
		user.setSavingsAccount(savingsAccount);
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));

		userDAO.save(user);
		
		

	}

	public Boolean exist(int userId) {

		return userDAO.existsById(userId);

	}

	public Optional<User> findById(int userId) {
		return userDAO.findById(userId);
	}

	public List<User> findAll() {
		return (List<User>) userDAO.findAll();
	}

//	public boolean existByUsername(String username) {
//		List<User> users = new ArrayList<User>();
//
//		users = (List<User>) userDAO.findAll();
//
//		for (int i = 0; i < users.size(); i++) {
//
//			if (users.get(i).getUsername().equals(username)) {
//				return true;
//			}
//		}
//
//		return false;
//	}

//	public User findByUsername(String username) {
//		List<User> users = new ArrayList<User>();
//
//		users = (List<User>) userDAO.findAll();
//
//		for (int i = 0; i <= users.size(); i++) {
//
//			if (users.get(i).getUsername().equals(username)) {
//				return users.get(i);
//			}
//		}
//
//		return null;
//	}
	
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public int getPrimaryAccountIdByUserId(int userId) {
		return userDAO.findById(userId).get().getPrimaryAccount().getId();
		
	}

	public int getSavingsAccountIdByUserId(int userId) {
		// TODO Auto-generated method stub
		return userDAO.findById(userId).get().getSavingsAccount().getId(); 
	}

	

}
