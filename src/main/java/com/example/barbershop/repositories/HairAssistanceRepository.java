package com.example.barbershop.repositories;

import com.example.barbershop.entities.HairAssistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairAssistanceRepository extends JpaRepository<HairAssistance, Long> {
}
