package org.taohansen.tp3infnet_spring.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.taohansen.tp3infnet_spring.dto.CursoDTO;
import org.taohansen.tp3infnet_spring.entities.Curso;
import org.taohansen.tp3infnet_spring.repositories.CursoRepository;
import org.taohansen.tp3infnet_spring.services.exceptions.DatabaseException;
import org.taohansen.tp3infnet_spring.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "cursos")
public class CursoService {
    @Autowired
    private CursoRepository repository;


    @Transactional(readOnly = true)
    @Cacheable
    public List<CursoDTO> findAll() {
        List<Curso> list = repository.findAll();
        return list.stream().map(CursoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    @Cacheable(key="#id")
    public CursoDTO findById(Long id) {
        Optional<Curso> obj = repository.findById(id);
        Curso entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Curso not found."));
        return new CursoDTO(entity);
    }

    @Transactional
    public CursoDTO insert(CursoDTO dto) {
        Curso entity = new Curso();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setCargaHoraria(dto.getCargaHoraria());
        entity = repository.save(entity);
        return new CursoDTO(entity);
    }

    @Transactional
    @CachePut(key="#id")
    public CursoDTO update(Long id, CursoDTO dto) {
        try {
            Curso entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setDescricao(dto.getDescricao());
            entity.setCargaHoraria(dto.getCargaHoraria());
            entity = repository.save(entity);
            return new CursoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @CacheEvict(key="#id")
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Curso id (" + id + ") not found.");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database Integrity Violation");
        }
    }

}
