package org.taohansen.tp3infnet_spring.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.taohansen.tp3infnet_spring.dto.AlunoDTO;
import org.taohansen.tp3infnet_spring.dto.MaterialDTO;
import org.taohansen.tp3infnet_spring.entities.Material;
import org.taohansen.tp3infnet_spring.repositories.AlunoRepository;
import org.taohansen.tp3infnet_spring.repositories.MaterialRepository;
import org.taohansen.tp3infnet_spring.services.exceptions.DatabaseException;
import org.taohansen.tp3infnet_spring.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository repository;

    @Transactional(readOnly = true)
    public List<MaterialDTO> findAll() {
        List<Material> list = repository.findAll();
        return list.stream().map(MaterialDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public MaterialDTO findById(String id) {
        Optional<Material> obj = repository.findById(id);
        Material entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Material not found."));
        return new MaterialDTO(entity);
    }

    @Transactional
    public MaterialDTO insert(MaterialDTO dto) {
        Material entity = new Material();
        entity.setNome(dto.getNome());
        entity.setMateria(dto.getMateria());
        entity.setAno(dto.getAno());
        entity = repository.save(entity);
        return new MaterialDTO(entity);
    }

    @Transactional
    public MaterialDTO update(String id, MaterialDTO dto) {
        try {
            Optional<Material> obj = repository.findById(id);
            Material entity = obj.orElseThrow(EntityNotFoundException::new);
            entity.setNome(dto.getNome());
            entity.setMateria(dto.getMateria());
            entity.setAno(dto.getAno());
            entity = repository.save(entity);
            return new MaterialDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Material id (" + id + ") not found.");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database Integrity Violation");
        }
    }

}
