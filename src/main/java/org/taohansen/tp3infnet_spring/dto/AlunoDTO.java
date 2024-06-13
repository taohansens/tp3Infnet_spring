package org.taohansen.tp3infnet_spring.dto;

import org.taohansen.tp3infnet_spring.entities.Aluno;
import org.taohansen.tp3infnet_spring.entities.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlunoDTO {
    private Long id;
    private String name;
    private String email;
    private List<CursoDTO> cursos = new ArrayList<>();

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public AlunoDTO(Aluno entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    public AlunoDTO(Aluno entity, Set<Curso> cursos){
        this(entity);
        cursos.forEach(cur -> this.cursos.add(new CursoDTO(cur)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CursoDTO> getCursos() {
        return cursos;
    }
}
