package com.example.prueba1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info);

        TextView nombreUser = findViewById(R.id.nombre_user);
        TextView apellidosUser = findViewById(R.id.apellidos_user);
        TextView numeroUser = findViewById(R.id.numero_user);
        TextView emailUser = findViewById(R.id.email_user);

        Intent intent = getIntent();

        Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");

        nombreUser.setText(usuario.getNombre());
        apellidosUser.setText(usuario.getApellidos());
        numeroUser.setText(usuario.getNumero());
        emailUser.setText(usuario.getEmail());
    }
}