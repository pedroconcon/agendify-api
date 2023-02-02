CREATE TABLE servicos
(id_servicos BIGINT CONSTRAINT id_pk PRIMARY KEY ,
 descricao VARCHAR(100) NOT NULL,
 valor float8 NOT NULL,
 duracao INTEGER NOT NULL
);

CREATE TABLE user_type(
                          id_user_type BIGINT CONSTRAINT id_user_type PRIMARY KEY,
                          user_type VARCHAR(15)
);

CREATE TABLE client(
                       id_user BIGINT CONSTRAINT id_user_pk PRIMARY KEY,
                       id_user_type BIGINT,
                       nome VARCHAR(50),
                       email VARCHAR(50),
                       senha VARCHAR (50),
                       CONSTRAINT id_user_type_fk FOREIGN KEY(id_user_type) REFERENCES user_type(id_user_type)
);

CREATE TABLE cargo(
                      id_cargo BIGINT CONSTRAINT id_cargo_pk PRIMARY KEY,
                      cargo VARCHAR(50)
);

CREATE TABLE profissional(
                             id_profissional BIGINT CONSTRAINT id_profissional_pk PRIMARY KEY,
                             id_cargo BIGINT,
                             nome VARCHAR(100),
                             CONSTRAINT id_cargo_fk FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
)

CREATE TABLE profissional_has_servicos(
                                          id_profissional BIGINT,
                                          id_servicos BIGINT,
                                          CONSTRAINT id_servicos_fk FOREIGN KEY (id_servicos) REFERENCES servicos(id_servicos),
                                          CONSTRAINT id_profissional_fk FOREIGN KEY (id_profissional) REFERENCES profissional(id_profissional)
);

CREATE TABLE agendamentos (
                              id_agendamento BIGINT CONSTRAINT id_agendamento_pk PRIMARY KEY,
                              id_user BIGINT, --FK client,
                              id_profissional BIGINT,
                              valor float8,
                              data TIMESTAMP,
                              CONSTRAINT id_user_fk FOREIGN KEY (id_user) REFERENCES client(id_user),
                              CONSTRAINT id_profissional_fk FOREIGN KEY (id_profissional) REFERENCES profissional(id_profissional)
);

CREATE TABLE agendamento_has_servicos(
                                         id_agendamento BIGINT,
                                         id_servicos BIGINT,
                                         CONSTRAINT id_agendamento_fk FOREIGN KEY (id_agendamento) REFERENCES agendamentos(id_agendamento),
                                         CONSTRAINT id_servicos_fk FOREIGN KEY (id_servicos) REFERENCES servicos(id_servicos)
);