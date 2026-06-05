package br.com.joao.artistregistration.repository;

import br.com.joao.artistregistration.main.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
