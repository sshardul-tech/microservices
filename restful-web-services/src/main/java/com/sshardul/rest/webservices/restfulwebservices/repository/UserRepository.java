package com.sshardul.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sshardul.rest.webservices.restfulwebservices.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
