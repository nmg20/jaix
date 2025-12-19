package com.nmg20.jaix.service.playlistSource;

import java.util.List;

import com.nmg20.jaix.model.track.Track;

public interface PlaylistSource {
	boolean supportsInput(String input);
	List<Track> loadTracks(String input);
}
