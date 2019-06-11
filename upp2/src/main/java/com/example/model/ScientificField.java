package com.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ScientificField {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "scientificField", cascade = CascadeType.ALL)
	private List<SciencePaper> sciencePapers = new ArrayList<SciencePaper>();

	@OneToMany(mappedBy = "scientificField", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Set<Magazine> magazines = new HashSet<Magazine>();

	public ScientificField(){}

	public List<SciencePaper> getSciencePapers() {
		return sciencePapers;
	}

	public void setSciencePapers(List<SciencePaper> sciencePapers) {
		this.sciencePapers = sciencePapers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Magazine> getMagazines() {
		return magazines;
	}

	public void setMagazines(Set<Magazine> magazines) {
		this.magazines = magazines;
	}
}
