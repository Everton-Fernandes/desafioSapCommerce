package com.example.plataformacursos.plataformcursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.plataformacursos.plataformcursos.model.Inscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    List<Inscricao> findByAlunoId(Long alunoId);

    List<Inscricao> findByCursoId(Long cursoId);
}
