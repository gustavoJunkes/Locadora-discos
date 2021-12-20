package com.godev.locadoradiscos.controller;

import com.godev.locadoradiscos.dto.LocacaoDto;
import com.godev.locadoradiscos.exception.LocacaoNotFoundException;
import com.godev.locadoradiscos.modelo.Locacao;
import com.godev.locadoradiscos.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<LocacaoDto> save(@RequestBody LocacaoDto locacaoDto){
        return new ResponseEntity<>(locacaoService.save(locacaoDto), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LocacaoDto>> getAll(){
        return new ResponseEntity<>(locacaoService.getAll(), HttpStatus.OK);
    }
    
    @DeleteMapping
    public void delete(@Param("id") Long id) {
    	try {
    		locacaoService.delete(id);
    	}
    	catch (LocacaoNotFoundException ex) {
    		ex.getMessage();
		}
    }
}