package com.example.prueba1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.botonInicio);
        EditText aniadirTexto = findViewById(R.id.editText);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String introducirTexto = aniadirTexto.getText().toString();
                //Buscar info de intent en android
                Intent intent = new Intent(MainActivity.this, MostrarInfo.class);
                intent.putExtra("introducir", introducirTexto);
                startActivity(intent);
            }
        });
    }
}