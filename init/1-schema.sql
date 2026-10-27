CREATE TABLE reserva_status
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE reserva_tipo
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE edificio
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE curso
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE disciplina
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE sala_tipo
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE horario
(
    id             integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descricao      varchar(255) NOT NULL,
    horario_inicio time         NOT NULL,
    horario_fim    time         NOT NULL,
    UNIQUE (horario_inicio, horario_fim)
);

CREATE TABLE usuario
(
    id           integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    senha        varchar(255) NOT NULL,
    nome         varchar(255) NOT NULL,
    email        varchar(255) NOT NULL UNIQUE,
    telefone     varchar(20),
    data_cadastro timestamp    NOT NULL DEFAULT now(),
    ativo        boolean      NOT NULL DEFAULT true
);

CREATE TABLE perfil
(
    id   integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(255) NOT NULL UNIQUE
);

CREATE TABLE usuario_perfil
(
    id         integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id integer NOT NULL REFERENCES usuario (id),
    perfil_id  integer NOT NULL REFERENCES perfil (id),
    UNIQUE (usuario_id, perfil_id)
);

CREATE TABLE sala
(
    id           integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sala_tipo_id integer      NOT NULL REFERENCES sala_tipo (id),
    nome         varchar(255) NOT NULL,
    edificio_id  integer      NOT NULL REFERENCES edificio (id),
    capacidade   integer      NOT NULL,
    ativo        boolean      NOT NULL DEFAULT true,
    UNIQUE (edificio_id, nome)
);

CREATE TABLE reserva
(
    id                  integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    reserva_status_id   integer   NOT NULL REFERENCES reserva_status (id),
    reserva_tipo_id     integer   NOT NULL REFERENCES reserva_tipo (id),
    usuario_id          integer   NOT NULL REFERENCES usuario (id),
    horario_id          integer   NOT NULL REFERENCES horario (id),
    sala_id             integer   NOT NULL REFERENCES sala (id),
    curso_id            integer REFERENCES curso (id),
    disciplina_id       integer REFERENCES disciplina (id),
    descricao_atividade text,
    data_reserva        date      NOT NULL,
    data_cadastro        timestamp NOT NULL DEFAULT now()
);

CREATE UNIQUE INDEX uq_reserva_slot
    ON reserva (sala_id, data_reserva, horario_id) WHERE reserva_status_id IN (1, 2);

CREATE INDEX idx_reserva_data ON reserva (data_reserva);
CREATE INDEX idx_reserva_usuario ON reserva (usuario_id);