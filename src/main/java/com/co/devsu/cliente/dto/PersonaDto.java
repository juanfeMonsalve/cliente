package com.co.devsu.cliente.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PersonaDto {

    String identificacion;
    String nombre;
    String genero;
    int edad;
    ClienteDto cliente;
}
