package com.godev.locadoradiscos.service;

import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.dto.LocacaoDto;
import com.godev.locadoradiscos.exception.LocacaoNotFoundException;
import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.repository.LocacaoRepository;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private ConversorDto conversorDto;

    public LocacaoDto save(LocacaoDto locacaoDto){
        Locacao locacao = new Locacao();
        locacao = locacaoRepository.save(conversorDto.toLocacaoEntity(locacaoDto));
        return conversorDto.toLocacaoDto(locacao);
    }

    public List<LocacaoDto> getAll(){
        List<Locacao> locacoes = locacaoRepository.findAll();
        List<LocacaoDto> locacaoesDto = new ArrayList<>();

        for (int i = 0; i < locacoes.size(); i++){
            locacaoesDto.add(conversorDto.toLocacaoDto(locacoes.get(i)));
        }
        return locacaoesDto;
    }
    
    public void delete(Long id) throws LocacaoNotFoundException{

    	final Optional<Locacao> locacaoOptional = locacaoRepository.findById(id);
    	
    	if(locacaoOptional.isPresent()) {
    		locacaoRepository.delete(locacaoOptional.get());
    	}
    	
    	throw new LocacaoNotFoundException();
    }
    
    

}
