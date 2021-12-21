package com.godev.locadoradiscos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.dto.DiscoDto;
import com.godev.locadoradiscos.exception.DiscoNotFoundException;
import com.godev.locadoradiscos.modelo.Disco;
import com.godev.locadoradiscos.repository.DiscoRepository;


@Service
public class DiscoService {

	@Autowired
	private DiscoRepository repository;

	@Autowired
	private ConversorDto conversorDto;

	public DiscoDto save(DiscoDto discoDto) {
		Disco disco = conversorDto.toDiscoEntity(discoDto);
		disco = repository.save(disco);
		return conversorDto.toDiscoDto(disco);
	}

	public List<DiscoDto> getAll() {
		List<Disco> discos = repository.findAll();
		List<DiscoDto> discosDto = new ArrayList<DiscoDto>();

		for (int i = 0; i < discos.size(); i++) {

			discosDto.add(conversorDto.toDiscoDto(discos.get(i)));

		}

		return discosDto;
	}

	public void delete(Long id) throws DiscoNotFoundException{
		Optional<Disco> discoOptional = repository.findById(id);

		if (discoOptional.isPresent()) {
			repository.delete(discoOptional.get());
		}
		throw new DiscoNotFoundException();
	}

	public DiscoDto getById(Long id) throws DiscoNotFoundException{
		Optional<Disco> disco = repository.findById(id);

		if(disco.isPresent()){
			return conversorDto.toDiscoDto(disco.get());
		}else throw new DiscoNotFoundException();
	}
	
//	public List<DiscoDto> buscarDiscoPeloTitulo(String titulo){
//		List<Disco>
//	}


}
