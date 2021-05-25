package com.example.club.repository;

import com.example.club.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepo extends JpaRepository<Picture, Long> {
}
