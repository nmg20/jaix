package com.nmg20.jaix.service.playlistSource;

import java.util.List;

import com.nmg20.jaix.model.track.Track;
import com.nmg20.jaix.provider.youtube.YoutubeProvider;

public class YoutubePlaylistSource implements PlaylistSource {

	private final YoutubeProvider youtubeProvider;
	
	public YoutubePlaylistSource(YoutubeProvider youtubeProvider) {
		this.youtubeProvider = youtubeProvider;
	}
	
	@Override
	public boolean supportsInput(String input) {
		return input.startsWith("http") && input.contains("youtube.com");
	}

	@Override
	public List<Track> loadTracks(String input) {
		return youtubeProvider.getPlaylistTracks(input);
	}

}
