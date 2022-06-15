package com.sshardul.rest.webservices.restfulwebservices.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshardul.rest.webservices.restfulwebservices.pojo.User;
import com.sshardul.rest.webservices.restfulwebservices.repository.UserRepository;

@Service
public class UserDaoImpl/* implements UserDao */ {

	@Autowired
	UserRepository userRepository;
	/*
	 * static int count = 3; static List<User> lUser = new ArrayList<>();
	 * 
	 * static { lUser.add(new User("Sandhya",new Date(04/9/91),1)); lUser.add(new
	 * User("Anurag",new Date(03/2/91),2)); lUser.add(new User("Vaibhav",new
	 * Date(17/1/18),3)); }
	 */
	
	public List<User> findAll() {
	return userRepository.findAll();
	}

	/*
	 * @Override public User getUserById(int id) { for (User user : lUser) {
	 * if(user.getUserId() == id) { return user; } } return null; }
	 */
	
	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get() == null ? user.get() : null;
	}

	/*
	 * @Override public User createUser(User user) { lUser.add(new
	 * User(user.getName(),user.getBirthDate(),count+1)); count = count +1; return
	 * null; }
	 */
	
	public User createUser(User user) {
		User u = userRepository.save(user);
		return u;
	}

	/*
	 * @Override public User deleteUser(int id) { for (User user : lUser) {
	 * if(user.getUserId() == id) { int i = lUser.indexOf(user); lUser.remove(i);
	 * count = count -1; return user; } } return null; }
	 */

	public User deleteUser(int id) {
		userRepository.deleteById(id);
		return null;
	}

}
