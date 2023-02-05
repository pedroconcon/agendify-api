package com.br.ppi.agendifyapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "servicos")
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_servicos")
    private Long idServicos;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "duracao")
    private Integer duracao;

    @ManyToMany(mappedBy = "servicos", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Profissional> profissional = new HashSet<>();
}
