package com.example.club.repository;

import com.example.club.domain.MartialArt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MartialArtRepo extends JpaRepository<MartialArt, Long> {
}
