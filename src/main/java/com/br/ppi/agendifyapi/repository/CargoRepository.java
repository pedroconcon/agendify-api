package com.br.ppi.agendifyapi.repository;

import com.br.ppi.agendifyapi.model.Cargo;
import com.br.ppi.agendifyapi.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
