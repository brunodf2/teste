package com.teste.mirante.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.teste.mirante.api.model.Telefone;
import com.teste.mirante.api.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	
	public Telefone atualizar(Long id, Telefone telefone) {
		Telefone telefoneSalva = buscarTelefonePeloId(id);
		
		BeanUtils.copyProperties(telefone, telefoneSalva, "codigo");
		return telefoneRepository.save(telefoneSalva);
	}
	
	private Telefone buscarTelefonePeloId(Long id) {
		Telefone telefoneSalva = telefoneRepository.findOne(id);
		if (telefoneSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return telefoneSalva;
	}
	


}
