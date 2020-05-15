package com.teste.mirante.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.mirante.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
