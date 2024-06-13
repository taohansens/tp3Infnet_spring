package org.taohansen.tp3infnet_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taohansen.tp3infnet_spring.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
