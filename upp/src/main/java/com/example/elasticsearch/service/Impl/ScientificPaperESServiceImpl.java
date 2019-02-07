package com.example.elasticsearch.service.Impl;

import com.example.elasticsearch.model.ScientificPaperES;
import com.example.elasticsearch.service.ScientificPaperESService;
import org.springframework.stereotype.Service;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ScientificPaperESServiceImpl implements ScientificPaperESService {



    @Autowired
    private ElasticsearchTemplate elasticSearchTemplate;

    @Override
    public List<ScientificPaperES> searchByOneField(String field, String value) {

        List<ScientificPaperES> resultsList = new ArrayList<>();

        System.out.println("Service..." + field + value);

        HighlightBuilder hb = new HighlightBuilder();
        hb.field("name");

        SearchResponse response = elasticSearchTemplate.getClient().prepareSearch("scientificpaper").highlighter(hb)
                .setQuery(QueryBuilders.matchQuery(field, value)).get();

        System.out.println(response);

        for (SearchHit o : response.getHits()) {

            ObjectMapper objectMapper = new ObjectMapper();
            ScientificPaperES result = null;

            try {
                result = objectMapper.readValue(o.getSourceAsString(), ScientificPaperES.class);
                resultsList.add(result);
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultsList;
    }
}
