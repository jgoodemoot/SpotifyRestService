package com.spotify.exercise.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({"album_type", "available_markets", "external_urls", "href",
	"type", "images", "uri"})
public class Album 
{
	private String id;
	private String name;
	
	/**
	 * 
	 * @return
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setId(String value){
		this.id = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
}