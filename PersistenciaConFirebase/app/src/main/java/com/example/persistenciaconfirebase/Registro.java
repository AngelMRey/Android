package com.example.persistenciaconfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        EditText correoUsuario = findViewById(R.id.correo_registro);
        EditText contraUsuario = findViewById(R.id.contra_registro);
        EditText confirmacionContra = findViewById(R.id.comfirmar_contra_registro);
        Button botonRegistro = findViewById(R.id.registrarse);

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (confirmacionContra.getText().toString().equals(contraUsuario.getText().toString()) && contraUsuario.getText().toString().length() >= 8){
                    registrarUsuario(correoUsuario.getText().toString(), contraUsuario.getText().toString());
                    Intent intent = new Intent(Registro.this, Inicio.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Registro.this, "Error, fallo en el registro", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void registrarUsuario(String correo, String contra){

        mAuth.createUserWithEmailAndPassword(correo, contra)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Registro.this, "Registro realizado con éxito", Toast.LENGTH_LONG).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        try {
                            aniadirNuevoUsuario(user.getUid(), correo, contra);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Registro.this, "Error en el registro", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void aniadirNuevoUsuario(String uid, String correo, String contra){
        Usuario usuario = new Usuario(correo, contra);

        myRef.child("Usuarios").child(uid).setValue(usuario);
    }
}