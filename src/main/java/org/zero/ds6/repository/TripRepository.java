package org.zero.ds6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zero.ds6.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}