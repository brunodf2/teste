package com.teste.mirante.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.mirante.api.model.Perfil;
import com.teste.mirante.api.repository.PerfilRepository;


@RestController
@RequestMapping("/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	
	@GetMapping
	public List<Perfil>listar() {
		
		return perfilRepository.findAll();
		
	}
	
	@PostMapping
	public ResponseEntity<Perfil> criar(@Valid @RequestBody Perfil perfil, HttpServletResponse response) {
		Perfil perfilSalvo = perfilRepository.save(perfil);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(perfilSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(perfilSalvo);
	}
	
	
	@GetMapping("/{id}")
	public Optional<Perfil> buscarPeloId(@PathVariable Long id) {
		return perfilRepository.findById(id); 
	}
}
