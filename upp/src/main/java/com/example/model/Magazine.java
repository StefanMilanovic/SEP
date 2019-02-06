package com.example.model;

public class Magazine {
	private Long id;
	private String issn;
	private String name;
	private String field;
	private String paymentType;
	
	public Magazine(){}

	public Magazine(String issn, String name, String field, String paymentType) {
		super();
		this.issn = issn;
		this.name = name;
		this.field = field;
		this.paymentType = paymentType;
	}

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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
		
}
