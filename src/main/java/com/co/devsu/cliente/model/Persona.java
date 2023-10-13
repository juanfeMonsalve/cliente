package com.co.devsu.cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "persona")
@Getter @Setter
public class Persona {
    @Id
    @Column(name = "identificacion")
    String identificacion;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "genero")
    String genero;
    @Column(name = "edad")
    int edad;
}
