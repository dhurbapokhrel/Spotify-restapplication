package com.spotify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spotify.Dtos.AlbumDto;
import com.spotify.services.AlbumService;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public void creatAlbum(@RequestBody AlbumDto albumDto, @RequestParam Long ArtistId) {
		albumService.creatAlbum(ArtistId, albumDto);
		
		
	}

}
