package com.godev.locadoradiscos.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.dto.LocacaoDto;
import com.godev.locadoradiscos.exception.LocacaoNotFoundException;
import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.repository.ClienteRepository;
import com.godev.locadoradiscos.repository.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ConversorDto conversorDto;

	public LocacaoDto save(LocacaoDto locacaoDto) {
		Locacao locacao = new Locacao();
		locacao = locacaoRepository.save(conversorDto.toLocacaoEntity(locacaoDto));
		return conversorDto.toLocacaoDto(locacao);
	}

	public List<LocacaoDto> getAll() {
		List<Locacao> locacoes = locacaoRepository.buscarTodasLocacoesDsl();
		List<LocacaoDto> locacaoesDto = new ArrayList<>();

		for (int i = 0; i < locacoes.size(); i++) {
			locacaoesDto.add(conversorDto.toLocacaoDto(locacoes.get(i)));
		}
		return locacaoesDto;
	}

	public void delete(Long id) throws LocacaoNotFoundException {

		final Optional<Locacao> locacaoOptional = locacaoRepository.findById(id);

		if (locacaoOptional.isPresent()) {
			locacaoRepository.delete(locacaoOptional.get());
		}

		throw new LocacaoNotFoundException();
	}

	public List<LocacaoDto> buscarLocacoesCliente(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		List<Locacao> locacoes = locacaoRepository.buscarLocacoesCliente(cliente.get());
		List<LocacaoDto> locacoesDto = new ArrayList();

		for (int i = 0; i < locacoes.size(); i++) {
			locacoesDto.add(conversorDto.toLocacaoDto(locacoes.get(i)));
		}

		return locacoesDto;
	}

	public LocacaoDto buscarPorId(Long id) throws LocacaoNotFoundException {
		Optional<Locacao> locacao = locacaoRepository.findById(id);

		if (locacao.isPresent()) {
			return conversorDto.toLocacaoDto(locacao.get());
		} else {
			throw new LocacaoNotFoundException();
		}
	}
	
	public List<LocacaoDto> buscarDataLocacao(Date dataLocacao){
		List<Locacao> locacoes = locacaoRepository.findByDataLocacao(dataLocacao);
		List<LocacaoDto> locacoesDto = new ArrayList<LocacaoDto>();
		
		for (int i = 0; i < locacoes.size(); i++) {
			locacoesDto.add(conversorDto.toLocacaoDto(locacoes.get(i)));
		}
		return locacoesDto;
	}
	
	public Double maiorPrecoLocacao(){
		Double precoMaior = locacaoRepository.maiorPrecoLocacao();
		return precoMaior;
	}
}
