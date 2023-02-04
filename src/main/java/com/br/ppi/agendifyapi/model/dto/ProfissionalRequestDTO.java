package com.br.ppi.agendifyapi.model.dto;

import com.br.ppi.agendifyapi.model.Profissional;
import com.br.ppi.agendifyapi.model.Servicos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalRequestDTO extends Profissional {
    private List<Long> listServicos;
}
