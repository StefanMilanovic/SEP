package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;	
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Magazine {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String issn;
	
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "scienceMagazine", cascade = CascadeType.ALL)
	private List<SciencePaper> scientificPapers = new ArrayList<SciencePaper>();



	/*@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
		})
	@JoinTable(name = "magazine_fields",
		joinColumns = @JoinColumn(name = "mag_id"),
		inverseJoinColumns = @JoinColumn(name = "field_id")
			)
	private List<ScientificField> scientificFields = new ArrayList<ScientificField>();
*/
	@ManyToOne
	@JoinColumn(name="scientificFields_id", nullable=false)
	@JsonIgnore
	private ScientificField scientificField;

	public Magazine(String issn, String name) {
		super();
		this.issn = issn;
		this.name = name;		
	}

	public Magazine(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SciencePaper> getScientificPapers() {
		return scientificPapers;
	}

	public void setScientificPapers(List<SciencePaper> scientificPapers) {
		this.scientificPapers = scientificPapers;
	}
/*
	public List<ScientificField> getScientificFields() {
		return scientificFields;
	}

	public void setScientificFields(List<ScientificField> scientificFields) {
		this.scientificFields = scientificFields;
	}
	*/

	public ScientificField getScientificField() {
		return scientificField;
	}

	public void setScientificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}
}
