package com.nmg20.jaix.service.playlistSource;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nmg20.jaix.model.track.Track;
import com.nmg20.jaix.provider.youtube.YoutubeProvider;

@Component
public class YoutubePlaylistSource implements PlaylistSource {

	private final YoutubeProvider youtubeProvider;
	
	public YoutubePlaylistSource(YoutubeProvider youtubeProvider) {
		this.youtubeProvider = youtubeProvider;
	}
	
	@Override
	public boolean supportsInput(String input) {
		try {
			return input.startsWith("http") && input.contains("youtube.com");
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Track> loadTracks(String input) {
		return youtubeProvider.getPlaylistTracks(input);
	}

}
