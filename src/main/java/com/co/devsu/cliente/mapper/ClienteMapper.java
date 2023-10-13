package com.co.devsu.cliente.mapper;

import com.co.devsu.cliente.dto.ClienteDto;
import com.co.devsu.cliente.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDto toDto(Cliente cliente);
    Cliente toModel(ClienteDto clienteDto);


}

