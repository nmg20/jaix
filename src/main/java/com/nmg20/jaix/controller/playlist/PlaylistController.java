package com.nmg20.jaix.controller.playlist;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/parse")
	public ResponseEntity<List<Track>> parsePlaylist(@RequestParam String url) {
		List<Track> tracks = playlistService.parsePlaylist(url);
		return ResponseEntity.ok(tracks);
	}
	
	@PostMapping("/download")
	public ResponseEntity<String> downloadPlaylist(
			@RequestBody Collection<Track> tracks) {
		playlistService.downloadPlaylist(tracks);
		return ResponseEntity.ok("Descarga finalizada");
	}

}
