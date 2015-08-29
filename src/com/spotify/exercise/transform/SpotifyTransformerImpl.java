package com.spotify.exercise.transform;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.spotify.exercise.domain.Albums;
import com.spotify.exercise.domain.Artist;
import com.spotify.exercise.domain.Artists;
import com.spotify.exercise.domain.Tracks;

@Component
public class SpotifyTransformerImpl implements SpotifyTransformer 
{
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.exercise.transform.JsonTransformer#transformArtistSearchResult(java.lang.String, java.lang.String)
	 */
	public Artist transformArtistSearchResult(String result, String artistName)
			throws JsonParseException, JsonMappingException, IOException 
	{
		Artist artist = null;
		ObjectMapper mapper = new ObjectMapper();

		Artists artists = mapper.readValue(result, Artists.class);
			
		if(artists != null){
			for(Artist artistToCompare : artists.getItems()){
				if(artistToCompare.getName().equalsIgnoreCase(artistName)){
					artist = artistToCompare;
					break;
				}
			}
		}	
		return artist;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.exercise.transform.JsonTransformer#transformArtistAlbums(java.lang.String)
	 */
	public Albums transformArtistAlbums(String result)
			throws JsonParseException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		Albums albums = mapper.readValue(result, Albums.class);
		
		return albums;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.exercise.transform.JsonTransformer#transformAblumTracks(java.lang.String)
	 */
	public Tracks transformAblumTracks(String result)
			throws JsonParseException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		Tracks tracks = mapper.readValue(result, Tracks.class);
		
		return tracks;
	}
}