package com.godev.locadoradiscos.controller;


import com.godev.locadoradiscos.dto.DiscoDto;
import com.godev.locadoradiscos.exception.DiscoNotFoundException;
import com.godev.locadoradiscos.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<> (discoService.save(discoDto),HttpStatus.OK);
    }

    @GetMapping(value = "/titulo")
    public ResponseEntity<DiscoDto> buscarDiscoPeloTitulo(@RequestParam("titulo") String titulo){
    	DiscoDto disco = new DiscoDto();
    	return new ResponseEntity<DiscoDto>(disco, HttpStatus.OK);
    }
    
    @GetMapping(value = "/autor")
    public ResponseEntity<DiscoDto> getByAutor(@RequestParam("autor") String autor){
    	DiscoDto discoDto = new DiscoDto();
    	
    	try {
    		discoDto = discoService.getByAutor(autor);
    	}catch (DiscoNotFoundException exc) {
			exc.getMessage();
		}finally {
			return new ResponseEntity<>(discoDto, HttpStatus.OK);
		}
    }
    
    
    
}
