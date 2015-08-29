package com.spotify.exercise.message;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class NoDiscographyMessage 
{
	private String artistName;
	private String message = "No discography located for %s.";
	
	public NoDiscographyMessage(String artistName) 
	{
		this.artistName = artistName;
		this.message = String.format(this.message, artistName);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getArtistName(){
		return this.artistName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMessage(){
		return this.message;
	}
}