package com.nmg20.jaix.repository.track;

import org.springframework.data.jpa.domain.Specification;

import com.nmg20.jaix.model.track.Track;

public class TrackSpecification {

	private TrackSpecification() {
	}
	
	public static Specification<Track> hasTitle(String title) {
		return (root, query, cb) -> 
			title == null ? null : 
				cb.equal(
					cb.lower(
						root.get("title")), title.toLowerCase());
	}
	
	public static Specification<Track> hasArtist(String artist) {
		return (root, query, cb) -> 
			artist == null ? null : 
				cb.equal(
					cb.lower(
						root.get("artist")), artist.toLowerCase());
	}
	
	public static Specification<Track> hasAlbum(String album) {
		return (root, query, cb) -> 
			album == null ? null : 
				cb.equal(
					cb.lower(
						root.get("album")), album.toLowerCase());
	}
}
