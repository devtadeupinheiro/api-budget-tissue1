package dev.tadeupinheiro.apibudgettissue.repository;

import dev.tadeupinheiro.apibudgettissue.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Integer> {
}
