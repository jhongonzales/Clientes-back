package com.company.controller;

import com.company.dto.ClienteDto;
import com.company.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final IClienteService service;

    public ClienteController(IClienteService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listar(){
        List<ClienteDto> response = this.service.buscarTodos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> listaPorId(@PathVariable Long id){
        ClienteDto response = this.service.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> crear(@Validated @RequestBody ClienteDto request){
        ClienteDto response = this.service.guardar(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDto> modificar(@Validated @RequestBody ClienteDto request){
        ClienteDto response = this.service.guardar(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        this.service.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
