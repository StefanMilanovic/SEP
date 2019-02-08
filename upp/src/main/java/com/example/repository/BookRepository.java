package com.example.repository;

import java.util.List;

import com.example.lucene.model.IndexUnit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface BookRepository extends ElasticsearchRepository<IndexUnit, String> {

	List<IndexUnit> findByNameMagazine(String nameMagazine);
	List<IndexUnit> findByTitle(String title);
	List<IndexUnit> findByAuthor(String autor);
	List<IndexUnit> findByKeywords(String keywords);
	List<IndexUnit> findByText(String text);
	List<IndexUnit> findByScientificField(String scientificField);
	IndexUnit findByFilename(String filename);
	IndexUnit findByFiledate(String filedate);
	
}