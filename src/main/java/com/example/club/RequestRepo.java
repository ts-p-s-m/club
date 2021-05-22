package com.example.club;

import com.example.club.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request, Long> {
}

//репозиторий позволяет из кода работать с операциями внутри бд.
