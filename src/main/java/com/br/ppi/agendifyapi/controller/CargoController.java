package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.Cargo;
import com.br.ppi.agendifyapi.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;
    @GetMapping("/find-all")
    public ResponseEntity findAllCargo(){

        return ResponseEntity.ok(cargoRepository.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findByIdCarago(@RequestParam Long idCargo){

       return ResponseEntity.ok(cargoRepository.findById(idCargo));
    }

    @PutMapping("/update")
    public ResponseEntity updateCargo(@RequestBody Cargo request){

        Optional<Cargo> cargoToUpdate = cargoRepository.findById(request.getIdCargo());
        cargoToUpdate.get().setCargo(request.getCargo());

        return ResponseEntity.ok(cargoRepository.save(cargoToUpdate.get()));
    }

    @PostMapping("/save")
    public ResponseEntity saveCargo(@RequestBody Cargo cargo){

        return ResponseEntity.ok(cargoRepository.save(cargo));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCargo(@RequestParam Long idCargo){

        cargoRepository.deleteById(idCargo);
        return ResponseEntity.ok("Cargo deletado com sucesso");
    }
}
