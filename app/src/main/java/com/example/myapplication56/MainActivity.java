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

        Button btnCrearPartido = findViewById(R.id.btnCrearPartido);
        Button btnVerPartidos = findViewById(R.id.btnVerPartidos);



        btnCrearPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
