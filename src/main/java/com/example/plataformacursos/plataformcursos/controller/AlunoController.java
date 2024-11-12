package com.example.plataformacursos.plataformcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.plataformacursos.plataformcursos.dto.AlunoDTO;
import com.example.plataformacursos.plataformcursos.dto.CursoDTO;
import com.example.plataformacursos.plataformcursos.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        AlunoDTO novoAluno = alunoService.cadastrarAluno(alunoDTO);
        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<CursoDTO>> listarCursosPorAluno(@PathVariable Long id) {
        List<CursoDTO> cursos = alunoService.listarCursosPorAluno(id);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarTodosAlunos() {
        List<AlunoDTO> alunos = alunoService.listarTodosAlunos();
        return ResponseEntity.ok(alunos);
    }
}
