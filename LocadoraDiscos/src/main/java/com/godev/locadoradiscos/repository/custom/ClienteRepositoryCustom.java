package com.godev.locadoradiscos.repository.custom;

import java.util.List;

import com.godev.locadoradiscos.modelo.Cliente;

public interface ClienteRepositoryCustom {

	List<Cliente> buscarTodosClientes();

	List<Cliente> buscarClientePorNome(String nome);

}
