package com.godev.locadoradiscos.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Disco;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {

	@Transactional
	Optional<Disco> findById (Long id);

	@Transactional
	List<Disco> findByTitulo (String titulo);

	@Transactional
	Optional<Disco> findByAutor (String autor);
}