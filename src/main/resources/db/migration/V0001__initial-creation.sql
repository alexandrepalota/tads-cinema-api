CREATE schema usr_cinema_api;

create table usr_cinema_api.tb_salas (
	id serial primary key,
	nome varchar(20) not null unique,
	capacidade int not null check (capacidade between 1 and 50)
);

create table usr_cinema_api.tb_filmes (
    id serial primary key,
    titulo varchar(100) not null,
    genero varchar(20) not null,
    sinopse varchar(1000) not null,
    url_capa varchar(255)
);

create table usr_cinema_api.tb_sessoes (
    id serial primary key,
    data_hora timestamp not null check (data_hora > now()),
    sala_id integer not null,
    filme_id integer not null,
    constraint fk_sala foreign key(sala_id) references usr_cinema_api.tb_salas(id),
    constraint fk_filme foreign key(filme_id) references usr_cinema_api.tb_filmes(id)
);

create table usr_cinema_api.tb_ingressos (
    id serial primary key,
    lugar integer not null check (lugar > 0),
    sessao_id integer,
    nome_cliente varchar(60) not null,
    constraint fk_sessao foreign key(sessao_id) references usr_cinema_api.tb_sessoes(id),
    constraint un_tb_ingressos unique(lugar, sessao_id)
);
