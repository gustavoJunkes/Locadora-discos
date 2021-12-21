package com.godev.locadoradiscos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godev.locadoradiscos.dto.ClienteDto;
import com.godev.locadoradiscos.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	/*
	 * Métodos get podem ser juntados em um único
	 */

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ClienteDto>> all() {
		return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ClienteDto> getById(@Param("id") Long id) {
		ClienteDto cliente = new ClienteDto();
		cliente = clienteService.getById(id);

		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@DeleteMapping
	public void delete(@Param("id") Long id) {
		clienteService.delete(id);
	}

	@PostMapping
	public ResponseEntity<ClienteDto> save(@Valid @RequestBody ClienteDto clienteDto) {
		return new ResponseEntity<>(clienteService.save(clienteDto), HttpStatus.OK);
	}

	@GetMapping(value = "/nome")
	public ResponseEntity<List<ClienteDto>> buscarClientesPorNome(@RequestParam("nome") String nome) {
		List<ClienteDto> clientes = clienteService.buscarClientesPorNome(nome);

		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ClienteDto> update(@Valid @RequestBody ClienteDto clienteDto) {
		return ResponseEntity.ok().body(clienteService.update(clienteDto));
	}

}
