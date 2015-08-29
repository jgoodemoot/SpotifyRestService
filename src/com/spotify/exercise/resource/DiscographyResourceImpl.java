package com.spotify.exercise.resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.stereotype.Service;

import com.spotify.exercise.domain.Album;
import com.spotify.exercise.domain.AlbumTracks;
import com.spotify.exercise.domain.Albums;
import com.spotify.exercise.domain.Artist;
import com.spotify.exercise.domain.Discography;
import com.spotify.exercise.domain.Tracks;
import com.spotify.exercise.message.DiscographyMessage;
import com.spotify.exercise.message.NoDiscographyMessage;
import com.spotify.exercise.service.SpotifyServiceClient;
import com.spotify.exercise.transform.SpotifyTransformer;

@Service("discography")
public class DiscographyResourceImpl implements DiscographyResource 
{
	@Autowired
	SpotifyServiceClient serviceClient;
	
	@Autowired
	SpotifyTransformer transformer;
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.exercise.resource.DiscographyResource#findDiscography(java.lang.String)
	 */
	public Response findDiscography(String artistName) 
	{
		Status status = Status.OK;
		Object responseMessage = null;
		
		Artist artist;
		try {
			artist = transformer.transformArtistSearchResult(
					serviceClient.findArtist(artistName), artistName);
			
			if(artist != null)
			{	
				Albums albums = transformer.transformArtistAlbums(
						serviceClient.findAlbumsForArtist(artist.getId()));
				
				Tracks tracks = null;
				List<AlbumTracks> albumTracks = new ArrayList<AlbumTracks>();
				
				for (Album album : albums.getItems())
				{
					tracks = transformer.transformAblumTracks(
							serviceClient.findTracksForAlbum(album.getId()));
					
					albumTracks.add(new AlbumTracks(
							album.getId(), album.getName(), tracks));
				}
				// construct the response
				responseMessage = new DiscographyMessage(
						new Discography(artist, albumTracks));
			} 
			else 
			{
				// return the no discography message
				status = Status.NOT_FOUND;
				responseMessage = new NoDiscographyMessage(artistName);
			}
		// return the no discography message			
		} catch (UnsupportedEncodingException e) {
			status = Status.INTERNAL_SERVER_ERROR;
			responseMessage = new NoDiscographyMessage(artistName);
		} catch (RestClientException e) {
			status = Status.BAD_REQUEST;
			responseMessage = new NoDiscographyMessage(artistName);
		} catch (JsonParseException e) {
			status = Status.INTERNAL_SERVER_ERROR;
			responseMessage = new NoDiscographyMessage(artistName);
		} catch (JsonMappingException e) {
			status = Status.INTERNAL_SERVER_ERROR;
			responseMessage = new NoDiscographyMessage(artistName);			
		} catch (IOException e) {
			status = Status.INTERNAL_SERVER_ERROR;
			responseMessage = new NoDiscographyMessage(artistName);
		} catch (Exception e) {
			status = Status.INTERNAL_SERVER_ERROR;
			responseMessage = new NoDiscographyMessage(artistName);
		} 
		
		return Response.status(status).entity(responseMessage).build();
	}
}