package com.example.lucene.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.FieldIndex;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = IndexUnit.INDEX_NAME, type = IndexUnit.TYPE_NAME, shards = 1, replicas = 0)
public class IndexUnit {

	public static final String INDEX_NAME = "digitallibrary";
	public static final String TYPE_NAME = "book";
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String nazivCasopisa;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String naslov;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String autor;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String kljucniPojmovi;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String text; //sadrzaj fajla
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String naucnaOblast;
	@Id
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String filename;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	
	
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

	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFiledate() {
		return filedate;
	}
	
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}
	
}
