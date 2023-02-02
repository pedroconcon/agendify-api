package com.br.ppi.agendifyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/client")
public class ClientController {

    @GetMapping("/teste3")
    public ResponseEntity teste(){

        return ResponseEntity.ok("teste1");
    }
}
