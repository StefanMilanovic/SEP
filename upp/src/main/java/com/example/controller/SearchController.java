package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.lucene.model.*;
import com.example.lucene.search.QueryBuilder;
import com.example.lucene.search.ResultRetriever;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*
import udd.lucene.model.AdvancedQuery;
import udd.lucene.model.RequiredHighlight;
import udd.lucene.model.ResultData;
import udd.lucene.model.SearchType;
import udd.lucene.model.SimpleQuery;
import udd.lucene.search.QueryBuilder;
import udd.lucene.search.ResultRetriever;
*/

@CrossOrigin(origins = "*")
@RestController
public class SearchController {

		@Autowired
		private ResultRetriever resultRetriever;


		//pretraga po nazivu casopisa
		@PostMapping(value="/search/nameMagazine", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchNameMagazine(@RequestBody SimpleQuery simpleQuery) throws Exception {
			System.out.println(" \n  Kontroler nameMagazine");
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);

			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
	
		//pretraga po naslovu
		@PostMapping(value="/search/title", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchTitle(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po imenima i prezimenima autora
		@PostMapping(value="/search/author", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchAuthor(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po kljucnim pojmovima
		@PostMapping(value="/search/keywords", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchKeywords(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po sadrzaju
		@PostMapping(value="/search/content", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchContent(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po naucnoj oblasti
		@PostMapping(value="/search/scientificField", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchScientificField(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po kombinaciji svih parametara pretrage
		@PostMapping(value="/search/combination", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchCombination(@RequestBody AdvancedQuery advancedQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query1 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField1(), advancedQuery.getValue1());
			org.elasticsearch.index.query.QueryBuilder query2 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField2(), advancedQuery.getValue2());
			org.elasticsearch.index.query.QueryBuilder query3 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField3(), advancedQuery.getValue3());
			org.elasticsearch.index.query.QueryBuilder query4 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField4(), advancedQuery.getValue4());
			org.elasticsearch.index.query.QueryBuilder query5 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField5(), advancedQuery.getValue5());
			org.elasticsearch.index.query.QueryBuilder query6 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField6(), advancedQuery.getValue6());
			
			BoolQueryBuilder builder = QueryBuilders.boolQuery();
			if(advancedQuery.getOperation().equalsIgnoreCase("AND")){
				builder.must(query1);
				builder.must(query2);
				builder.must(query3);
				builder.must(query4);
				builder.must(query5);
				builder.must(query6);
			}else if(advancedQuery.getOperation().equalsIgnoreCase("OR")){
				builder.should(query1);
				builder.should(query2);
				builder.should(query3);
				builder.should(query4);
				builder.should(query5);
				builder.should(query6);
			}
			
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(advancedQuery.getField1(), advancedQuery.getValue1()));
			rh.add(new RequiredHighlight(advancedQuery.getField2(), advancedQuery.getValue2()));
			rh.add(new RequiredHighlight(advancedQuery.getField3(), advancedQuery.getValue3()));
			rh.add(new RequiredHighlight(advancedQuery.getField4(), advancedQuery.getValue4()));
			rh.add(new RequiredHighlight(advancedQuery.getField5(), advancedQuery.getValue5()));
			rh.add(new RequiredHighlight(advancedQuery.getField6(), advancedQuery.getValue6()));
			List<ResultData> results = resultRetriever.getResults(builder, rh);		
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}

}
