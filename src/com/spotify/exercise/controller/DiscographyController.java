package com.spotify.exercise.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spotify.exercise.resource.DiscographyResource;

@Controller
@RequestMapping("/discography")
public class DiscographyController 
{
	@Autowired
	DiscographyResource discographyService;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Response findDiscography(@PathVariable("name")String artistName) 
	{
		return discographyService.findDiscography(artistName);
	}
}