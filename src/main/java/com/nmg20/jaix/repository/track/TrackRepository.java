package com.nmg20.jaix.repository.track;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmg20.jaix.model.track.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
