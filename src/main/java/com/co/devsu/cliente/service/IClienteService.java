package com.co.devsu.cliente.service;

import com.co.devsu.cliente.dto.ClienteDto;

public interface IClienteService {
    ClienteDto getCliente(int idCliente);
    ClienteDto deleteCliente(int idCliente) throws Exception;
     ClienteDto updateCliente(ClienteDto clienteDto) throws Exception;
     ClienteDto editCliente(ClienteDto clienteDto) throws Exception;
     ClienteDto insertCliente(ClienteDto cuentaDto);
}
