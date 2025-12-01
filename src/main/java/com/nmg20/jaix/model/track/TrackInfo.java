package com.nmg20.jaix.model.track;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrackInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float bpm;
    private String musicKey;
    
    public TrackInfo(Long id, float bpm, String musicKey) {
		super();
		this.id = id;
		this.bpm = bpm;
		this.musicKey = musicKey;
	}
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public float getBpm() {
		return bpm;
	}
	
	public void setBpm(float bpm) {
		this.bpm = bpm;
	}
	
	public String getMusicKey() {
		return musicKey;
	}
	public void setMusicKey(String musicKey) {
		this.musicKey = musicKey;
	}
	
    
}
