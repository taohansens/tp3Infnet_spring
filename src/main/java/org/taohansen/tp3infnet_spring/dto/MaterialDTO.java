package org.taohansen.tp3infnet_spring.dto;

import org.taohansen.tp3infnet_spring.entities.Material;

public class MaterialDTO {
    private String id;
    private String nome;
    private String materia;
    private String ano;

    public MaterialDTO() {
    }

    public MaterialDTO(String id, String nome, String materia, String ano) {
        this.id = id;
        this.nome = nome;
        this.materia = materia;
        this.ano = ano;
    }

    public MaterialDTO(Material entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.materia = entity.getMateria();
        this.ano = entity.getAno();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
