package com.cue.personajesservice.controller;

import com.cue.personajesservice.dto.PersonajeDetalleResponse;
import com.cue.personajesservice.dto.PersonajeRequest;
import com.cue.personajesservice.dto.PersonajeResponse;
import com.cue.personajesservice.service.PersonajeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    private final PersonajeService service;

    public PersonajeController(PersonajeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PersonajeResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{id}/detalle")
    public ResponseEntity<PersonajeDetalleResponse> getDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDetalleById(id));
    }

    @PostMapping
    public ResponseEntity<PersonajeResponse> create(@Valid @RequestBody PersonajeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeResponse> update(@PathVariable Long id, @Valid @RequestBody PersonajeRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
