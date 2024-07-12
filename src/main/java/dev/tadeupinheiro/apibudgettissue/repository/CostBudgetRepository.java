package dev.tadeupinheiro.apibudgettissue.repository;

import dev.tadeupinheiro.apibudgettissue.model.CostBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostBudgetRepository extends JpaRepository<CostBudget, Integer> {
}
