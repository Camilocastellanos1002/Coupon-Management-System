package riwi.lastfilter.spring.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riwi.lastfilter.spring.domain.entities.Coupon;


@Repository
public interface CoupontRepository  extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findById(Long id);
}