package com.co.devsu.cliente.repository;

import com.co.devsu.cliente.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,String> {
}
