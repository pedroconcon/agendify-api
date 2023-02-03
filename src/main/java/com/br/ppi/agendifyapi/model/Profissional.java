package com.br.ppi.agendifyapi.model;

import jdk.jfr.Relational;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_profissional")
    private Long idProfissional;
    @OneToMany
    @JoinColumn(name = "id_cargo")
    private List<Cargo> cargos;
    @Column(name = "nome")
    private String nome;
}
