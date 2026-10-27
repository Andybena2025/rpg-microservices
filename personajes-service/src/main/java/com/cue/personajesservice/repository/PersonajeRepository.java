package com.cue.personajesservice.repository;

import com.cue.personajesservice.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
}
