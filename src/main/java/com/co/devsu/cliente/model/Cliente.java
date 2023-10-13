package com.co.devsu.cliente.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cliente")
@Getter  @Setter
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "contrasena")
    String contrasena;
    @Column(name = "estado")
    String estado;
    @Column(name = "identificacion")
    String identificacion;

}
