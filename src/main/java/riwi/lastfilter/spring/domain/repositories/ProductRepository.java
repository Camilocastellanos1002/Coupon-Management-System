package riwi.lastfilter.spring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import riwi.lastfilter.spring.domain.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
    
}
