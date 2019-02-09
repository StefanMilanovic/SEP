package com.example.lucene.search;

import java.util.ArrayList;
import java.util.List;

import com.example.lucene.model.IndexUnit;
import com.example.lucene.model.RequiredHighlight;
import com.example.lucene.model.ResultData;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lucene.indexing.handlers.DocumentHandler;
import com.example.lucene.indexing.handlers.PDFHandler;
import com.example.lucene.indexing.handlers.TextDocHandler;
import com.example.lucene.indexing.handlers.Word2007Handler;
import com.example.lucene.indexing.handlers.WordHandler;

@Service
public class ResultRetriever {
	
	@Autowired
	private BookRepository bookRepository;
	
	public ResultRetriever(){
		
	}

	public List<ResultData> getResults(org.elasticsearch.index.query.QueryBuilder query,
									   List<RequiredHighlight> requiredHighlights) {
		if (query == null) {
			return null;
		}
			
		List<ResultData> results = new ArrayList<ResultData>();

		for (IndexUnit indexUnit : bookRepository.search(query)) {
			results.add(new ResultData(indexUnit.getNameMagazine(), indexUnit.getTitle(), indexUnit.getAuthor(), indexUnit.getKeywords(), indexUnit.getText(), indexUnit.getScientificField(), indexUnit.getFilename(), ""));
		}

		return results;
	}
	
	protected DocumentHandler getHandler(String fileName){
		if(fileName.endsWith(".txt")){
			return new TextDocHandler();
		}else if(fileName.endsWith(".pdf")){
			return new PDFHandler();
		}else if(fileName.endsWith(".doc")){
			return new WordHandler();
		}else if(fileName.endsWith(".docx")){
			return new Word2007Handler();
		}else{
			return null;
		}
	}
	
}
