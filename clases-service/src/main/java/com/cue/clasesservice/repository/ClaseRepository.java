package com.cue.clasesservice.repository;

import com.cue.clasesservice.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
}
