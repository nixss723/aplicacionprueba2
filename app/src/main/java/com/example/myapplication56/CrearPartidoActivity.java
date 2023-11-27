package com.example.myapplication56;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);


        DatePicker datePicker = findViewById(R.id.datePicker);
        Spinner spinnerTipoCancha = findViewById(R.id.spinnerTipoCancha);
        TimePicker timePicker = findViewById(R.id.timePicker);
        EditText editUbicacion = findViewById(R.id.editUbicacion);
        Button btnCrearPartido = findViewById(R.id.btnCrearPartido);


        btnCrearPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fechaPartido = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                String tipoCancha = spinnerTipoCancha.getSelectedItem().toString();
                String horaPartido = timePicker.getHour() + ":" + timePicker.getMinute();
                String ubicacionPartido = editUbicacion.getText().toString();


                mostrarMensaje("Partido creado con Exito! ");
            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
