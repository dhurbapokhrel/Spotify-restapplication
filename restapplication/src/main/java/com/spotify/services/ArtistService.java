package com.spotify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotify.Dtos.ArtistDto;
import com.spotify.entities.ArtistEntity;
import com.spotify.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	public void saveArtist(ArtistDto artistDto) {
		ArtistEntity artistEntity= new ArtistEntity();
		artistEntity.setName(artistDto.getName());
		artistEntity.setGenre(artistDto.getGenre());
		artistEntity.setEmail(artistDto.getEmail());
		artistEntity.setCountry(artistDto.getCountry());
		
		artistRepository.save(artistEntity);
		
		
	}
	
	
	public List<ArtistDto> getAllArtist(){
		List<ArtistEntity>artistEntity=artistRepository.getAllArtists();
		List<ArtistDto>artistDtos= new ArrayList<ArtistDto>();
	
		for(ArtistEntity artist:artistEntity) {
			ArtistDto ar = new ArtistDto();
			ar.setName(artist.getName());
			ar.setGenre(artist.getGenre());
			ar.setEmail(artist.getEmail());
			ar.setCountry(artist.getCountry());
			
			artistDtos.add(ar);
			
		}	
		
		return artistDtos;
	}
	
	public ArtistDto getArtistById(Long Id){
		
		ArtistEntity ar= artistRepository.getArtistById(Id);
		ArtistDto dummy= new ArtistDto();
		dummy.setName(ar.getName());
		dummy.setGenre(ar.getGenre());
		dummy.setEmail(ar.getEmail());
		dummy.setCountry(ar.getCountry());
		
		
		return dummy;
	}
	
	public ArtistDto getArtistByName(String name){
		
		ArtistEntity ar= artistRepository.getArtistByName(name);
		ArtistDto dummy= new ArtistDto();
		dummy.setName(ar.getName());
		dummy.setGenre(ar.getGenre());
		dummy.setEmail(ar.getEmail());
		dummy.setCountry(ar.getCountry());
		
		
		return dummy;
	}
}
