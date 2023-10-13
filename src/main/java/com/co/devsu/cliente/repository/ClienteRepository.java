package com.co.devsu.cliente.repository;

import com.co.devsu.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Query(nativeQuery = true,
            value = "select * from cliente where identificacion = ?1")
    Cliente getClienteByPersona(String identificacion);
}
