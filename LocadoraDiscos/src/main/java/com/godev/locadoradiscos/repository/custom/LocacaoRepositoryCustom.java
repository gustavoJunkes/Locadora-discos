package com.godev.locadoradiscos.repository.custom;

import java.util.Date;
import java.util.List;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Locacao;

public interface LocacaoRepositoryCustom {

	List<Locacao> buscarTodasLocacoesDsl();

	List<Locacao> buscarLocacoesCliente(Cliente cliente);

	void atualizarDataDevolucaoLocacao(Locacao locacao, Date dataDevolucao);

}
