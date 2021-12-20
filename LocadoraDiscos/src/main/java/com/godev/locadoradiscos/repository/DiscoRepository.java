package com.godev.locadoradiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godev.locadoradiscos.modelo.Disco;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {

}
