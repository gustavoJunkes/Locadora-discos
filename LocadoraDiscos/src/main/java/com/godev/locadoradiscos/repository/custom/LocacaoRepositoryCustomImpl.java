package com.godev.locadoradiscos.repository.custom;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.modelo.QLocacao;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class LocacaoRepositoryCustomImpl implements LocacaoRepositoryCustom {

	public static final QLocacao Q_LOCACAO = QLocacao.locacao;

	private JPAQueryFactory _buildQueryFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.godev.locadoradiscos");
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);

		return queryFactory;
	}

	@Override
	public List<Locacao> buscarTodasLocacoesDsl() {
		List<Locacao> locacoes = _buildQueryFactory().selectFrom(Q_LOCACAO).fetch();
		return locacoes;
	}

	@Override
	public List<Locacao> buscarLocacoesCliente(Cliente cliente) {
		List<Locacao> locacoesCliente = _buildQueryFactory().selectFrom(Q_LOCACAO)//
				.where(Q_LOCACAO.clientes.contains(cliente)).fetch();
		return locacoesCliente;
	}

	@Override
	public void atualizarDataDevolucaoLocacao(Locacao locacao, Date dataDevolucao) {
		_buildQueryFactory().update(Q_LOCACAO).where(Q_LOCACAO.id.eq(locacao.getId()))
				.set(Q_LOCACAO.dataDevolucao, dataDevolucao).execute();
	}

}
