package com.spotify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spotify.Dtos.ArtistDto;
import com.spotify.services.ArtistService;



@RestController
@RequestMapping(value = "/artist")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void hello(@RequestBody ArtistDto artistDto) {
		artistService.saveArtist(artistDto);
	}
	
	@RequestMapping(value ="", method= RequestMethod.GET)
	public List<ArtistDto> getArtists(){
		return artistService.getAllArtist();
	}
	
	@RequestMapping(value ="/id", method= RequestMethod.GET)
	public ArtistDto getArtistById(@RequestParam(value="artistId" )Long id, @RequestParam(required=false) String name){
		return artistService.getArtistById(id);
	}
	
	@RequestMapping(value="/Id/{Id}/", method= RequestMethod.GET)
	public ArtistDto getArtistDetailsById(@PathVariable("Id") Long id) {
		
		return artistService.getArtistById(id);
		
	}
	
	@RequestMapping(value="/name/{name}/", method= RequestMethod.GET)
	public ArtistDto getArtistDetailsByName(@PathVariable("name") String name) {
		
		return artistService.getArtistByName(name);
		
	}
}











//@Autowired
//private ArtistService artistService;
//
//@RequestMapping(value = "", method = RequestMethod.POST)
//public void hello(@RequestBody ArtistDto artistDto) {
//	artistService.saveArtist(artistDto);
//}
//
//@RequestMapping(value = "", method = RequestMethod.GET)
//public List<ArtistDto> getArtists() {
//	return artistService.getAllArtists();
//}
//
//// http://localhost:8000/spotify/artist/id?artistId=10&name=abinash
//@RequestMapping(value = "/id", method = RequestMethod.GET)
//public ArtistDto getArtistById(@RequestParam(value = "artistId") int id, @RequestParam(required= false) String name) {
//	return artistService.getAllArtistById(id);
//}
//
//// http://localhost:8000/spotify/artist/id/60/details
//@RequestMapping(value = "/id/{id}/details", method = RequestMethod.GET)
//public ArtistDto getArtistDetailsById(@PathVariable int id) {
//	return artistService.getAllArtistById(id);
//}
//}


