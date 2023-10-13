package com.co.devsu.cliente.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter @Getter
public class ReportesResponse {
    PersonaDto persona;
    String mensaje;
}
