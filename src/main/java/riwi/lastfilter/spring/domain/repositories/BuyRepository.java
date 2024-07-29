package riwi.lastfilter.spring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import riwi.lastfilter.spring.domain.entities.Buy;

public interface BuyRepository  extends JpaRepository<Buy, Long> {
    
}
