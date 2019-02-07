package com.example.elasticsearch.service;

import com.example.elasticsearch.model.ScientificPaperES;

import java.util.List;

public interface ScientificPaperESService {

    List<ScientificPaperES> searchByOneField(String field, String value);
}
