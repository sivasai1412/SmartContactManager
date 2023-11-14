package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //The ID is generated automatically based on the sequence
	private int id;
	private String name;
	@Column(unique = true) //The email column should be unique
	private String email;
	private String password;
	private String role;
	private boolean enabled;
	private String imageUrl;
	@Column(length = 500) //The column should be of length 500
	private String aboutUser;
	
	/***
	 * 1 user have many contacts. This forms a 1 to many relationship.
	 * Here cascading is done so that if one user is saved then all the contacts of that user is saved. 
	 * If the user is deleted all the contacts of that user will be deleted.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Contact> contactList = new ArrayList<>();
	
	public List<Contact> getContactList() {
		return contactList;
	}


	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getAboutUser() {
		return aboutUser;
	}


	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}
	
	
	
}
