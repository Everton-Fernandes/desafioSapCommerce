package com.example.plataformacursos.plataformcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.plataformacursos.plataformcursos.dto.AlunoDTO;
import com.example.plataformacursos.plataformcursos.dto.CursoDTO;
import com.example.plataformacursos.plataformcursos.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Endpoint para cadastrar um curso
    @PostMapping
    public ResponseEntity<CursoDTO> cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        CursoDTO novoCurso = cursoService.cadastrarCurso(cursoDTO);
        return ResponseEntity.ok(novoCurso);
    }

    // Endpoint para listar os alunos por curso
    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<AlunoDTO>> listarAlunosPorCurso(@PathVariable Long id) {
        List<AlunoDTO> alunos = cursoService.listarAlunosPorCurso(id);
        return ResponseEntity.ok(alunos);
    }

    // Endpoint para listar todos os cursos
    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarTodosCursos() {
        List<CursoDTO> cursos = cursoService.listarTodosCursos();
        return ResponseEntity.ok(cursos);
    }
}
