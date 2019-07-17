package com.spotify.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spotify.Dtos.ArtistDto;
import com.spotify.entities.ArtistEntity;

@Repository
public class ArtistRepository {

	private EntityManager enityManager;

	public EntityManager getEnityManager() {
		return enityManager;
	}

	@PersistenceContext
	public void setEnityManager(EntityManager enityManager) {
		this.enityManager = enityManager;
	}

	@Transactional
	public void save(ArtistEntity artistEntity) {
		enityManager.persist(artistEntity);

	}

	@Transactional
	public List<ArtistEntity> getAllArtists() {
		Query query = enityManager.createQuery("SELECT a from ArtistEntity a");
		List<ArtistEntity> artists = query.getResultList();
		return artists;
	}

	@Transactional
	public ArtistEntity getArtistById(Long Id) {
		ArtistEntity artist = enityManager.find(ArtistEntity.class, Id);
		Query query = enityManager.createQuery("SELECT a from ArtistEntity a where Id=:Id");
		if (artist == null) {
			throw new EntityNotFoundException("Can't find Artist for ID " + Id);
		}
		return artist;
	}

	@Transactional
	public ArtistEntity getArtistByName(String name) {
		
		Query query = enityManager.createQuery("SELECT a from ArtistEntity a where a.name=:a.name");
		query.setParameter("a.name", name);
		ArtistEntity artistEntity= (ArtistEntity) query.getSingleResult();
		return artistEntity;
	}
		
	


}
