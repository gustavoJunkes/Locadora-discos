package com.godev.locadoradiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.repository.custom.LocacaoRepositoryCustom;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>, LocacaoRepositoryCustom {
}
