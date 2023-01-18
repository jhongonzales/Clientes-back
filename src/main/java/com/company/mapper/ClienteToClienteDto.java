package com.company.mapper;


import com.company.dto.ClienteDto;
import com.company.model.Cliente;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClienteToClienteDto implements Mapper<ClienteDto, Cliente>{

    @Override
    public ClienteDto map(Cliente origen) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(origen.getIdCliente());
        clienteDto.setNombre(origen.getNombre());
        clienteDto.setApellido(origen.getApellido());
        clienteDto.setEmail(origen.getEmail());
        return clienteDto;
    }

    public Cliente mapTo(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDto.getIdCliente());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setCreateAt(LocalDateTime.now());
        return cliente;
    }

}