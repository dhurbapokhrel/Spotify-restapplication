package com.spotify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotify.Dtos.AlbumDto;
import com.spotify.entities.AlbumEntity;
import com.spotify.entities.ArtistEntity;
import com.spotify.repositories.AlbumRepository;
import com.spotify.repositories.ArtistRepository;

@Service
public class AlbumService {
	
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private AlbumRepository albumRepository;
	
	public void creatAlbum(Long artistID,AlbumDto albumDto) {
		ArtistEntity artistEntity =artistRepository.getArtistById(artistID);
		
		if(artistEntity==null) {
			
			System.out.println("Artist Id not Found.");
		}else {
//			System.out.println(artistEntity.toString());
//			System.out.println(albumDto.toString());
			AlbumEntity albumEntity =convert(albumDto);
			if(albumEntity!=null) {
				albumEntity.setArtists(artistEntity);
				System.out.println("albumEntity: "+albumEntity.toString());
				albumRepository.save(albumEntity);
				
			}else {
				System.out.println("AlbumEntity is not null.");
			}
		}
		
	}

	private AlbumEntity convert(AlbumDto albumDto) {
		AlbumEntity album = null;
		if(albumDto!=null) {
			
			album=new AlbumEntity();
			album.setName(albumDto.getName());
			album.setYear(albumDto.getYear());
			album.setCoverImage(albumDto.getAlbumCover());
			
		}
		
		
		return album;
	}
}
