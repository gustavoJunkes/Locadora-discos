package com.godev.locadoradiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.repository.custom.ClienteRespositoryCustom;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRespositoryCustom {

}
