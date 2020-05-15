package com.teste.mirante.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.mirante.api.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {



}
