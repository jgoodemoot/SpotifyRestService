package com.spotify.exercise.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface SpotifyServiceClient 
{
	/**
	 * 
	 * @param artistName
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String findArtist(String artistName) throws UnsupportedEncodingException;
	
	/**
	 * 
	 * @param artistId
	 * @return
	 */
	public String findAlbumsForArtist(String artistId);
	
	/**
	 * 
	 * @param albumId
	 * @return
	 */
	public String findTracksForAlbum(String albumId);
}
