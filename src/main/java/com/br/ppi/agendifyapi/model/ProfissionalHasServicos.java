package com.br.ppi.agendifyapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class ProfissionalHasServicos {
    @Column(name="id_profissional")
    private Long idProfissional;
    @Column(name = "id_servicos")
    private Long idSevicos;
}
