package com.nmg20.jaix.repository.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmg20.jaix.model.playlist.Playlist;

@Repository
public interface  PlaylistRepository  extends JpaRepository<Playlist, Long>{

}
