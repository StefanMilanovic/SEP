package com.example.elasticsearch.repository;

import com.example.elasticsearch.model.ScientificPaperES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScientificPaperESRepository extends ElasticsearchRepository<ScientificPaperES, Long> {
    List<ScientificPaperES> findByName(String name);

}
