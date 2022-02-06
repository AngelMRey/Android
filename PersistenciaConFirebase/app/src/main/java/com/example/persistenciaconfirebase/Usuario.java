package com.example.persistenciaconfirebase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private String contrasenia;

    Usuario() {
    }

    Usuario(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Map<String, Object> aniadirUsuarioBaseDatos (){
        Map <String, Object> map = new HashMap<>();

        map.put("usuario", nombre);
        map.put("correo", correo);
        map.put("contraseña", contrasenia);

        return map;
    }
}
