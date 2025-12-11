package com.nmg20.jaix.service.track;

import java.util.List;
import java.util.Optional;

import com.nmg20.jaix.model.track.Track;
import com.nmg20.jaix.repository.track.TrackRepository;

public class TrackServiceImpl implements TrackService {

	private final TrackRepository trackRepository;
	
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}
	
	@Override
	public Optional<Track> findById(Long id) {
		return trackRepository.findById(id);
	}

	@Override
	public List<Track> findAll() {
		return trackRepository.findAll();
	}

	@Override
	public Track saveTrack(Track track) {
		return trackRepository.save(track);
	}

	@Override
	public void deleteTrack(Long id) {
		trackRepository.deleteById(id);
		
	}

}
