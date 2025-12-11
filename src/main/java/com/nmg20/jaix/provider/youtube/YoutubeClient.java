package com.nmg20.jaix.provider.youtube;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nmg20.jaix.dto.track.DownloadTrackDTO;
import com.nmg20.jaix.dto.track.ExternalTrackDTO;

@Component
public class YoutubeClient {

	private final WebClient webClient;
	private final String baseUrl;
	
	public YoutubeClient(WebClient.Builder webClientBuilder) {
		this.baseUrl = "http://127.0.0.1:8000";
		this.webClient = webClientBuilder.baseUrl(baseUrl).build();
	}
	
	public List<ExternalTrackDTO> parsePlaylist(String playlistUrl) {
	    try {
	    	String listId = extractPlaylistId(playlistUrl);
	    	String url = baseUrl + "/playlists/parse?id=" + listId;

	        return webClient.get()
	        		.uri(url)
	        		.retrieve()
	        		.bodyToFlux(ExternalTrackDTO.class)
	        		.collectList()
	        		.block();
	    } catch (Exception e) {
	        throw new RuntimeException("Error al parsear la URL :(", e);
	    }
	}
	
	public void downloadSelectedTracks(Collection<DownloadTrackDTO> downloadTracks) {
		try {
			webClient.post()
				.uri("/playlists/download/")
				.bodyValue(downloadTracks)
				.retrieve()
				.toBodilessEntity()
				.block();
		} catch (Exception e) {
			throw new RuntimeException("Error al descargar temas :(");
		}
	}
	
	public String extractPlaylistId(String playlistUrl) {
	    try {
	        URI uri = new URI(playlistUrl);
	        String query = uri.getQuery(); // v=W-UepwIyHfc&list=PLR-pSqh8ddm3FQM_eMiCfXqTwDK8qLRMt
	        for (String param : query.split("&")) {
	            String[] pair = param.split("=");
	            if (pair.length == 2 && pair[0].equals("list")) {
	                return pair[1];
	            }
	        }
	    } catch (URISyntaxException e) {
	        throw new RuntimeException("URL inválida: " + playlistUrl, e);
	    }
	    return null;
	}



}
