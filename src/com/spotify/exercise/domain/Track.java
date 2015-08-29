package com.spotify.exercise.domain;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties({"artists", "explicit", "external_urls", "href",
	"is_playable", "preview_url", "type", "uri"})
public class Track 
{
	private String id;
	private String name;
	private String trackNumber;
	private String discNumber;
	private String durationMs;
	
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
	
	/**
	 * 
	 * @return
	 */
	@JsonProperty("track_number")
	public String getTrackNumber(){
		return this.trackNumber;
	}
	
	/**
	 * 
	 * @param value
	 */
	@JsonProperty("track_number")
	public void setTrackNumber(String value){
		this.trackNumber = value;
	}
	
	/**
	 * 
	 * @return
	 */
	@JsonProperty("disc_number")
	public String getDiscNumber(){
		return this.discNumber;
	}
	
	/**
	 * 
	 * @param value
	 */
	@JsonProperty("disc_number")
	public void setDiscNumber(String value){
		this.discNumber = value;
	}
	
	/**
	 * 
	 * @return
	 */
	@JsonProperty("duration_ms")
	public String getDuration(){
		return this.durationMs;
	}
	
	/**
	 * 
	 * @param value
	 */
	@JsonProperty("duration_ms")
	public void setDuration(String value){
		this.durationMs = value;
	}
}
