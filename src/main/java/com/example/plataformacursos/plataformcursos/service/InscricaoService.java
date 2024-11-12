package com.example.plataformacursos.plataformcursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plataformacursos.plataformcursos.dto.InscricaoDTO;
import com.example.plataformacursos.plataformcursos.model.Aluno;
import com.example.plataformacursos.plataformcursos.model.Curso;
import com.example.plataformacursos.plataformcursos.model.Inscricao;
import com.example.plataformacursos.plataformcursos.repository.AlunoRepository;
import com.example.plataformacursos.plataformcursos.repository.CursoRepository;
import com.example.plataformacursos.plataformcursos.repository.InscricaoRepository;
import com.example.plataformacursos.plataformcursos.util.InscricaoPopulator;

@Service
public class InscricaoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public InscricaoDTO inscreverAlunoEmCurso(InscricaoDTO inscricaoDTO) {
        Aluno aluno = alunoRepository.findById(inscricaoDTO.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(inscricaoDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(inscricaoDTO.getDataInscricao());

        inscricao = inscricaoRepository.save(inscricao);
        return inscricaoPopulator.toInscricaoDTO(inscricao);
    }
}
