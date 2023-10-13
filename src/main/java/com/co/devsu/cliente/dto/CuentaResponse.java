package com.co.devsu.cliente.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Builder
public class CuentaResponse {
    CuentaDto cuentaDto;
    String mensaje;
}
