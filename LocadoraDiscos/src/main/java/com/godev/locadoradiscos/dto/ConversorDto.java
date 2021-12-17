package com.godev.locadoradiscos.dto;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Disco;

public class ConversorDto {

	public ClienteDto toClienteDto(Cliente cliente) {
		ClienteDto dto = new ClienteDto();
		dto.id = cliente.getId();
		dto.nome = cliente.getNome();
		dto.cpf = cliente.getCpf();
		dto.telefone = cliente.getTelefone();

		return dto;
	}

	public DiscoDto toDiscoDto(Disco disco) {
		DiscoDto dto = new DiscoDto();

		dto.categoria = disco.getCategoria();
		dto.id = disco.getId();
		dto.duracao = disco.getDuracao();
		dto.titulo = disco.getTitulo();
		dto.autor = disco.getAutor();
		return dto;
	}

	public Cliente toClienteEntity(ClienteDto dto) {
		Cliente cliente = new Cliente();

		cliente.setId(dto.id);
		cliente.setCpf(dto.cpf);
		cliente.setNome(dto.nome);
		cliente.setTelefone(dto.telefone);

		return cliente;
	}

	public Disco toDiscoEntity(DiscoDto dto) {
		Disco disco = new Disco();

		disco.setCategoria(dto.categoria);
		disco.setId(dto.id);
		disco.setDuracao(dto.duracao);
		disco.setTitulo(dto.titulo);
		disco.setAutor(dto.autor);

		return disco;
	}

}
