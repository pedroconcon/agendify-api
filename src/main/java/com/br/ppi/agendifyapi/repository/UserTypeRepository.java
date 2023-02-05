package com.br.ppi.agendifyapi.repository;

import com.br.ppi.agendifyapi.model.Servicos;
import com.br.ppi.agendifyapi.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
