package com.br.ppi.agendifyapi.model.dto;

import com.br.ppi.agendifyapi.model.Profissional;
import com.br.ppi.agendifyapi.model.ProfissionalHasServicos;
import com.br.ppi.agendifyapi.model.Servicos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalResponseDTO extends Profissional{
    @OneToMany
    private List<ProfissionalHasServicos> profissionalHasServicos;


}
