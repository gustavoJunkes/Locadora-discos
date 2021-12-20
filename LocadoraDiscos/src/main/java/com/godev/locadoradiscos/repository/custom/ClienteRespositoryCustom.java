package com.godev.locadoradiscos.repository.custom;

import java.util.List;

import com.godev.locadoradiscos.modelo.Cliente;

public interface ClienteRespositoryCustom {

	List<Cliente> buscarTodosClientes();

	Cliente buscarClientePorNome(String nome);

}
