package br.com.joao.artistregistration.repository;

import br.com.joao.artistregistration.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    // JPQL
    @Query("SELECT s FROM Song s")
    List<Song> findAllSongs();

    @Query("SELECT s FROM Song s JOIN s.artist a WHERE a ILIKE :name")
    List<Song> findSongByArtist(String name);
}
