package dev.tadeupinheiro.apibudgettissue.repository;

import dev.tadeupinheiro.apibudgettissue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
