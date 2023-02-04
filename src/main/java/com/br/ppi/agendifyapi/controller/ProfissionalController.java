package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.Profissional;
import com.br.ppi.agendifyapi.repository.CargoRepository;
import com.br.ppi.agendifyapi.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/find-all")
    public ResponseEntity findAllProfissional(){

        return ResponseEntity.ok(profissionalRepository.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findByIdProfissional(@RequestParam Long idProfissional){

        return ResponseEntity.ok(profissionalRepository.findById(idProfissional));
    }
    @PutMapping("/update")
    public ResponseEntity updateProfissional(@RequestBody Profissional request){

        Optional<Profissional> proToUpdate = profissionalRepository.findById(request.getIdProfissional());
        proToUpdate.get().setNome(request.getNome());
        proToUpdate.get().setCargo(request.getCargo());

        return ResponseEntity.ok(profissionalRepository.save(proToUpdate.get()));
    }
    @PostMapping("/save")
    public ResponseEntity saveProfissional(@RequestBody Profissional profissional){

        return ResponseEntity.ok(profissionalRepository.save(profissional));
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteProfissional(@RequestParam Long idProfissional){

        profissionalRepository.deleteById(idProfissional);
        return ResponseEntity.ok("Profissional deletado com sucesso");
    }
}
