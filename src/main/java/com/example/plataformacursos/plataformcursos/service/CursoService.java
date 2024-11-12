package com.example.plataformacursos.plataformcursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plataformacursos.plataformcursos.dto.AlunoDTO;
import com.example.plataformacursos.plataformcursos.dto.CursoDTO;
import com.example.plataformacursos.plataformcursos.model.Curso;
import com.example.plataformacursos.plataformcursos.repository.CursoRepository;
import com.example.plataformacursos.plataformcursos.util.InscricaoPopulator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public CursoDTO cadastrarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setDataCriacao(cursoDTO.getDataCriacao());
        curso = cursoRepository.save(curso);
        return inscricaoPopulator.toCursoDTO(curso);
    }

    public List<AlunoDTO> listarAlunosPorCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return curso.getAlunos().stream()
                .map(inscricaoPopulator::toAlunoDTO)
                .collect(Collectors.toList());
    }

    public List<CursoDTO> listarTodosCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream()
                .map(inscricaoPopulator::toCursoDTO)
                .collect(Collectors.toList());
    }
}
