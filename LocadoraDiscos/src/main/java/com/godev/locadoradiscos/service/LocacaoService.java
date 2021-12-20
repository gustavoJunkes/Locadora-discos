package com.godev.locadoradiscos.service;

import com.godev.locadoradiscos.dto.ConversorDto;
import com.godev.locadoradiscos.dto.LocacaoDto;
import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
