package com.br.ppi.agendifyapi.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamentos{

    @Id
    @GeneratedValue
    @Column(name="id_agendamento")
    private Long idAgendamento;

    @Column(name="id_user")
    @NotNull
    private Long idUser;

    @Column(name="id_profissional")
    @NotNull
    private Long idProfissional;

    @Column(name="valor")
    @NotNull
    private Double valor;

    @Column(name="data")
    @NotNull
    private LocalDateTime dsTitulo;
}
