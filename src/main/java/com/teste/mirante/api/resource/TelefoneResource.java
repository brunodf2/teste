package com.teste.mirante.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.mirante.api.model.Pessoa;
import com.teste.mirante.api.model.Telefone;
import com.teste.mirante.api.repository.TelefoneRepository;
import com.teste.mirante.api.service.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TelefoneResource {

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private TelefoneService telefoneService;

	@GetMapping
	public List<Telefone> listar() {
		return telefoneRepository.findAll();

	}

	@PostMapping
	public ResponseEntity<Telefone> criar(@Valid @RequestBody Telefone telefone, HttpServletResponse response) {
		Telefone telefoneSalvo = telefoneRepository.save(telefone);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{}id")
				.buildAndExpand(telefoneSalvo.getId()).toUri();

		return ResponseEntity.created(uri).body(telefoneSalvo);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Telefone> atualizar(@Valid @PathVariable Long id, @RequestBody Telefone telefone) {
		Telefone telefoneSalvo = telefoneService.atualizar(id, telefone);

		return ResponseEntity.ok(telefoneSalvo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		telefoneRepository.deleteById(id);
	}

}
