package com.co.devsu.cliente.controller;

import com.co.devsu.cliente.dto.ClienteDto;
import com.co.devsu.cliente.dto.ClienteResponse;
import com.co.devsu.cliente.dto.PersonaDto;
import com.co.devsu.cliente.dto.ReportesResponse;
import com.co.devsu.cliente.service.IReportesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/reportes")
@RestController
@AllArgsConstructor
public class ReportesController {
    IReportesService reportesService;

    @GetMapping("/{fechaInicio}/{fechaFin}/{identificacion}")
    public ReportesResponse getReporte(@PathVariable("fechaInicio")LocalDateTime fechaInicio,
                                       @PathVariable("fechaFin")LocalDateTime fechaFin,
                                       @PathVariable("identificacion")String identificacion){
        try {
            PersonaDto personaDto = reportesService.getReportes(fechaInicio,fechaFin,identificacion);
            return ReportesResponse.builder()
                    .persona(personaDto)
                    .mensaje("Se ejecuto correctamente")
                    .build();
        }catch (Exception e){
            return ReportesResponse.builder()
                    .persona(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }

    }
}
