package com.co.devsu.cliente.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
public class ClienteDto {

    Integer id;

    String contrasena;

    String estado;
    String identificacion;
    List<CuentaDto> cuentas;
}
