package com.company.service.impl;

import com.company.dto.ClienteDto;
import com.company.exception.ModelNotFoundException;
import com.company.mapper.ClienteToClienteDto;
import com.company.model.Cliente;
import com.company.repository.IClienteRepo;
import com.company.service.IClienteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private final IClienteRepo clienteRepo;
    private final ClienteToClienteDto mapper;

    public ClienteService(IClienteRepo clienteRepo, ClienteToClienteDto mapper){
        this.clienteRepo = clienteRepo;
        this.mapper = mapper;
    }

    public List<ClienteDto> buscarTodos(){
        return this.clienteRepo.findAll().stream().map(mapper::map).toList();
    }

    public ClienteDto buscarPorId(Long id){
        Cliente cliente = this.clienteRepo.findById(id).orElseThrow(()-> new ModelNotFoundException("No se encontró al cliente"));
        return this.mapper.map(cliente);
    }
    public ClienteDto guardar(ClienteDto clienteDto){
        Cliente cliente = this.mapper.mapTo(clienteDto);
        Cliente response = this.clienteRepo.save(cliente);
        return this.mapper.map(response);
    }
    public void eliminar(Long id){
        if(this.clienteRepo.findById(id).isEmpty()) throw new ModelNotFoundException("No se encontró al cliente");
        this.clienteRepo.deleteById(id);
    }
}
