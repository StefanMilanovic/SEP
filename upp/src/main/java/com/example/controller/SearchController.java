package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.lucene.search.ResultRetriever;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
public class SearchController {

		@Autowired
		private ResultRetriever resultRetriever;
	
		/*@PostMapping(value="/search/term", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchTermQuery(@RequestBody SimpleQuery simpleQuery) throws Exception {		
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.regular, simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);			
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		@PostMapping(value="/search/fuzzy", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchFuzzy(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.fuzzy, simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);			
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		@PostMapping(value="/search/prefix", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchPrefix(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.prefix, simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);			
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		@PostMapping(value="/search/range", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchRange(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.range, simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);			
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		@PostMapping(value="/search/phrase", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchPhrase(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);			
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		@PostMapping(value="/search/boolean", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchBoolean(@RequestBody AdvancedQuery advancedQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query1 = QueryBuilder.buildQuery(SearchType.regular, advancedQuery.getField1(), advancedQuery.getValue1());
			org.elasticsearch.index.query.QueryBuilder query2 = QueryBuilder.buildQuery(SearchType.regular, advancedQuery.getField2(), advancedQuery.getValue2());
			
			BoolQueryBuilder builder = QueryBuilders.boolQuery();
			if(advancedQuery.getOperation().equalsIgnoreCase("AND")){
				builder.must(query1);
				builder.must(query2);
			}else if(advancedQuery.getOperation().equalsIgnoreCase("OR")){
				builder.should(query1);
				builder.should(query2);
			}else if(advancedQuery.getOperation().equalsIgnoreCase("NOT")){
				builder.must(query1);
				builder.mustNot(query2);
			}
			
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(advancedQuery.getField1(), advancedQuery.getValue1()));
			rh.add(new RequiredHighlight(advancedQuery.getField2(), advancedQuery.getValue2()));
			List<ResultData> results = resultRetriever.getResults(builder, rh);			
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		@PostMapping(value="/search/queryParser", consumes="application/json")
		public ResponseEntity<List<ResultData>> search(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.queryStringQuery(simpleQuery.getValue());			
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}*/
		//BOJ
		/*
		//pretraga po nazivu casopisa
		@PostMapping(value="/search/nazivCasopisa", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchNazivCasopisa(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
	
		//pretraga po naslovu
		@PostMapping(value="/search/naslov", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchNaslovRada(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po imenima i prezimenima autora
		@PostMapping(value="/search/autor", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchAutor(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po kljucnim pojmovima
		@PostMapping(value="/search/kljucniPojmovi", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchKljucniPojmovi(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po sadrzaju
		@PostMapping(value="/search/sadrzaj", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchSadrzaj(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po naucnoj oblasti
		@PostMapping(value="/search/naucnaOblast", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchNaucnaOblast(@RequestBody SimpleQuery simpleQuery) throws Exception {
			org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());		
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po kombinaciji svih parametara pretrage
		@PostMapping(value="/search/kombinovanaPretraga", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchKombinovanaPretraga(@RequestBody AdvancedQuery advancedQuery) throws Exception {
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
		*/
}
