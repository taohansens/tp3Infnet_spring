package org.taohansen.tp3infnet_spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.taohansen.tp3infnet_spring.dto.MaterialDTO;
import org.taohansen.tp3infnet_spring.services.MaterialService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/material")
public class MaterialController {
    @Autowired
    private MaterialService service;

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> findAll() {
        List<MaterialDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> findById(@PathVariable String id) {
        MaterialDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MaterialDTO> insert(@RequestBody MaterialDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MaterialDTO> update(@PathVariable String id, @RequestBody MaterialDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
