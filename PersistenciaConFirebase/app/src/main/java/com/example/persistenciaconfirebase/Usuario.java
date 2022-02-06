package com.example.persistenciaconfirebase;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String correo;
    private String contrasenia;

    public Usuario() {

    }

    public Usuario(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
}
