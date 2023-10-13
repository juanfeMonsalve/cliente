package com.co.devsu.cliente.service;

import com.co.devsu.cliente.dto.ClienteDto;
import com.co.devsu.cliente.dto.PersonaDto;

import java.time.LocalDateTime;

public interface IReportesService {

    PersonaDto getReportes(LocalDateTime fechaInicio, LocalDateTime fechaFin, String identificacion) throws Exception;
}
