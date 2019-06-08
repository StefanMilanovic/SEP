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
	private String nameMagazine;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String title;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String author;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String keywords;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String text; //sadrzaj fajla
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String scientificField;
	@Id
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String filename;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;

    public String getNameMagazine() {
        return nameMagazine;
    }

    public void setNameMagazine(String nameMagazine) {
        this.nameMagazine = nameMagazine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getScientificField() {
        return scientificField;
    }

    public void setScientificField(String scientificField) {
        this.scientificField = scientificField;
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
