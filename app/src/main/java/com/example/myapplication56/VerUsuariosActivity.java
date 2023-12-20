package com.example.myapplication56;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VerUsuariosActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView nombreTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);

        mAuth = FirebaseAuth.getInstance();
        emailTextView = findViewById(R.id.emailTextView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerUsuariosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        Button btnVerUsuarios = findViewById(R.id.btnVerUsuarios);
        btnVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verUsuarios();
            }
        });

        // Verificar si el usuario está autenticado
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // El usuario está autenticado
            // Que informacion se muestra :
            String email = currentUser.getEmail();



            emailTextView.setText("Email: " + (email != null ? email : ""));
        } else {
            // El usuario no está autenticado, realizar acciones correspondientes (iniciar sesión, etc.)
            // Puedes redirigir a la pantalla de inicio de sesión, por ejemplo
        }
    }

    private void verUsuarios() {

        Toast.makeText(this, "Ver usuarios", Toast.LENGTH_SHORT).show();
    }
}