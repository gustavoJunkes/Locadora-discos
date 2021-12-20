package com.godev.locadoradiscos.dto;

import java.util.Date;
import java.util.List;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Disco;

public class LocacaoDto {

	public Long id;
	//deveria guardar o objeto ou o id do mesmo?
	public List<Disco> discos;
	public List<Cliente> clientes;
	public Date dataLocacao;
	public Date dataDevolucao;
	public Double preco;
}
