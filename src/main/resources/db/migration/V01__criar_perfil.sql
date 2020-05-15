create table perfil (
	id bigserial not null,
	nome varchar(80) not null,

	
	primary key (id)
);

INSERT INTO perfil (nome) values ('Gerente');