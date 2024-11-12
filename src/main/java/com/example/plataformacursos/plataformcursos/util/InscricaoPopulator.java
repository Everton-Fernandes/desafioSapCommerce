package com.example.plataformacursos.plataformcursos.util;

import org.springframework.stereotype.Component;

import com.example.plataformacursos.plataformcursos.dto.AlunoDTO;
import com.example.plataformacursos.plataformcursos.dto.CursoDTO;
import com.example.plataformacursos.plataformcursos.dto.InscricaoDTO;
import com.example.plataformacursos.plataformcursos.model.Aluno;
import com.example.plataformacursos.plataformcursos.model.Curso;
import com.example.plataformacursos.plataformcursos.model.Inscricao;

@Component
public class InscricaoPopulator {

    public AlunoDTO toAlunoDTO(Aluno aluno) {
        if (aluno == null) {
            return null;
        }
        return new AlunoDTO(aluno);
    }

    public CursoDTO toCursoDTO(Curso curso) {
        if (curso == null) {
            return null;
        }
        return new CursoDTO(curso);
    }

    public InscricaoDTO toInscricaoDTO(Inscricao inscricao) {
        if (inscricao == null) {
            return null;
        }
        return new InscricaoDTO(inscricao);
    }
}
