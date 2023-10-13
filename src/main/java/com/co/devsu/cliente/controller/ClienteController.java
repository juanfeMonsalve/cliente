package com.co.devsu.cliente.controller;

import com.co.devsu.cliente.dto.ClienteDto;
import com.co.devsu.cliente.dto.ClienteResponse;
import com.co.devsu.cliente.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    IClienteService IClienteService;

    @GetMapping("/{idCliente}")
    public ClienteResponse getCliente(@PathVariable int idCliente){
        try {
            ClienteDto clienteDto = IClienteService.getCliente(idCliente);
            return ClienteResponse.builder()
                    .cliente(clienteDto)
                    .mensaje("Se ejecuto correctamente")
                    .build();
        }catch (Exception e){
            return ClienteResponse.builder()
                    .cliente(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PostMapping
    public ClienteResponse createCliente(@RequestBody ClienteDto clienteDto){
        try {
            ClienteDto cliente =
                    IClienteService.insertCliente(clienteDto);
            return ClienteResponse.builder()
                    .cliente(cliente)
                    .mensaje("Se creo correctamente")
                    .build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ClienteResponse.builder()
                    .cliente(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @DeleteMapping("/{idCliente}")
    public ClienteResponse deleteCliente(@PathVariable int idCliente){
        try {
            ClienteDto clienteDto =
                    IClienteService.deleteCliente(idCliente);
            return ClienteResponse.builder()
                    .cliente(clienteDto)
                    .mensaje("Se elimino correctamente")
                    .build();
        }catch (Exception e){
            return ClienteResponse.builder()
                    .cliente(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PutMapping
    public ClienteResponse updateCliente(@RequestBody ClienteDto clienteDto){
        try {
            ClienteDto cliente =
                    IClienteService.updateCliente(clienteDto);
            return ClienteResponse.builder()
                    .cliente(cliente)
                    .mensaje("Se actualizo correctamente")
                    .build();
        }catch (Exception e){
            return ClienteResponse.builder()
                    .cliente(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PatchMapping
    public ClienteResponse editCliente(@RequestBody ClienteDto clienteDto){
        try {
            ClienteDto cliente =
                    IClienteService.editCliente(clienteDto);
            return ClienteResponse.builder()
                    .cliente(cliente)
                    .mensaje("Se actualizo correctamente")
                    .build();
        }catch (Exception e){
            return ClienteResponse.builder()
                    .cliente(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
}
