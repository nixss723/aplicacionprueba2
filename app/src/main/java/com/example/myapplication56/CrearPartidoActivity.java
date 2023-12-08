package com.example.myapplication56;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class CrearPartidoActivity extends AppCompatActivity {

    private PartidoRepository partidoRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);

        partidoRepository = new PartidoRepository(this);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Spinner spinnerTipoCancha = findViewById(R.id.spinnerTipoCancha);
        TimePicker timePicker = findViewById(R.id.timePicker);
        EditText editUbicacion = findViewById(R.id.editUbicacion);
        Button btnCrearPartido = findViewById(R.id.btnCrearPartido);
        Button btnVolver = findViewById(R.id.btnVolver);


        btnCrearPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fechaPartido = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                String tipoCancha = spinnerTipoCancha.getSelectedItem().toString();
                String horaPartido = timePicker.getHour() + ":" + timePicker.getMinute();
                String ubicacionPartido = editUbicacion.getText().toString();

                // Insertar datos en la base de datos usando el repositorio
                partidoRepository.insertarPartido(fechaPartido, tipoCancha, horaPartido, ubicacionPartido);

                mostrarMensaje("Partido creado con Éxito! ");

                // Abrir la actividad ListarPartidosActivity

            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Volver al MainActivity
                Intent intent = new Intent(CrearPartidoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }



    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
