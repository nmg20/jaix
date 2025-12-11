package com.nmg20.jaix.service.playlist;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nmg20.jaix.model.track.Track;
import com.nmg20.jaix.provider.youtube.YoutubeProvider;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	private final YoutubeProvider youtubeProvider;
	
	public PlaylistServiceImpl(YoutubeProvider youtubeProvider) {
		this.youtubeProvider = youtubeProvider;
	}
	
	public List<Track> parsePlaylist(String playlistUrl) {
		return youtubeProvider.getPlaylistTracks(playlistUrl);
	}

	@Override
	public void downloadPlaylist(Collection<Track> tracks) {
		youtubeProvider.downloadSelectedTracks(tracks);
	}
}
