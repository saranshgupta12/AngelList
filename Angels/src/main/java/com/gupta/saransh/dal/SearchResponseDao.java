package com.gupta.saransh.dal;

import java.util.List;

import org.hibernate.*;

import com.gupta.saransh.models.SearchResponse;
import com.gupta.saransh.models.SearchResponseWrapper;

public class SearchResponseDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveToDB(SearchResponse searchResponse){
		Session session =  this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(searchResponse);
		tx.commit();
		session.close();
	}
	
	public void saveToDB(SearchResponseWrapper searchResponseWrapper){
		Session session =  this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for( SearchResponse searchResponse: searchResponseWrapper.getSearchResponseList()){
			session.saveOrUpdate(searchResponse);
		}
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public SearchResponseWrapper getUserList(){
		Session session =  this.sessionFactory.openSession();
		SearchResponseWrapper searchResponseWrapper = new SearchResponseWrapper();
		searchResponseWrapper.setSearchResponseList((List<SearchResponse>)session.createQuery("from SearchResponse").list());
		return searchResponseWrapper;
	}

	
}
