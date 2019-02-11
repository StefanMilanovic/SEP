package com.example.lucene.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lucene.model.IndexUnit;
import com.example.lucene.model.RequiredHighlight;
import com.example.lucene.model.ResultData;
import com.example.repository.BookRepository;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lucene.indexing.handlers.DocumentHandler;
import com.example.lucene.indexing.handlers.PDFHandler;
import com.example.lucene.indexing.handlers.TextDocHandler;
import com.example.lucene.indexing.handlers.Word2007Handler;
import com.example.lucene.indexing.handlers.WordHandler;
import io.searchbox.client.JestClient;


@Service
public class ResultRetriever {
	/*
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
			results.add(new ResultData(indexUnit.getNameMagazine(), indexUnit.getTitle(), indexUnit.getAuthor(), indexUnit.getKeywords(), indexUnit.getText(), indexUnit.getScientificField(), indexUnit.getFilename(), "AJDEE"));
		}

		return results;
	}
	*/


	private static int maxHits = 10;
	private static JestClient client;

	static {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200").multiThreaded(true).build());
		ResultRetriever.client = factory.getObject();
	}

	public static void setMaxHits(int maxHits) {
		ResultRetriever.maxHits = maxHits;
	}

	public static int getMaxHits() {
		return ResultRetriever.maxHits;
	}

	public List<ResultData> getResults(org.elasticsearch.index.query.QueryBuilder query, List<RequiredHighlight> requiredHighlights) {
		if (query == null) {
			return null;
		}

		List<ResultData> results = new ArrayList<ResultData>();

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(query);
		searchSourceBuilder.size(maxHits);

		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.field("nameMagazine");
		highlightBuilder.field("title");
		highlightBuilder.field("author");
		highlightBuilder.field("keywords");
		highlightBuilder.field("text");
		highlightBuilder.field("scientificField");
		highlightBuilder.fragmentSize(100);
		//highlightBuilder.preTags("<spam style='color:red'><b>").postTags("</b></spam>");
		highlightBuilder.fragmentSize(500);
		//highlightBuilder2.preTags("<input id=\"dugmePreuzmiRad\" type=\"button\" class=\"btn btn-success\" style=\"float:right\" value=\"Preuzmi rad\">");
		searchSourceBuilder.highlight(highlightBuilder);

		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex("digitallibrary").addType("book").build();

		SearchResult result;
		try {
			result = client.execute(search);
			List<SearchResult.Hit<IndexUnit, Void>> hits = result.getHits(IndexUnit.class);
			ResultData rd;

			for (SearchResult.Hit<IndexUnit, Void> sd : hits) {
				String highlight = "";
				for (String hf : sd.highlight.keySet() ) {
					for (RequiredHighlight rh : requiredHighlights) {
						if(hf.equals(rh.getFieldName())){
							highlight += sd.highlight.get(hf).toString();
						}
					}
				}

				rd = new ResultData(sd.source.getNameMagazine(), sd.source.getTitle(), sd.source.getAuthor(), sd.source.getKeywords(), sd.source.getText(), sd.source.getScientificField(), sd.source.getFilename(), highlight);
				results.add(rd);
			}
		} catch (IOException e) {
			e.printStackTrace();
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
