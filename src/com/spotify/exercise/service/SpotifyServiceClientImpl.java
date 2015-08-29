package com.spotify.exercise.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpotifyServiceClientImpl implements SpotifyServiceClient 
{
    @Value("${search.url}")
    private String searchUrl;
    
    @Value("${album.url}")
    private String albumUrl;

    @Value("${track.url}")
    private String trackUrl;
    
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.sample.services.SpotifyServiceClient#findArtist(java.lang.String)
	 */
	public String findArtist(String artistName) throws UnsupportedEncodingException, RestClientException 
	{
		RestTemplate template = new RestTemplate();
		
		StringBuilder sbUrl = new StringBuilder(searchUrl);
		sbUrl.append("?q=name:");
		sbUrl.append(URLEncoder.encode(artistName, "UTF-8"));
		sbUrl.append("&type=artist");
		
		String result = template.getForObject(
				sbUrl.toString(), String.class);
		
		return result;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.sample.services.SpotifyServiceClient#findAlbumsForArtist(java.lang.String)
	 */
	public String findAlbumsForArtist(String artistId) throws RestClientException
	{
		RestTemplate template = new RestTemplate();
		
		StringBuilder sbUrl = new StringBuilder(albumUrl);
		sbUrl.append("?album_type=album");
		
		// defaults to limit of 10
		String result = template.getForObject(
				sbUrl.toString(), String.class, artistId);
		
		return result;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.spotify.sample.services.SpotifyServiceClient#findTracksForAlbum(java.lang.String)
	 */
	public String findTracksForAlbum(String albumId) throws RestClientException
	{
		RestTemplate template = new RestTemplate();
		
		String result = template.getForObject(
				trackUrl, String.class, albumId);
		
		return result;
	}
}