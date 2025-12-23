package com.nmg20.jaix.model.playlist;

import java.util.List;

import com.nmg20.jaix.model.track.Track;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	private String route;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "playlist_id")
	private List<Track> tracks;
	
	public Playlist() {
	}
	
	public Playlist(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.route = builder.route;
		this.tracks = builder.tracks;
	}
	
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

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public Builder builder() {
		return new Builder();
	}
	
	public class Builder {
		private Long id;
		private String name;
		private String route;
		private List<Track> tracks;
		
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public String getRoute() {
			return route;
		}
		
		public List<Track> getTracks() {
			return tracks;
		}
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder tracks(List<Track> tracks) {
			this.tracks = tracks;
			return this;
		}
		
		public Playlist build() {
			Playlist playlist = new Playlist();
			playlist.setId(getId());
			playlist.setName(getName());
			playlist.setRoute(getRoute());
			playlist.setTracks(getTracks());
			return playlist;
		}
		
	}
}
