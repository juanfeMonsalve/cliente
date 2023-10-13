package com.co.devsu.cliente.mapper;

import com.co.devsu.cliente.dto.PersonaDto;
import com.co.devsu.cliente.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDto toDto(Persona persona);

}

