package com.spotify.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class AlbumEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="cover_image")
	private Long coverImage;
	
	@ManyToOne
	@JoinColumn(name="artistId", referencedColumnName = "id")
	private ArtistEntity artist;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Long coverImage) {
		this.coverImage = coverImage;
	}

	public ArtistEntity getArtist() {
		return artist;
	}

	public void setArtists(ArtistEntity artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "AlbumEntity [id=" + id + ", name=" + name + ", year=" + year + ", coverImage=" + coverImage
				+ ", artist=" + artist + "]";
	}
	
	
}



