package com.co.devsu.cliente.service.imp;

import com.co.devsu.cliente.dto.ClienteDto;
import com.co.devsu.cliente.mapper.ClienteMapper;
import com.co.devsu.cliente.model.Cliente;
import com.co.devsu.cliente.repository.ClienteRepository;
import com.co.devsu.cliente.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImp implements IClienteService {
    private final ClienteMapper clienteMapper;

    ClienteRepository clienteRepository;

    @Override
    public ClienteDto getCliente(int idCliente) {
        return clienteMapper.toDto(clienteRepository.findById(idCliente).orElse(null));
    }

    @Override
    public  ClienteDto deleteCliente(int idCliente) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return clienteMapper.toDto(cliente.get());
        }
        throw new Exception("No existe cliente para eliminar");
    }

    @Override
    public ClienteDto updateCliente(ClienteDto clienteDto) throws Exception {

        if (clienteRepository.existsById(clienteDto.getId())){
            clienteRepository.save(clienteMapper.toModel(clienteDto));
            return clienteDto;
        }
        throw new Exception("No existe cliente para actualizar");
    }

    @Override
    public ClienteDto editCliente(ClienteDto clienteDto) throws Exception {
        if (clienteRepository.existsById(clienteDto.getId())){
            clienteRepository.save(clienteMapper.toModel(clienteDto));
            return clienteDto;
        }
        throw new Exception("No existe cliente para editar");
    }

    @Override
    public ClienteDto insertCliente(ClienteDto cuentaDto) {
        Cliente cuenta = clienteRepository.save(clienteMapper.toModel(cuentaDto));
        return clienteMapper.toDto(cuenta);
    }
}


