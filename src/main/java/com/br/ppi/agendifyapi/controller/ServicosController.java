package com.br.ppi.agendifyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/servicos")
public class ServicosController {
    @GetMapping("/teste1")
    public ResponseEntity teste(){

        return ResponseEntity.ok("teste1");
    }
}
