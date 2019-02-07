package com.example.repository;

import java.util.List;

import com.example.lucene.model.IndexUnit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface BookRepository extends ElasticsearchRepository<IndexUnit, String> {

	List<IndexUnit> findByNazivCasopisa(String nazivCasopisa);
	List<IndexUnit> findByNaslov(String naslov);
	List<IndexUnit> findByAutor(String autor);
	List<IndexUnit> findByKljucniPojmovi(String kljucniPojmovi);
	List<IndexUnit> findByText(String text);
	List<IndexUnit> findByNaucnaOblast(String naucnaOblast);
	IndexUnit findByFilename(String filename);
	IndexUnit findByFiledate(String filedate);
	
}