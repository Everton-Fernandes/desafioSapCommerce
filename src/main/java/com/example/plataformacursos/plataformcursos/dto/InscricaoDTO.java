package com.example.plataformacursos.plataformcursos.dto;

import java.util.Date;

import com.example.plataformacursos.plataformcursos.model.Inscricao;

public class InscricaoDTO {
    private Long alunoId;
    private Long cursoId;
    private Date dataInscricao;

    public InscricaoDTO() {
    }

    public InscricaoDTO(Inscricao inscricao) {
        this.alunoId = inscricao.getAluno().getId();
        this.cursoId = inscricao.getCurso().getId();
        this.dataInscricao = inscricao.getDataInscricao();
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

}
