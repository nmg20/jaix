package com.nmg20.jaix.repository.trackinfo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nmg20.jaix.model.track.Track;

public interface TrackInfoRepository extends JpaRepository<Track, Long> {

}
