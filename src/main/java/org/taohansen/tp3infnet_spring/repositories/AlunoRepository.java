package org.taohansen.tp3infnet_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taohansen.tp3infnet_spring.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
