package com.example.myapplication56;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Ejemplo: Obtener el nombre del usuario (reemplaza esto con tu lógica de autenticación)
        String nombreUsuario = "Juan"; // Aquí debes obtener el nombre del usuario autenticado

        // Mostrar el saludo en el TextView
        TextView textHolaUsuario = findViewById(R.id.textHolaUsuario);
        textHolaUsuario.setText("HOLA " + nombreUsuario);

        // Manejar clics en los botones de opciones
        Button btnCrearPartido = findViewById(R.id.btnCrearPartido);
        Button btnVerPartidos = findViewById(R.id.btnVerPartidos);

        btnCrearPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para la opción "CREAR PARTIDO"
                Intent intent = new Intent(MainActivity.this, CrearPartidoActivity.class);
                startActivity(intent);
            }
        });

        btnVerPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para la opción "VER PARTIDOS"
            }
        });
    }
}
