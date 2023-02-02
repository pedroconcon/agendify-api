package com.br.ppi.agendifyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cargo")
public class CargoController {

    @GetMapping("/teste4")
    public ResponseEntity teste(){

        return ResponseEntity.ok("teste1");
    }
}
