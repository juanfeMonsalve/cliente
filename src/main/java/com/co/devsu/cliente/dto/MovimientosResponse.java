package com.co.devsu.cliente.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class MovimientosResponse {
    List<MovimientosDto> movimientos;
    String mensaje;
}
