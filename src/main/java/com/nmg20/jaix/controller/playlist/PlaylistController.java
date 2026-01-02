package com.nmg20.jaix.controller.playlist;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmg20.jaix.model.track.Track;
import com.nmg20.jaix.service.playlist.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
	
	private final PlaylistService playlistService;
	
	public PlaylistController(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	@PostMapping("/parse")
	public ResponseEntity<List<Track>> parsePlaylist(@RequestBody String playlistRoute) {
		List<Track> tracks = playlistService.parsePlaylist(playlistRoute);
		return ResponseEntity.ok(tracks);
	}
	
	@PostMapping("/download")
	public ResponseEntity<String> downloadPlaylist(
			@RequestBody Collection<Track> tracks) {
		playlistService.downloadPlaylist(tracks);
		return ResponseEntity.ok("Descarga finalizada");
	}

}
