package com.godev.locadoradiscos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godev.locadoradiscos.dto.ClienteDto;
import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ConversorDto conversorDto;

	public ClienteDto salvar(ClienteDto clienteDto) {

		conversorDto.toClienteEntity(clienteDto);

		Cliente cliente = conversorDto.toClienteEntity(clienteDto);

		cliente = repository.save(cliente);

		return conversorDto.toClienteDto(cliente);
	}
}
