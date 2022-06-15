package com.sshardul.rest.webservices.restfulwebservices.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

	@Size(min = 2)
	@Column
	private String name;
	
	@Id
	@GeneratedValue
	@Column
	private Integer userId;
	
	@Past
	@Column
	private Date birthDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public User(@Size(min = 2) String name, Integer userId, @Past Date birthDate) {
		super();
		this.name = name;
		this.userId = userId;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userId=" + userId + ", birthDate=" + birthDate + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
