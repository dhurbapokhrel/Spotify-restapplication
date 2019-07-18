package com.spotify.Dtos;

public class AlbumDto {
	private Long id;
	private String name;
	private Integer year;
	private Long albumCover;
	
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
	public Long getAlbumCover() {
		return albumCover;
	}
	public void setAlbumCover(Long albumCover) {
		this.albumCover = albumCover;
	}
	@Override
	public String toString() {
		return "AlbumDto [id=" + id + ", name=" + name + ", year=" + year + ", albumCover=" + albumCover + "]";
	}
	
	
	
}
