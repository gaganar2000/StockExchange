package com.example.StockExchange.demostockExchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//don’t’ use user as table name as it is reserved word in some dbs)
public class Users {

	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String password;
	private String email;
	
//	@Column(columnDefinition = "default false")
	private Boolean Confirmed;
	
//	@Column(columnDefinition = "default false")
	private Boolean Admin;
	
	private String Role;
	private String mobile;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getConfirmed() {
		return Confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		Confirmed = confirmed;
	}
	public Boolean getAdmin() {
		return Admin;
	}
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Users(long id, String name, String password, String email, Boolean confirmed, Boolean admin, String role,
			String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		Confirmed = confirmed;
		Admin = admin;
		Role = role;
		this.mobile = mobile;
	}
	
	public Users() {
		
	}
	
	
}

