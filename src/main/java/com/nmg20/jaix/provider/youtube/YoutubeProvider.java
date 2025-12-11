package com.nmg20.jaix.provider.youtube;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nmg20.jaix.dto.track.DownloadTrackDTO;
import com.nmg20.jaix.dto.track.ExternalTrackDTO;
import com.nmg20.jaix.model.track.Track;

@Component
public class YoutubeProvider {

	private final YoutubeClient youtubeClient;
	
	public YoutubeProvider(YoutubeClient youtubeClient) {
		this.youtubeClient = youtubeClient;
	}
	
	public List<Track> getPlaylistTracks(String playlistUrl) {
		List<ExternalTrackDTO> externalTracks = youtubeClient.parsePlaylist(playlistUrl);
		return externalTracks.stream()
				.map(this::mapExternalTrackToTrack)
				.toList();
	}
	
	public void downloadSelectedTracks(Collection<Track> selectedTracks) {
		List<DownloadTrackDTO> downloadTracks = mapTracksToDownloadTracks(selectedTracks);
		youtubeClient.downloadSelectedTracks(downloadTracks);
	}
	
	private Track mapExternalTrackToTrack(ExternalTrackDTO externalTrack) {
		Track track = new Track();
		track.setTitle(externalTrack.getTitle());
		track.setArtist(externalTrack.getArtist());
		track.setAlbum(externalTrack.getAlbum());
		track.setDuration(externalTrack.getDuration());
		track.setRoute(externalTrack.getUrl());
		return track;
	}
	
	private List<DownloadTrackDTO> mapTracksToDownloadTracks(Collection<Track> tracks) {
		return tracks.stream()
				.map(this::mapTrackToDownloadTrack)
				.toList();
	}
	
	private DownloadTrackDTO mapTrackToDownloadTrack(Track track) {
		return new DownloadTrackDTO(track.getTitle(), track.getRoute());
	}
}
