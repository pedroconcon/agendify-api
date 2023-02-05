package com.br.ppi.agendifyapi.repository;

import com.br.ppi.agendifyapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByIdUserAndSenha(Long idUser, String senha);
}
