package com.br.ppi.agendifyapi.controller;

import com.br.ppi.agendifyapi.model.UserType;
import com.br.ppi.agendifyapi.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("/find-all")
    public ResponseEntity findAllCargo(){

        return ResponseEntity.ok(userTypeRepository.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findByIdCargo(@RequestParam Long idUserType){

        return ResponseEntity.ok(userTypeRepository.findById(idUserType));
    }

    @PutMapping("/update")
    public ResponseEntity updateCargo(@RequestBody UserType userType){

        Optional<UserType> userTypeToUpdate = userTypeRepository.findById(userType.getIdUserType());
        userTypeToUpdate.get().setUserType(userType.getUserType());

        return ResponseEntity.ok(userTypeRepository.save(userTypeToUpdate.get()));
    }

    @PostMapping("/save")
    public ResponseEntity saveCargo(@RequestBody UserType userType){

        return ResponseEntity.ok(userTypeRepository.save(userType));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCargo(@RequestParam Long idUserType){

        userTypeRepository.deleteById(idUserType);
        return ResponseEntity.ok("User type deletado com sucesso");
    }
}
