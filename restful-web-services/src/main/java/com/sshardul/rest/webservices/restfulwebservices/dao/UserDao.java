package com.sshardul.rest.webservices.restfulwebservices.dao;

import java.util.List;

import com.sshardul.rest.webservices.restfulwebservices.pojo.User;


public interface UserDao {
	
	List<User> findAll();
	
	User getUserById(int id);
	
	User createUser(User user);
	
	User deleteUser(int id);

}
