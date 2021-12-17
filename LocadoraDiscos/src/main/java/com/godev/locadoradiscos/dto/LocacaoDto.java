package com.godev.locadoradiscos.dto;

import java.util.Date;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Disco;

public class LocacaoDto {

	public Long id;

	public String categoria;
	public Disco disco;
	public Cliente cliente;
	public Date dataLocacao;
	public Date dataDevolucao;
	public float preco;
}
