package com.example.model;

public class SciencePaper {
	private String id;	
	private String name;	
	private String keywords;	
	private String abbstract;
	private String scentificField;
	private String revisionPDF;
	private String finalPDF;
	
	public SciencePaper(){}
	
	public SciencePaper(String name, String keywords, String abbstract, String scentificField, String revisionPDF, String finalPDF) {
		super();
		this.name = name;
		this.keywords = keywords;
		this.abbstract = abbstract;
		this.scentificField = scentificField;
		this.revisionPDF = revisionPDF;
		this.finalPDF = finalPDF;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getScentificField() {
		return scentificField;
	}

	public void setScentificField(String scentificField) {
		this.scentificField = scentificField;
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
