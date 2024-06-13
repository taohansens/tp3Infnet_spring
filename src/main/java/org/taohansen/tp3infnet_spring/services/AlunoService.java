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
import org.taohansen.tp3infnet_spring.dto.AlunoDTO;
import org.taohansen.tp3infnet_spring.dto.CursoDTO;
import org.taohansen.tp3infnet_spring.entities.Aluno;
import org.taohansen.tp3infnet_spring.entities.Curso;
import org.taohansen.tp3infnet_spring.repositories.AlunoRepository;
import org.taohansen.tp3infnet_spring.repositories.CursoRepository;
import org.taohansen.tp3infnet_spring.services.exceptions.DatabaseException;
import org.taohansen.tp3infnet_spring.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "alunos")
public class AlunoService {
    @Autowired
    private AlunoRepository repository;
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    @Cacheable
    public List<AlunoDTO> findAll() {
        List<Aluno> list = repository.findAll();
        return list.stream()
                .map(aluno -> new AlunoDTO(aluno, aluno.getCursos()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(key="#id")
    public AlunoDTO findById(Long id) {
        Optional<Aluno> obj = repository.findById(id);
        Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Aluno not found."));
        return new AlunoDTO(entity, entity.getCursos());
    }

    @Transactional
    public AlunoDTO insert(AlunoDTO dto) {
        Aluno entity = new Aluno();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AlunoDTO(entity);
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        try {
            Aluno entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AlunoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @CacheEvict(key="#id")
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno id (" + id + ") not found.");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database Integrity Violation");
        }
    }

    private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());

        entity.getCursos().clear();
        for(CursoDTO curDTO : dto.getCursos()){
            Curso curso = cursoRepository.getReferenceById(curDTO.getId());
            entity.getCursos().add(curso);
        }
    }

}
