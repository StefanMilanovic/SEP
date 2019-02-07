package com.example.elasticsearch.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "scientificpaper", type = "paper", shards = 1)
public class ScientificPaperES {

    @Id
    private Long id;

    @Field(type = FieldType.Text)
    @JsonProperty
    private String name;

    @Field(type = FieldType.Text)
    @JsonProperty
    private String keywords;

    @Field(type = FieldType.Text)
    @JsonProperty
    private String abbstract;

    @Field(type = FieldType.Text)
    @JsonProperty
    private String scentificField;

    @Field(type = FieldType.Text)
    @JsonProperty
    private String revisionPDF;

    @Field(type = FieldType.Text)
    @JsonProperty
    private String finalPDF;

    public ScientificPaperES(){

    }

    public ScientificPaperES(Long id, String name, String keywords, String abbstract, String scentificField, String revisionPDF, String finalPDF) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.abbstract = abbstract;
        this.scentificField = scentificField;
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
