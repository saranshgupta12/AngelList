/**
 * 
 */
package com.gupta.saransh.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
/**
 * @author Saransh
 *
 */

@JsonAutoDetect
public class SearchResponseWrapper {

	List<SearchResponse> searchResponseList;
	public List<SearchResponse> getSearchResponseList() {
		return searchResponseList;
	}
	public void setSearchResponseList(List<SearchResponse> searchResponseList) {
		this.searchResponseList = searchResponseList;
	}
	@Override
	public String toString() {
		return "SearchResponseWrapper [searchResponseList="
				+ searchResponseList + "]";
	}
	
}

