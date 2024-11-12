package com.example.plataformacursos.plataformcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.plataformacursos.plataformcursos.dto.InscricaoDTO;
import com.example.plataformacursos.plataformcursos.service.InscricaoService;

@RestController
@RequestMapping
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping("/inscricoes")
    public ResponseEntity<InscricaoDTO> inscreverAlunoEmCurso(@RequestBody InscricaoDTO inscricaoDTO) {
        InscricaoDTO novaInscricao = inscricaoService.inscreverAlunoEmCurso(inscricaoDTO);
        return ResponseEntity.ok(novaInscricao);
    }
}
