package com.example.persistenciaconfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        EditText correoUsuario = findViewById(R.id.correo_login);
        EditText contraUsuario = findViewById(R.id.contra_login);
        Button botonLogIn = findViewById(R.id.boton_log_in);
        Button botonRegistro = findViewById(R.id.boton_ir_register);



        botonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicarSesion(correoUsuario.getText().toString(), contraUsuario.getText().toString());
                Intent intent = new Intent(MainActivity.this, Inicio.class);
                startActivity(intent);
            }
        });

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });
    }

    public void onStart(){
        super.onStart();

        FirebaseUser usuarioActual = mAuth.getCurrentUser();
        if (usuarioActual != null){
            Intent intent = new Intent(MainActivity.this, Inicio.class);
            startActivity(intent);
        }
    }

    private void inicarSesion(String correo, String contra) {
        mAuth.signInWithEmailAndPassword(correo, contra)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(MainActivity.this, "Sesion iniciada correctamente", Toast.LENGTH_LONG).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Fallo al inicar sesión", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}