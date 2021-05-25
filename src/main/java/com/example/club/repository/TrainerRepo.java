package com.example.club.repository;

import com.example.club.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
}
