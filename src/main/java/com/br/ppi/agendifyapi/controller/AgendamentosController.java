package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.Agendamentos;
import com.br.ppi.agendifyapi.repository.AgendamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentosController {

    @Autowired
    private AgendamentosRepository agendamentosRepository;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){

        return ResponseEntity.ok(agendamentosRepository.findAll());
    }

    @GetMapping("/findAll-by-id")
    public ResponseEntity findAllById(@RequestParam Long idUser){

        return ResponseEntity.ok(agendamentosRepository.findAllByClientIdUser(idUser));
    }

    @PostMapping("/save")
    public ResponseEntity insertAgendamento(@RequestBody Agendamentos agendamentos){

        return ResponseEntity.ok(agendamentosRepository.save(agendamentos));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteAgendamento(@RequestParam Long idAgendamento) {

        agendamentosRepository.deleteById(idAgendamento);

        return ResponseEntity.ok("Agendamento deletado com sucesso");
    }

    
}
