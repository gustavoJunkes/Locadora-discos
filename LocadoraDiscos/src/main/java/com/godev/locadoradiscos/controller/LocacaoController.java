package com.godev.locadoradiscos.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godev.locadoradiscos.dto.LocacaoDto;
import com.godev.locadoradiscos.exception.LocacaoNotFoundException;
import com.godev.locadoradiscos.service.LocacaoService;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	@PostMapping
	public ResponseEntity<LocacaoDto> save(@RequestBody LocacaoDto locacaoDto) {
		return new ResponseEntity<>(locacaoService.save(locacaoDto), HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<LocacaoDto>> getAll() {
		return new ResponseEntity<>(locacaoService.getAll(), HttpStatus.OK);
	}

	@DeleteMapping
	public void delete(@Param("id") Long id) {
		try {
			locacaoService.delete(id);
		} catch (LocacaoNotFoundException ex) {
			ex.getMessage();
		}
	}

	@GetMapping(value = "/cliente")
	public ResponseEntity<List<LocacaoDto>> buscarLocacoesCliente(@Param("id") Long id) {
		return new ResponseEntity<>(locacaoService.buscarLocacoesCliente(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<LocacaoDto> buscarPorId(@Param("id") Long id) throws LocacaoNotFoundException {
		return new ResponseEntity<>(locacaoService.buscarPorId(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/datalocacao")
	public ResponseEntity<List<LocacaoDto>> buscarDataLocacao(@RequestParam("dataLocacao") Date dataLocacao){
		List<LocacaoDto> locacoes = locacaoService.buscarDataLocacao(dataLocacao);
		
		return new ResponseEntity<>(locacoes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/precomax")
	public Double maiorPrecoDisco(@RequestParam("preco")Double preco){
		Double locacoes = locacaoService.maiorPrecoLocacao();
		return locacoes;
	}
	
	@GetMapping(value = "/precomin")
	public Double menorPrecoDisco(@RequestParam("preco")Double preco) {
		Double locacoes = locacaoService.menorPrecoLocacao();
		return locacoes;
	}
}