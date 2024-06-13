package org.taohansen.tp3infnet_spring.dto;

import org.taohansen.tp3infnet_spring.entities.Curso;

public class CursoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String cargaHoraria;
    public CursoDTO() {
    }

    public CursoDTO(Long id, String nome, String descricao, String cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public CursoDTO(Curso entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        cargaHoraria = entity.getCargaHoraria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
