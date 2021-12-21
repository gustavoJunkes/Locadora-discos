package com.godev.locadoradiscos.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.repository.custom.LocacaoRepositoryCustom;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>, LocacaoRepositoryCustom {
	
	@Transactional
	Optional<Locacao> findById (Long id);

	@Transactional
	List<Locacao> findByDataLocacao (Date dataLocacao);

	@Query ("SELECT max(locacao.preco) from Locacao locacao")
	Double maiorPrecoLocacao();

	@Query("SELECT min(locacao.preco) from Locacao locacao")
	Double menorPrecoLocacao();

}