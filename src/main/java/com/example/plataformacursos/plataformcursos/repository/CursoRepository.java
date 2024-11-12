package com.example.plataformacursos.plataformcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.plataformacursos.plataformcursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
