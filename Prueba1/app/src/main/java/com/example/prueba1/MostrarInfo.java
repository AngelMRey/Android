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

        Intent intent = getIntent();
        String introducirTexto = intent.getStringExtra("introducir");

        TextView mostrarTexto = findViewById(R.id.resultadoIntent);
    }
}