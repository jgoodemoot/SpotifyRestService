package com.spotify.exercise.domain;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class Discography 
{
	private Artist artist; 
	private List<AlbumTracks> discography;

	public Discography(Artist artist, List<AlbumTracks> discography)
	{
		this.artist = artist;
		this.discography = discography;
	}
	
	/**
	 * 
	 * @return
	 */
	public Artist getArtist(){
		return this.artist;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<AlbumTracks> getAlbumTracks(){
		return this.discography;
	}
}