package com.br.ppi.agendifyapi.repository;

import com.br.ppi.agendifyapi.model.Agendamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentosRepository extends JpaRepository<Agendamentos, Long> {

}
