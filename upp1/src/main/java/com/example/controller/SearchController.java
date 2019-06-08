package com.example.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.example.lucene.indexing.filters.CyrillicLatinConverter;
import com.example.lucene.model.*;
import com.example.lucene.search.QueryBuilder;
import com.example.lucene.search.ResultRetriever;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
			//String konvertovan = CyrillicLatinConverter.cir2lat(simpleQuery.getValue().toLowerCase());
			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());

			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), zameniKarakter(simpleQuery.getValue()));

			System.out.println(" \n  Kontroler nameMagazine");
			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);

			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
	
		//pretraga po naslovu
		@PostMapping(value="/search/title", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchTitle(@RequestBody SimpleQuery simpleQuery) throws Exception {
			//String konvertovan = CyrillicLatinConverter.cir2lat(simpleQuery.getValue().toLowerCase());
			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), zameniKarakter(simpleQuery.getValue()));

			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po imenima i prezimenima autora
		@PostMapping(value="/search/author", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchAuthor(@RequestBody SimpleQuery simpleQuery) throws Exception {
			//String konvertovan = CyrillicLatinConverter.cir2lat(simpleQuery.getValue().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), zameniKarakter(simpleQuery.getValue()));

			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po kljucnim pojmovima
		@PostMapping(value="/search/keywords", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchKeywords(@RequestBody SimpleQuery simpleQuery) throws Exception {
			//String konvertovan = CyrillicLatinConverter.cir2lat(simpleQuery.getValue().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), zameniKarakter(simpleQuery.getValue()));

			//	org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po sadrzaju
		@PostMapping(value="/search/content", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchContent(@RequestBody SimpleQuery simpleQuery) throws Exception {
			//String konvertovan = CyrillicLatinConverter.cir2lat(simpleQuery.getValue().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), zameniKarakter(simpleQuery.getValue()));

			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}
		
		//pretraga po naucnoj oblasti
		@PostMapping(value="/search/scientificField", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchScientificField(@RequestBody SimpleQuery simpleQuery) throws Exception {
			//String konvertovan = CyrillicLatinConverter.cir2lat(simpleQuery.getValue().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), zameniKarakter(simpleQuery.getValue()));

			//org.elasticsearch.index.query.QueryBuilder query=QueryBuilders.matchQuery(simpleQuery.getField(), simpleQuery.getValue());
			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
			List<ResultData> results = resultRetriever.getResults(query, rh);
			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
		}

	@PostMapping(value="/search/moreLikeThis", consumes="application/json")
	public ResponseEntity<List<ResultData>> moreLikeThis(@RequestBody SimpleQuery simpleQuery) {
		String tekstRada = simpleQuery.getValue();
		List<ResultData> results = new ArrayList<ResultData>();

		//tekst koji se trazi u ostalim radovima
		String searchArray[] = { tekstRada };
		String [] array = {"AA","BB","CC" };
		//text iz IndexUnit-a
		String fields[] = { "text" };

		MoreLikeThisQueryBuilder.Item[] items = { new MoreLikeThisQueryBuilder.Item("digitallibrary", "book", "filename") };
		MoreLikeThisQueryBuilder qb = QueryBuilders.moreLikeThisQuery( );

		return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
	}


		//pretraga po kombinaciji svih parametara pretrage
		@PostMapping(value="/search/combination", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchCombination(@RequestBody AdvancedQuery advancedQuery) throws Exception {
			//String konvertovan1 = CyrillicLatinConverter.cir2lat(advancedQuery.getValue1().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query1 = QueryBuilders.matchQuery(advancedQuery.getField1(), zameniKarakter(advancedQuery.getValue1()));
			//org.elasticsearch.index.query.QueryBuilder query1 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField1(), advancedQuery.getValue1());
			//String konvertovan2 = CyrillicLatinConverter.cir2lat(advancedQuery.getValue2().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query2 = QueryBuilders.matchQuery(advancedQuery.getField2(), zameniKarakter(advancedQuery.getValue2()));
			//org.elasticsearch.index.query.QueryBuilder query2 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField2(), advancedQuery.getValue2());
		//	String konvertovan3 = CyrillicLatinConverter.cir2lat(advancedQuery.getValue3().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query3 = QueryBuilders.matchQuery(advancedQuery.getField3(), zameniKarakter(advancedQuery.getValue3()));
			//org.elasticsearch.index.query.QueryBuilder query3 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField3(), advancedQuery.getValue3());
		//	String konvertovan4 = CyrillicLatinConverter.cir2lat(advancedQuery.getValue4().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query4 = QueryBuilders.matchQuery(advancedQuery.getField4(), zameniKarakter(advancedQuery.getValue4()));
			//org.elasticsearch.index.query.QueryBuilder query4 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField4(), advancedQuery.getValue4());
		//	String konvertovan5 = CyrillicLatinConverter.cir2lat(advancedQuery.getValue5().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query5 = QueryBuilders.matchQuery(advancedQuery.getField5(), zameniKarakter(advancedQuery.getValue5()));
			//org.elasticsearch.index.query.QueryBuilder query5 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField5(), advancedQuery.getValue5());
		//	String konvertovan6 = CyrillicLatinConverter.cir2lat(advancedQuery.getValue6().toLowerCase());
			org.elasticsearch.index.query.QueryBuilder query6 = QueryBuilders.matchQuery(advancedQuery.getField6(), zameniKarakter(advancedQuery.getValue6()));
			//org.elasticsearch.index.query.QueryBuilder query6 = QueryBuilder.buildQuery(SearchType.phrase, advancedQuery.getField6(), advancedQuery.getValue6());

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
	//konverzija
	public static String zameniKarakter(String text) {
		String text1 = text.toLowerCase();
		String text2 = CyrillicLatinConverter.cir2lat(text1);

		//latinica
		String text3 = text2.replaceAll("đ", "dj");
		String text4 = text3.replaceAll("č", "c");
		String text5 = text4.replaceAll("ć", "c");
		String text6 = text5.replaceAll("dž", "dz");
		String text7 = text6.replaceAll("š", "s");
		String text8 = text7.replaceAll("ž", "z");

		//cirilica
		String text9 = text8.replaceAll("ђ", "dj");
		String text10 = text9.replaceAll("љ", "lj");
		String text11 = text10.replaceAll("њ", "nj");
		String text12 = text11.replaceAll("dj", "d");

		return text12;
	}
}
