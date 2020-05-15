create table telefone (
	id bigserial not null,
	ddd numeric(3) not null,
	telefone numeric(10) not null,
	tipo varchar(20) not null,
	id_pessoa bigserial not null,
	FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
	data_cadastro date not null default CURRENT_DATE,

	
	primary key (id)
);



