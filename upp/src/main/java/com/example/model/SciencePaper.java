package com.example.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
public class SciencePaper {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false)
	private String name;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "autor_id")
	private User author;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "coAuthor_sciencePaper",
			joinColumns = { @JoinColumn(name = "coAuthor_id") },
			inverseJoinColumns = { @JoinColumn(name = "sciencePaper_id") }
	)
	private List<User> coAuthor;


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

	@Transient
	@Lob
	private MultipartFile[] textPDF;

	@Column(nullable = false)
	private String finalPDF;


	private String nameMagazine;

	private String nameScientifiField;

	public SciencePaper(){}
	
	public SciencePaper(String name, String keywords, String abbstract, ScientificField scientificField, MultipartFile[] textPDF, String finalPDF) {
		super();
		this.name = name;
		this.keywords = keywords;
		this.abbstract = abbstract;
		this.scientificField = scientificField;
		this.textPDF = textPDF;
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

	public String getFinalPDF() {
		return finalPDF;
	}

	public void setFinalPDF(String finalPDF) {
		this.finalPDF = finalPDF;
	}

	public MultipartFile[] getTextPDF() {
		return textPDF;
	}

	public void setTextPDF(MultipartFile[] textPDF) {
		this.textPDF = textPDF;
	}

	public String getNameMagazine() {
		return nameMagazine;
	}

	public void setNameMagazine(String nameMagazine) {
		this.nameMagazine = nameMagazine;
	}

	public String getNameScientifiField() {
		return nameScientifiField;
	}

	public void setNameScientifiField(String nameScientifiField) {
		this.nameScientifiField = nameScientifiField;
	}

	public ScientificField getScientificField() {
		return scientificField;
	}

	public void setScientificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}

	public Magazine getScienceMagazine() {
		return scienceMagazine;
	}

	public void setScienceMagazine(Magazine scienceMagazine) {
		this.scienceMagazine = scienceMagazine;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<User> getCoAuthor() {
		return coAuthor;
	}

	public void setCoAuthor(List<User> coAuthor) {
		this.coAuthor = coAuthor;
	}
}
