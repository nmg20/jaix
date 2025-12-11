package com.nmg20.jaix.service.track;

import java.util.List;
import java.util.Optional;

import com.nmg20.jaix.model.track.Track;

public interface TrackService {
	Optional<Track> findById(Long id);
	List<Track> findAll();
	Track saveTrack(Track track);
	void deleteTrack(Long id);
}
