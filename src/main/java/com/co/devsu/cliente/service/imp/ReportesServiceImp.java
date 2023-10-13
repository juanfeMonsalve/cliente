package com.co.devsu.cliente.service.imp;

import com.co.devsu.cliente.dto.*;
import com.co.devsu.cliente.mapper.ClienteMapper;
import com.co.devsu.cliente.mapper.PersonaMapper;
import com.co.devsu.cliente.model.Cliente;
import com.co.devsu.cliente.repository.ClienteRepository;
import com.co.devsu.cliente.repository.PersonaRepository;
import com.co.devsu.cliente.service.IReportesService;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ReportesServiceImp implements IReportesService {
    PersonaRepository personaRepository;
    ClienteRepository clienteRepository;
    ClienteMapper clienteMapper;
    PersonaMapper personaMapper;
    @Override
    public PersonaDto getReportes(LocalDateTime fechaInicio, LocalDateTime fechaFin, String identificacion) throws Exception {
        PersonaDto personaDto = personaMapper.toDto(personaRepository.findById(identificacion).orElseThrow());
        ClienteDto clienteDto =clienteMapper.toDto(clienteRepository.getClienteByPersona(identificacion));
        List<CuentaDto> cuentaDtos = getCuentas(clienteDto.getId());
        cuentaDtos.forEach(cuenta -> {
            cuenta.setMovimientos(getMovimientos(fechaInicio,fechaFin,cuenta.getId()));
        });
        clienteDto.setCuentas(cuentaDtos);
        personaDto.setCliente(clienteDto);
        return personaDto;
    }

    private List<CuentaDto> getCuentas(int idCliente) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CuentasResponse cuentasResponse = restTemplate
                    .getForObject("http://localhost:8081/cuenta/getcuentas/" + idCliente, CuentasResponse.class);

            return Objects.requireNonNull(cuentasResponse).getCuentaDto();
        } catch (HttpClientErrorException | HttpServerErrorException | HttpMessageNotReadableException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al contactarse con el microservicio");
        }
    }
    private List<MovimientosDto> getMovimientos(LocalDateTime fechaInicio, LocalDateTime fechaFin, int idCuenta){
        RestTemplate restTemplate = new RestTemplate();
        MovimientosResponse  response = restTemplate.
                getForObject("http://localhost:8081/movimientos/getmovimientosbyfecha/"+idCuenta+"/"+fechaInicio+"/"+fechaFin
                        ,MovimientosResponse.class);

        return Objects.requireNonNull(response).getMovimientos();
    }
}
