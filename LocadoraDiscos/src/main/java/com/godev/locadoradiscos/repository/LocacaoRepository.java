package com.godev.locadoradiscos.repository;

import com.godev.locadoradiscos.modelo.Locacao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
	
	@Transactional
	Optional<Locacao> findById (Long id);

	@Transactional
	Locacao findByDataLocacao (Date dataLocacao);

	@Query ("SELECT max(locacao.preco) from Locacao locacao")
	Double maiorPrecoDisco();

	@Query("SELECT min(locacao.preco) from Locacao locacao")
	Double menorPrecoDisco();
	
	@Query("SELECT dataDevolucao from Locacao locacao WHERE dataDevolucao > 20/12/2021 and dataDevolucao < 21/12/2021")
	List<Locacao> buscarDevolucoes(Date dataDevolucao);
	
	@Query("SELECT dataLocacao from Locacao locacao WHERE dataLocacao > 20/12/2021 and dataLocacao < 21/12/2021")
	List<Locacao> buscarLocacao(Date dataLocacao);
}
