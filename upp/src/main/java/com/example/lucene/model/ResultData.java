package com.example.lucene.model;

public final class ResultData {
	
	private String nazivCasopisa;
	private String naslov;
	private String autor;
	private String kljucniPojmovi;
	private String text;
	private String naucnaOblast;
	private String location;
	private String highlight;
	
	public ResultData() {
		super();
	}

	public ResultData(String nazivCasopisa, String naslov, String autor, String kljucniPojmovi, String text, String naucnaOblast, String location, String highlight) {
		super();
		this.nazivCasopisa = nazivCasopisa;
		this.naslov = naslov;
		this.autor = autor;
		this.kljucniPojmovi = kljucniPojmovi;
		this.text = text;
		this.naucnaOblast = naucnaOblast;
		this.location = location;
		this.highlight = highlight;
	}

	public String getNazivCasopisa() {
		return nazivCasopisa;
	}

	public void setNazivCasopisa(String nazivCasopisa) {
		this.nazivCasopisa = nazivCasopisa;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getKljucniPojmovi() {
		return kljucniPojmovi;
	}

	public void setKljucniPojmovi(String kljucniPojmovi) {
		this.kljucniPojmovi = kljucniPojmovi;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(String naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

}
