package com.br.ppi.agendifyapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_user")
    private Long idUser;
    @Column(name="id_user_type")
    @NotNull
    private Long idUserType;
    @Column(name="nome")
    @NotNull
    private String nome;
    @Column(name="email")
    @NotNull
    private String email;
    @Column(name="senha")
    @NotNull
    private String senha;
    @Column(name="data_nascimento")
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull
    private LocalDate dtNascimento;
    @Column(name="cpf")
    @NotNull
    private String cpf;
    @Column(name="telefone")
    @NotNull
    private String telefone;
}
