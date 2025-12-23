package com.nmg20.jaix.service.playlistSource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
		File playlistFolder = new File(input);
		List<Track> tracks = new ArrayList<>();
		for (File file : playlistFolder.listFiles()) {
			if (file.isFile() && isFormatSupported(file)) {
				Track track = new Track.Builder()
						.title(trimFormat(file.getName()))
						.route(file.getAbsolutePath())
						.build();
				tracks.add(track);
			}
			// TODO: Recursividad
		}
		return tracks;
	}
	
	private boolean isFormatSupported(File file) {
		String fileName = file.getName();
		return fileName.endsWith(".mp3") || fileName.endsWith(".wav") || fileName.endsWith(".flac");
	}
	
	private String trimFormat(String fileName) {
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			return fileName.substring(0,i);
		}
		return fileName;
	}

}
