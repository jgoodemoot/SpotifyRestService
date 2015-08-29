package com.spotify.exercise.transform;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.spotify.exercise.domain.Albums;
import com.spotify.exercise.domain.Artist;
import com.spotify.exercise.domain.Tracks;

public interface SpotifyTransformer 
{

	/**
	 * 
	 * @param result
	 * @param searchKey
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Artist transformArtistSearchResult(String result, String searchKey) 
			throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Albums transformArtistAlbums(String result) 
			throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Tracks transformAblumTracks(String result) 
			throws JsonParseException, JsonMappingException, IOException;	
}