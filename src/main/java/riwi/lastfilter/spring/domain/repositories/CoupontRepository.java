package riwi.lastfilter.spring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import riwi.lastfilter.spring.domain.entities.Coupon;

public interface CoupontRepository  extends JpaRepository<Coupon, Long> {
    
}