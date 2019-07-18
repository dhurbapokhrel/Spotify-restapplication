package com.spotify.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spotify.entities.AlbumEntity;

@Repository
@Transactional
public class AlbumRepository extends AbstractRepository{

	public void save(AlbumEntity albumEntity) {
		em.persist(albumEntity);
		
	}
	public void update(AlbumEntity albumEntity) {
		em.merge(albumEntity);
	}
	public AlbumEntity findById(Long Id) {
		return em.find(AlbumEntity.class,Id);
	}
}
