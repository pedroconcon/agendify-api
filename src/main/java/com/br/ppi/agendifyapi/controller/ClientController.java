package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.Cargo;
import com.br.ppi.agendifyapi.model.Client;
import com.br.ppi.agendifyapi.model.dto.LoginDTO;
import com.br.ppi.agendifyapi.repository.CargoRepository;
import com.br.ppi.agendifyapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity loginClient(@RequestBody LoginDTO loginDTO){

        return ResponseEntity.ok(clientRepository.findClientByIdUserAndSenha(loginDTO.getIdUser(),loginDTO.getSenha()));
    }
    @GetMapping("/find-all")
    public ResponseEntity findAllClient(){

        return ResponseEntity.ok(clientRepository.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findByIdClient(@RequestParam Long idUser){

        return ResponseEntity.ok(clientRepository.findById(idUser));
    }
    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client request){

        Optional<Client> clientToUpdate = clientRepository.findById(request.getIdUser());
        clientToUpdate.get().setCpf(request.getCpf());
        clientToUpdate.get().setNome(request.getNome());
        clientToUpdate.get().setEmail(request.getEmail());
        clientToUpdate.get().setDtNascimento(request.getDtNascimento());
        clientToUpdate.get().setSenha(request.getSenha());//TODO criar funcao md5 para atualizar e salvar no banco
        clientToUpdate.get().setTelefone(request.getTelefone());

        return ResponseEntity.ok(clientRepository.save(clientToUpdate.get()));
    }
    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody Client client){
        //TODO tratar insert senha MD5
        return ResponseEntity.ok(clientRepository.save(client));
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteClient(@RequestParam Long idUser){

        clientRepository.deleteById(idUser);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }
}
