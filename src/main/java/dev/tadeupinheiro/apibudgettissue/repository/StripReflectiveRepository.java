package dev.tadeupinheiro.apibudgettissue.repository;

import dev.tadeupinheiro.apibudgettissue.model.StripReflectiveConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StripReflectiveRepository extends JpaRepository<StripReflectiveConsumption, Integer> {
}
