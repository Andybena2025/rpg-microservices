package com.cue.clasesservice.service;

import com.cue.clasesservice.dto.ClaseRequest;
import com.cue.clasesservice.dto.ClaseResponse;
import com.cue.clasesservice.exception.ResourceNotFoundException;
import com.cue.clasesservice.model.Clase;
import com.cue.clasesservice.repository.ClaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    private final ClaseRepository repository;

    public ClaseService(ClaseRepository repository) {
        this.repository = repository;
    }

    public List<ClaseResponse> findAll() {
        return repository.findAll().stream().map(ClaseResponse::new).toList();
    }

    public ClaseResponse findById(Long id) {
        Clase clase = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clase not found with id: " + id));
        return new ClaseResponse(clase);
    }

    public ClaseResponse create(ClaseRequest request) {
        Clase clase = new Clase(
                request.getNombre(),
                request.getDescripcion(),
                request.getRolPrincipal(),
                request.getDadoDeVida()
        );
        return new ClaseResponse(repository.save(clase));
    }

    public ClaseResponse update(Long id, ClaseRequest request) {
        Clase clase = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clase not found with id: " + id));
        clase.setNombre(request.getNombre());
        clase.setDescripcion(request.getDescripcion());
        clase.setRolPrincipal(request.getRolPrincipal());
        clase.setDadoDeVida(request.getDadoDeVida());
        return new ClaseResponse(repository.save(clase));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Clase not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
