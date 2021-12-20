package com.godev.locadoradiscos.controller;

import com.godev.locadoradiscos.dto.ClienteDto;
import com.godev.locadoradiscos.dto.DiscoDto;
import com.godev.locadoradiscos.exception.ClienteNotFoundException;
import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.service.ClienteService;
import com.godev.locadoradiscos.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

//    juntar métodos em um só

    @GetMapping(value = "/all")
    public ResponseEntity<List<ClienteDto>> all(){
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
    }

    //tratar exceptions no controller usando exception handler

    @GetMapping
    public ResponseEntity<ClienteDto> getById(@Param("id") Long id)  {

        ClienteDto cliente = new ClienteDto();

       try {
           cliente = clienteService.getById(id);

       }catch (ClienteNotFoundException ex){
           ex.getMessage();
       }finally {
           return new ResponseEntity<> (cliente, HttpStatus.OK);
       }

    }
    @DeleteMapping
    public void delete(@Param("id") Long id){
        try {
            clienteService.delete(id);
        }catch (ClienteNotFoundException ex){
            ex.getMessage();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto clienteDto){
        return new ResponseEntity<> (clienteService.save(clienteDto), HttpStatus.OK);
    }

    //adicionar método update.

}
