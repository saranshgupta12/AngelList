/**
 * 
 */
package com.gupta.saransh.services;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gupta.saransh.dal.SearchResponseDao;
import com.gupta.saransh.models.SearchResponse;
import com.gupta.saransh.models.SearchResponseWrapper;
import com.gupta.saransh.web.controllers.HomeController;
/**
 * Service class to query the AngelList API
 * @author Saransh
 * 
 */
@Service
public class SearchAngelList {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SearchResponseDao searchResponseDao;
	SearchResponseWrapper searchResponseWrapper = new SearchResponseWrapper();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public void setSearchResponseDao(SearchResponseDao searchResponseDao) {
		this.searchResponseDao = searchResponseDao;
	}

	public SearchResponseWrapper searchUsers(String query,String type) throws JsonParseException, IOException{

		String url = 	"https://api.angel.co/1/search?query={query}&type={type}";
		ArrayList<SearchResponse> searchResponseList = new ArrayList<SearchResponse>();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class,query,type);
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory jsonFactory  = new JsonFactory();
		JsonParser jsonParser = jsonFactory.createParser(responseEntity.getBody());		jsonParser.nextToken();
		while(jsonParser.nextToken() == JsonToken.START_OBJECT){
			searchResponseList.add(mapper.readValues(jsonParser, SearchResponse.class).next());
		}
		searchResponseWrapper.setSearchResponseList(searchResponseList);
		searchResponseDao.saveToDB(searchResponseWrapper);
		logger.info(searchResponseDao.getUserList().toString());
		return searchResponseWrapper;
	}
}
