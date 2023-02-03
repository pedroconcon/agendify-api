package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.Servicos;
import com.br.ppi.agendifyapi.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
    @Autowired
    private ServicosRepository servicosRepository;

    @GetMapping("/find-all")
    public ResponseEntity findAllServicos(){

        return ResponseEntity.ok(servicosRepository.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity updateCargo(@RequestBody Servicos servicos){

        Optional<Servicos> servicosToUpdate = servicosRepository.findById(servicos.getIdServicos());
        servicosToUpdate.get().setDescricao(servicos.getDescricao());
        servicosToUpdate.get().setValor(servicos.getValor());
        servicosToUpdate.get().setDuracao(servicos.getDuracao());

        return ResponseEntity.ok(servicosRepository.save(servicosToUpdate.get()));
    }
    @PostMapping("/save")
    public ResponseEntity saveServico(@RequestBody Servicos servicos){

        return ResponseEntity.ok(servicosRepository.save(servicos));
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteServico(@RequestParam Long idServico){

        servicosRepository.deleteById(idServico);
        return ResponseEntity.ok("Client deletado com sucesso");
    }
}
