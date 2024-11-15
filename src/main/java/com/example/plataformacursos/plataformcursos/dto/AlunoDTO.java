package com.example.plataformacursos.plataformcursos.dto;

import com.example.plataformacursos.plataformcursos.model.Aluno;

public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
