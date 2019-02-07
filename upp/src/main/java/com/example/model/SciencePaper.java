package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class SciencePaper {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false)
	private String name;	



	@Column(nullable = false)
	private String keywords;
	
	@Column(nullable = false)
	private String abbstract;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
	private ScientificField scientificField;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Magazine scienceMagazine;
	
	@Column()
	private String revisionPDF;
	
	@Column(nullable = false)
	private String finalPDF;
	
	public SciencePaper(){}
	
	public SciencePaper(String name, String keywords, String abbstract, ScientificField scientificField, String revisionPDF, String finalPDF) {
		super();
		this.name = name;
		this.keywords = keywords;
		this.abbstract = abbstract;
		this.scientificField = scientificField;
		this.revisionPDF = revisionPDF;
		this.finalPDF = finalPDF;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getAbbstract() {
		return abbstract;
	}

	public void setAbbstract(String abbstract) {
		this.abbstract = abbstract;
	}

	public ScientificField getScentificField() {
		return scientificField;
	}

	public void setScentificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}

	public String getRevisionPDF() {
		return revisionPDF;
	}

	public void setRevisionPDF(String revisionPDF) {
		this.revisionPDF = revisionPDF;
	}

	public String getFinalPDF() {
		return finalPDF;
	}

	public void setFinalPDF(String finalPDF) {
		this.finalPDF = finalPDF;
	}
	
	
	
	
}
