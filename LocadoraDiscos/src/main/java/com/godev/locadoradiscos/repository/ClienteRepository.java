package com.godev.locadoradiscos.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.repository.custom.ClienteRespositoryCustom;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRespositoryCustom {

	@Transactional
	Optional<Cliente> findByCpf (String cpf);

	@Transactional
	Optional<Cliente> findById (Long id);

	List<Cliente> findByName(String nome);

}
