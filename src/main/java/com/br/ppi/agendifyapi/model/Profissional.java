package com.br.ppi.agendifyapi.model;

import jdk.jfr.Relational;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profissional")
@Builder
@NamedEntityGraph(name = "servicos.detail", attributeNodes = @NamedAttributeNode("servicos"))
@ToString(exclude = {"servicos"})
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_profissional")
    private Long idProfissional;
    @OneToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;
    @Column(name = "nome")
    private String nome;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable( name = "profissional_has_servicos",
                joinColumns = { @JoinColumn(name = "id_profissional")},
                inverseJoinColumns = {@JoinColumn(name="id_servicos")})
    private List<Servicos> servicos;
}
