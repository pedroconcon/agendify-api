CREATE TABLE servicos
(id_servicos SERIAL PRIMARY KEY NOT NULL,
 descricao VARCHAR(100) NOT NULL,
 valor float8 NOT NULL,
 duracao INTEGER NOT NULL
);

CREATE TABLE user_type(
                          id_user_type SERIAL PRIMARY KEY,
                          user_type VARCHAR(15)
);

CREATE TABLE client(
                       id_user SERIAL PRIMARY KEY NOT NULL,
                       id_user_type BIGINT DEFAULT 2 NOT NULL,
                       nome VARCHAR(50) NOT NULL,
                       email VARCHAR(50) NOT NULL,
                       senha VARCHAR (50) NOT NULL,
                       data_nascimento TIMESTAMP NOT NULL,
                       cpf VARCHAR(11) NOT NULL,
                       telefone VARCHAR(25) NOT NULL,
                       CONSTRAINT id_user_type_fk FOREIGN KEY(id_user_type) REFERENCES user_type(id_user_type)
);


CREATE TABLE cargo(
                      id_cargo SERIAL PRIMARY KEY,
                      cargo VARCHAR(50)
);

CREATE TABLE profissional(
                             id_profissional SERIAL PRIMARY KEY NOT NULL,
                             id_cargo BIGINT NOT NULL,
                             nome VARCHAR(100) NOT NULL,
                             CONSTRAINT id_cargo_fk FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
);

CREATE TABLE profissional_has_servicos(
                                          id_profissional BIGINT,
                                          id_servicos BIGINT,
                                          CONSTRAINT id_servicos_fk FOREIGN KEY (id_servicos) REFERENCES servicos(id_servicos),
                                          CONSTRAINT id_profissional_fk FOREIGN KEY (id_profissional) REFERENCES profissional(id_profissional)
);

CREATE TABLE agendamentos (
                              id_agendamento SERIAL PRIMARY KEY NOT NULL,
                              id_user BIGINT NOT NULL, --FK client,
                              id_profissional BIGINT NOT NULL,
                              valor float8 NOT NULL,
                              data TIMESTAMP NOT NULL,
                              CONSTRAINT id_user_fk FOREIGN KEY (id_user) REFERENCES client(id_user),
                              CONSTRAINT id_profissional_fk FOREIGN KEY (id_profissional) REFERENCES profissional(id_profissional)
);

CREATE TABLE agendamento_has_servicos(
                                         id_agendamento BIGINT,
                                         id_servicos BIGINT,
                                         CONSTRAINT id_agendamento_fk FOREIGN KEY (id_agendamento) REFERENCES agendamentos(id_agendamento),
                                         CONSTRAINT id_servicos_fk FOREIGN KEY (id_servicos) REFERENCES servicos(id_servicos)
);

CREATE SEQUENCE hibernate_sequence START with 1 increment by 1;

INSERT INTO user_type (user_type) VALUES('Admin');
INSERT INTO user_type (user_type) VALUES('Client');



