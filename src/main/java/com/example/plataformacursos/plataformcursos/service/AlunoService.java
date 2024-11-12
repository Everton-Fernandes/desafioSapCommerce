package com.example.plataformacursos.plataformcursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plataformacursos.plataformcursos.dto.AlunoDTO;
import com.example.plataformacursos.plataformcursos.dto.CursoDTO;
import com.example.plataformacursos.plataformcursos.model.Aluno;
import com.example.plataformacursos.plataformcursos.repository.AlunoRepository;
import com.example.plataformacursos.plataformcursos.util.InscricaoPopulator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public AlunoDTO cadastrarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno = alunoRepository.save(aluno);
        return inscricaoPopulator.toAlunoDTO(aluno);
    }

    public List<CursoDTO> listarCursosPorAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return aluno.getCursos().stream()
                .map(inscricaoPopulator::toCursoDTO)
                .collect(Collectors.toList());
    }

    public List<AlunoDTO> listarTodosAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(inscricaoPopulator::toAlunoDTO)
                .collect(Collectors.toList());
    }
}
