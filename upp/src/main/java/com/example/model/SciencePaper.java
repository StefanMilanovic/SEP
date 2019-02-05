package com.example.model;

public class SciencePaper {
	private String id;	
	private String name;	
	private String keySubjects;	
	private String abbstract;	
	private String scentificField;
	
	public SciencePaper(){}
	
	public SciencePaper(String name, String keySubjects, String abbstract, String scentificField) {
		super();
		this.name = name;
		this.keySubjects = keySubjects;
		this.abbstract = abbstract;
		this.scentificField = scentificField;
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

	public String getKeySubjects() {
		return keySubjects;
	}

	public void setKeySubjects(String keySubjects) {
		this.keySubjects = keySubjects;
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
	
	
}
