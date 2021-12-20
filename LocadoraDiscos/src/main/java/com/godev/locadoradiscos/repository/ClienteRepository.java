package com.godev.locadoradiscos.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Transactional
	Cliente findByNome (String nome);
	
	@Transactional
	Cliente findByCpf (String cpf);
	
	@Transactional
	Optional<Cliente> findById (Long id);

}
