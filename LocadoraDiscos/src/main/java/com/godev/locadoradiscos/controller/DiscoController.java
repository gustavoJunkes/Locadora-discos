package com.godev.locadoradiscos.controller;


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
import org.springframework.web.bind.annotation.RestController;

import com.godev.locadoradiscos.dto.DiscoDto;
import com.godev.locadoradiscos.exception.DiscoNotFoundException;
import com.godev.locadoradiscos.service.DiscoService;

@RestController
@RequestMapping("/disco")
public class DiscoController {

    @Autowired
    private DiscoService discoService;

//    juntar métodos em um só

    @GetMapping(value = "/all")
    public ResponseEntity<List<DiscoDto>> all(){
        return new ResponseEntity<>(discoService.getAll(), HttpStatus.OK);
    }

    //tratar exceptions no controller usando exception handler

    @GetMapping
    public ResponseEntity<DiscoDto> getById(@Param("id") Long id)  {

        DiscoDto disco = new DiscoDto();

       try {
           disco = discoService.getById(id);

       }catch (DiscoNotFoundException ex){
           ex.getMessage();
       }finally {
           return new ResponseEntity<> (disco, HttpStatus.OK);
       }

    }
    @DeleteMapping
    public void delete(@Param("id") Long id){
        try {
            discoService.delete(id);
        }catch (DiscoNotFoundException ex){
            ex.getMessage();
        }
    }

    @PostMapping
    public ResponseEntity<DiscoDto> save(@RequestBody DiscoDto discoDto){
        return new ResponseEntity<> (discoService.save(discoDto), HttpStatus.OK);
    }

    //adicionar método update.

}
