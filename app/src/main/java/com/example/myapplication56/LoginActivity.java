package com.example.myapplication56;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    public void signIn(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registro exitoso, puedes hacer algo si es necesario
                            Toast.makeText(LoginActivity.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                        } else {
                            // Si el registro falla, muestra un mensaje al usuario.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Error al registrar usuario.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Inicio de sesión exitoso, actualiza la interfaz de usuario con la información del usuario autenticado
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            // Si el inicio de sesión falla, muestra un mensaje al usuario.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Error al iniciar sesión.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onLogin(View v) {
        EditText email = findViewById(R.id.email);
        EditText contrasenia = findViewById(R.id.contrasenia);

        String emailString = email.getText().toString();
        String passString = contrasenia.getText().toString();

        Log.i("Login Email", emailString);
        Log.i("Login Pass", passString);

        this.login(emailString, passString);
    }

    public void onSignIn(View v) {
        EditText email = findViewById(R.id.email);
        EditText contrasenia = findViewById(R.id.contrasenia);

        String emailString = email.getText().toString();
        String passString = contrasenia.getText().toString();

        this.signIn(emailString, passString);
    }
}


