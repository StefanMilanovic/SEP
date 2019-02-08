package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;	
    
	@Column(nullable = false)
	private String firstname;
    
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
    private String city;    
    
	@Column(nullable = false)
	private String country;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String role;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "user_scientificFieldList",
			joinColumns = { @JoinColumn(name = "editor_id") },
			inverseJoinColumns = { @JoinColumn(name = "scientificFieldList_id") }
	)
	private List<ScientificField> scientificFieldList;



	public User(){}

	public User(String username, String firstname, String lastname, String city, String country, String email, String password, String role, List<ScientificField> scientificFieldList) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.country = country;
		this.email = email;
		this.password = password;
		this.role = role;
		this.scientificFieldList = scientificFieldList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String state) {
		this.country = state;
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

	public List<ScientificField> getScientificFieldList() {
		return scientificFieldList;
	}

	public void setScientificFieldList(List<ScientificField> scientificFieldList) {
		this.scientificFieldList = scientificFieldList;
	}
}
