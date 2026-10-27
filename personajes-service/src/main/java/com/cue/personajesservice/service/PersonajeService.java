package com.cue.personajesservice.service;

import com.cue.personajesservice.dto.*;
import com.cue.personajesservice.exception.InvalidClaseException;
import com.cue.personajesservice.exception.ResourceNotFoundException;
import com.cue.personajesservice.model.Personaje;
import com.cue.personajesservice.repository.PersonajeRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PersonajeService {

    private final PersonajeRepository repository;
    private final RestClient clasesRestClient;

    public PersonajeService(PersonajeRepository repository, RestClient clasesRestClient) {
        this.repository = repository;
        this.clasesRestClient = clasesRestClient;
    }

    public List<PersonajeResponse> findAll() {
        return repository.findAll().stream().map(PersonajeResponse::new).toList();
    }

    public PersonajeResponse findById(Long id) {
        Personaje personaje = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje not found with id: " + id));
        return new PersonajeResponse(personaje);
    }

    public PersonajeDetalleResponse findDetalleById(Long id) {
        Personaje personaje = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje not found with id: " + id));
        ClaseResponse clase = fetchClase(personaje.getClaseId());
        return new PersonajeDetalleResponse(personaje, clase);
    }

    public PersonajeResponse create(PersonajeRequest request) {
        validateClaseExists(request.getClaseId());
        Personaje personaje = new Personaje(
                request.getNombre(),
                request.getNivel(),
                request.getPuntosDeVida(),
                request.getClaseId()
        );
        return new PersonajeResponse(repository.save(personaje));
    }

    public PersonajeResponse update(Long id, PersonajeRequest request) {
        Personaje personaje = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje not found with id: " + id));
        validateClaseExists(request.getClaseId());
        personaje.setNombre(request.getNombre());
        personaje.setNivel(request.getNivel());
        personaje.setPuntosDeVida(request.getPuntosDeVida());
        personaje.setClaseId(request.getClaseId());
        return new PersonajeResponse(repository.save(personaje));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Personaje not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private void validateClaseExists(Long claseId) {
        try {
            fetchClase(claseId);
        } catch (Exception e) {
            throw new InvalidClaseException("Clase with id " + claseId + " does not exist in clases-service");
        }
    }

    private ClaseResponse fetchClase(Long claseId) {
        return clasesRestClient.get()
                .uri("/api/clases/{id}", claseId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new InvalidClaseException("Clase with id " + claseId + " does not exist in clases-service");
                })
                .body(ClaseResponse.class);
    }
}
