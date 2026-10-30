INSERT INTO reserva_status (nome)
VALUES ('Pendente'),
       ('Confirmada'),
       ('Cancelada'),
       ('Rejeitada');

INSERT INTO reserva_tipo (nome)
VALUES ('Aula'),
       ('Evento'),
       ('Reuniao'),
       ('Manutencao');

INSERT INTO sala_tipo (nome)
VALUES ('Sala de Aula'),
       ('Laboratorio'),
       ('Auditorio');

INSERT INTO perfil (nome)
VALUES ('Administrador'),
       ('Professor'),
       ('Aluno');

INSERT INTO edificio (nome)
VALUES ('Bloco A'),
       ('Bloco B'),
       ('Bloco C');

INSERT INTO curso (nome)
VALUES ('Ciencia da Computacao'),
       ('Engenharia de Software'),
       ('Sistemas de Informacao');

INSERT INTO disciplina (nome)
VALUES ('Matematica'),
       ('Fisica'),
       ('Programacao I'),
       ('Banco de Dados');

INSERT INTO horario (descricao, horario_inicio, horario_fim)
VALUES ('1º horario', '07:00', '08:40'),
       ('2º horario', '08:40', '10:20'),
       ('3º horario', '10:40', '12:20'),
       ('4º horario', '13:30', '15:10'),
       ('5º horario', '15:30', '17:10'),
       ('6º horario', '19:00', '20:40');
