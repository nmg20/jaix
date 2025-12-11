package com.nmg20.jaix.model.track;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "track")
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String artist;
	private String album;
	private LocalDateTime releaseDate;
	private Double duration;
	private String route;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "info_id")
	private TrackInfo info;
	
	public Track() {
	}
	
	public Track(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.artist = builder.artist;
		this.album = builder.album;
		this.releaseDate = builder.releaseDate;
		this.duration = builder.duration;
		this.route = builder.route;
		this.info = builder.info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public TrackInfo getInfo() {
		return info;
	}

	public void setInfo(TrackInfo info) {
		this.info = info;
	}
	
	public class Builder {
		private Long id;
		private String title;
		private String artist;
		private String album;
		private String route;
		private LocalDateTime releaseDate;
		private Double duration;
		private TrackInfo info;
		
		public Long getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getArtist() {
			return artist;
		}

		public String getAlbum() {
			return album;
		}

		public String getRoute() {
			return route;
		}

		public LocalDateTime getReleaseDate() {
			return releaseDate;
		}

		public Double getDuration() {
			return duration;
		}

		public TrackInfo getInfo() {
			return info;
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder artist(String artist) {
			this.artist = artist;
			return this;
		}
		
		public Builder album(String album) {
			this.album = album;
			return this;
		}
		
		public Builder route(String route) {
			this.route = route;
			return this;
		}
		
		public Builder releaseDate(LocalDateTime releaseDate) {
			this.releaseDate = releaseDate;
			return this;
		}
		
		public Builder duration(Double duration) {
			this.duration = duration;
			return this;
		}
		
		public Builder info(TrackInfo info) {
			this.info = info;
			return this;
		}
		
		public Track build() {
			Track track = new Track();
			track.setId(getId());
			track.setTitle(getTitle());
			track.setArtist(getArtist());
			track.setAlbum(getAlbum());
			track.setRoute(getRoute());
			track.setInfo(getInfo());
			return track;
		}
		
	}
}
