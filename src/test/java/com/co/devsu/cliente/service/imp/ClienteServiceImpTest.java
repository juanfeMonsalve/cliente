package com.co.devsu.cliente.service.imp;

import com.co.devsu.cliente.dto.ClienteDto;
import com.co.devsu.cliente.mapper.ClienteMapper;
import com.co.devsu.cliente.model.Cliente;
import com.co.devsu.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceImpTest {
    @Mock
    ClienteRepository clienteRepository;
    @Mock
    ClienteMapper clienteMapper;
    @InjectMocks
    ClienteServiceImp clienteServiceImp;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void editCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setContrasena("123");
        cliente.setId(1);
        cliente.setEstado("Activo");
        cliente.setIdentificacion("1040755354");

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdentificacion("1040755354");
        clienteDto.setContrasena("123");
        clienteDto.setId(1);
        clienteDto.setEstado("Activo");

        Mockito.when(clienteRepository.existsById(1)).thenReturn(true);
        Mockito.when(clienteRepository.save(Mockito.any())).thenReturn(cliente);
        Mockito.when(clienteMapper.toModel(Mockito.any())).thenReturn(cliente);

        assertEquals(clienteServiceImp.editCliente(clienteDto), clienteDto);
    }
}