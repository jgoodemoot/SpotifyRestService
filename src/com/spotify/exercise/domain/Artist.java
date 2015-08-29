package com.spotify.exercise.domain;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties({"external_urls", "followers", "genres", "href",
	"images", "popularity", "type", "uri"})
public class Artist 
{
	private String name;
	private String id;
	
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setName(String value){
		this.name = value;
	}
	
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
}
