package com.godev.locadoradiscos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.dto.DiscoDto;
import com.godev.locadoradiscos.modelo.Disco;
import com.godev.locadoradiscos.repository.DiscoRepository;

@Service
public class DiscoService {

	@Autowired
	private DiscoRepository repository;

	@Autowired
	private ConversorDto conversorDto;

	public Disco salvar(DiscoDto discoDto) {

		return repository.save(conversorDto.toDiscoEntity(discoDto));

	}

	public List<DiscoDto> getAll() {
		List<Disco> discos = repository.findAll();
		List<DiscoDto> discosDto = new ArrayList<DiscoDto>();

		for (int i = 0; i < discos.size(); i++) {

			discosDto.add(conversorDto.toDiscoDto(discos.get(i)));

		}

		return discosDto;
	}

	public boolean deleteDisco(Long id) {
		Optional<Disco> discoOptional = repository.findById(id);

		if (discoOptional.isPresent()) {
			repository.delete(discoOptional.get());
			return true;
		}

		return false;
	}

}
