package com.nmg20.jaix.service.playlistSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.nmg20.jaix.model.track.Track;

public class LocalPlaylistSource implements PlaylistSource {

	@Override
	public boolean supportsInput(String input) {
		return Files.isDirectory(Path.of(input));
	}

	@Override
	public List<Track> loadTracks(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
