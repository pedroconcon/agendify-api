package com.br.ppi.agendifyapi.repository;

import com.br.ppi.agendifyapi.model.Agendamentos;
import com.br.ppi.agendifyapi.model.Profissional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @EntityGraph(value = "servicos.detail", type = EntityGraph.EntityGraphType.LOAD)
    Profissional getByIdProfissional(Long id);
}
