package com.co.devsu.cliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class CuentasResponse {
    @JsonProperty("cuentaDto")
    List<CuentaDto> cuentaDto;
    @JsonProperty("mensaje")
    String mensaje;
}
