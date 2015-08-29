package com.spotify.exercise.resource;

import javax.ws.rs.core.Response;

public interface DiscographyResource 
{
	/**
	 * 
	 * @param name
	 * @return
	 */
	Response findDiscography(final String name);
}