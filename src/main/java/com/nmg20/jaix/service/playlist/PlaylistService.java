package com.nmg20.jaix.service.playlist;

import java.util.Collection;
import java.util.List;

import com.nmg20.jaix.model.track.Track;

public interface PlaylistService {

	List<Track> parsePlaylist(String playlistUrl);
	
	void downloadPlaylist(Collection<Track> tracks);
}