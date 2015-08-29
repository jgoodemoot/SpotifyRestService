package com.spotify.exercise.domain;

public class AlbumTracks 
{
	private String id;
	private String name;
	private Tracks tracks;
	
	public AlbumTracks(String id, String name, Tracks tracks)
	{
		this.id = id;
		this.name = name;
		this.tracks = tracks;
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
	 * @return
	 */
	public String getName(){
		return this.name;
	}	
	
	/**
	 * 
	 * @return
	 */
	public Tracks getTracks(){
		return this.tracks;
	}
}