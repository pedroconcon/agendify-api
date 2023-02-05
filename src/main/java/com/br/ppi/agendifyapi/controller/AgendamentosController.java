package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.Agendamentos;
import com.br.ppi.agendifyapi.model.Cargo;
import com.br.ppi.agendifyapi.repository.AgendamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentosController {

    @Autowired
    private AgendamentosRepository agendamentosRepository;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){

        return ResponseEntity.ok(agendamentosRepository.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findAllById(@RequestParam Long idAgendamento){

        return ResponseEntity.ok(agendamentosRepository.findById(idAgendamento));
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

    @PutMapping("/update")
    public ResponseEntity atualizaAgendamento(@RequestBody Agendamentos request){

        Agendamentos agendamentoToUpdate = agendamentosRepository.findById(request.getIdAgendamento()).get();
        agendamentoToUpdate.setData(request.getData());
        agendamentoToUpdate.setClient(request.getClient());
        agendamentoToUpdate.setValor(request.getValor());
        agendamentoToUpdate.setProfissional(request.getProfissional());

        return ResponseEntity.ok(agendamentosRepository.save(agendamentoToUpdate));
    }
}
