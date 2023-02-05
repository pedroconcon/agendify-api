package com.br.ppi.agendifyapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamentos{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_agendamento")
    private Long idAgendamento;
    @OneToOne
    @JoinColumn(name = "id_user")
    private Client client;

    @OneToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;

    @Column(name="valor")
    @NotNull
    private Double valor;

    @Column(name="data")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime data;

}
