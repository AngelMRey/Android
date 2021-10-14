package com.example.prueba1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.botonInicio);
        EditText nombreEditText = findViewById(R.id.nombre);
        EditText apelllidosEditText = findViewById(R.id.apellidos);
        EditText numeroEditText = findViewById(R.id.numero);
        EditText emailEditText = findViewById(R.id.email);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario(nombreEditText.getText().toString(), apelllidosEditText.getText().toString(), Integer.parseInt(numeroEditText.getText().toString()), emailEditText.getText().toString());

                Intent intent = new Intent(MainActivity.this, MostrarInfo.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }
}