package com.sshardul.rest.webservices.restfulwebservices.controller;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sshardul.rest.webservices.restfulwebservices.exception.UserNotFound;
import com.sshardul.rest.webservices.restfulwebservices.impl.UserDaoImpl;
import com.sshardul.rest.webservices.restfulwebservices.pojo.User;

//@RestController
@Controller
public class UserController {

	@Autowired
	UserDaoImpl userDaoImpl;

	@GetMapping(path = "/users")
	@ResponseBody
	public List<User> getAllUsers() {
		return userDaoImpl.findAll();
	}

	@GetMapping(path = "/user/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User luser = userDaoImpl.getUserById(id);
		if (luser == null) {
			throw new UserNotFound("id=" + id);
		}

		EntityModel<User> model = EntityModel.of(luser);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		model.add(link.withRel("all user :"));
		return model;
	}

	@PostMapping(path = "/users")
	public User getUser(@RequestBody User user) {
		User luser = userDaoImpl.createUser(user);
		return luser;
	}

	@DeleteMapping(path = "/user/{id}")
	public ResponseEntity<User> removeUser(@PathVariable int id) {
		User luser = userDaoImpl.deleteUser(id);
		if (luser == null) {
			throw new UserNotFound("id=" + id);
		}
		return new ResponseEntity<User>(HttpStatus.ACCEPTED);
	}
}
