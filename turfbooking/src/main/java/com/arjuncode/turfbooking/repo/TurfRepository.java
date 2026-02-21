package com.arjuncode.turfbooking.repo;

import com.arjuncode.turfbooking.entity.Turf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurfRepository extends JpaRepository<Turf,Long> {
}
