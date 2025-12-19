package com.nmg20.jaix.service.playlistSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nmg20.jaix.model.track.Track;

@Component
public class LocalPlaylistSource implements PlaylistSource {

	@Override
	public boolean supportsInput(String input) {
		try {
			return Files.isDirectory(Path.of(input));
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Track> loadTracks(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
