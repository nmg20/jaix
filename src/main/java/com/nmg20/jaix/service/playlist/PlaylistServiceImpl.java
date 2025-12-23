package com.nmg20.jaix.service.playlist;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nmg20.jaix.model.track.Track;
import com.nmg20.jaix.service.playlistSource.PlaylistSource;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	private List<PlaylistSource> playlistSources;
	
	public PlaylistServiceImpl(List<PlaylistSource> playlistSources) {
		this.playlistSources = playlistSources;
	}
	
	public List<Track> parsePlaylist(String playlistPath) {
		PlaylistSource playlistSource = this.playlistSources.stream()
				.filter(source -> source.supportsInput(playlistPath))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Servicio no disponible"));
		
		return playlistSource.loadTracks(playlistPath);
	}

	@Override
	public void downloadPlaylist(Collection<Track> tracks) {
//		youtubeProvider.downloadSelectedTracks(tracks);
	}
	
}
