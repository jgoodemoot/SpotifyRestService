package com.spotify.exercise.message;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.spotify.exercise.domain.Discography;

@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class DiscographyMessage 
{
	private Discography discography;

	public DiscographyMessage(Discography discography) {
		this.discography = discography;
	}

	/**
	 * 
	 * @return
	 */
	public Discography getDiscography(){
		return this.discography;
	}	
}