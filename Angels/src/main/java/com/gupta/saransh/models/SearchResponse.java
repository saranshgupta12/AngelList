package com.gupta.saransh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect	
@Entity
@Table (name="SearchResponse")
public class SearchResponse{

@Id
@Column (name="id")
private String id;
private String pic;
private String url;
private String name;
private String type;

@Override
public String toString() {
	return "SearchResponse [id=" + id + ", pic=" + pic + ", url=" + url
			+ ", name=" + name + ", type=" + type + "]";
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}