package com.example.prueba1;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellidos;
    private int numero;
    private String email;


    public Usuario() {

    }

    public Usuario(String nombre,String apellidos, int numero, String email){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
        this.email = email;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
