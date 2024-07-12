package dev.tadeupinheiro.apibudgettissue.repository;

import dev.tadeupinheiro.apibudgettissue.model.StripReflectiveTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StripReflectiveTypesRepository extends JpaRepository<StripReflectiveTypes, Integer> {
}
