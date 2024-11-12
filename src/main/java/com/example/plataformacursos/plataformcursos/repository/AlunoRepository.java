package com.example.plataformacursos.plataformcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.plataformacursos.plataformcursos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
