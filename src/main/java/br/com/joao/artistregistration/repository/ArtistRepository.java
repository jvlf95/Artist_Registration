package br.com.joao.artistregistration.repository;

import br.com.joao.artistregistration.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
