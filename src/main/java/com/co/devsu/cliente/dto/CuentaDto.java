package com.co.devsu.cliente.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class CuentaDto {
    Integer id;
    String numeroCuenta;
    String tipoCuenta;
    Double saldoIncial;
    String estado;
    int idCliente;
    List<MovimientosDto> movimientos;

}
