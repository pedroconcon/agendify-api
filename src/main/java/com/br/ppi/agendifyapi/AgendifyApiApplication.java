package com.br.ppi.agendifyapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "AGENDIFY-API", version = "2.0", description = "Api para gerenciar todos os dados da agendify"))
public class AgendifyApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendifyApiApplication.class, args);
    }
}
