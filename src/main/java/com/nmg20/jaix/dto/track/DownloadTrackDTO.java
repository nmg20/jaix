package com.nmg20.jaix.dto.track;

public class DownloadTrackDTO {

	private String title;
	private String url;
	
	public DownloadTrackDTO(String title, String url) {
		this.title = title;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}
