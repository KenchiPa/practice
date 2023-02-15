package com.practice.hrp.repository;

import com.practice.hrp.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {
}
