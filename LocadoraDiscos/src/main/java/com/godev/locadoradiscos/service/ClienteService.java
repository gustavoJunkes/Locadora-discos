package com.godev.locadoradiscos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godev.locadoradiscos.dto.ClienteDto;
import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.exception.ClienteNotFoundException;
import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ConversorDto conversorDto;

	public ClienteDto save(ClienteDto clienteDto) {

		conversorDto.toClienteEntity(clienteDto);

		Cliente cliente = conversorDto.toClienteEntity(clienteDto);

		cliente = repository.save(cliente);

		return conversorDto.toClienteDto(cliente);
	}

	public List<ClienteDto> getAll() {
		List<Cliente> clientes = repository.findAll();
		List<ClienteDto> clientesDto = new ArrayList<>();

		for (int i = 0; i < clientes.size(); i++) {
			clientesDto.add(conversorDto.toClienteDto(clientes.get(i)));
		}
		return clientesDto;
	}

	public void delete(Long id) throws ClienteNotFoundException {
		final Optional<Cliente> cliente = repository.findById(id);

		if (cliente.isPresent()) {
			repository.delete(cliente.get());
		} else {
			throw new ClienteNotFoundException();
		}
	}

	public ClienteDto getById(Long id) throws ClienteNotFoundException {
		Optional<Cliente> cliente = repository.findById(id);

		if (cliente.isPresent()) {
			return conversorDto.toClienteDto(cliente.get());
		} else {
			throw new ClienteNotFoundException();
		}
	}

	public void alterar() {

	}

}
