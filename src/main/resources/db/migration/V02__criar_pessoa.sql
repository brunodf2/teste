create table pessoa (
	id bigserial not null,
	nome varchar(100) not null,
	documento varchar(14) not null,
	data_nascimento date not null,
	nome_mae varchar(100),
	nome_pai varchar(100),
	tipo varchar(20) not null,
	data_cadastro date not null default CURRENT_DATE,

	
	primary key (id)
);

