package com.example.myapplication56;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;

// ...

public class CrearPartidoActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);

        dbHelper = new DatabaseHelper(this);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Spinner spinnerTipoCancha = findViewById(R.id.spinnerTipoCancha);
        TimePicker timePicker = findViewById(R.id.timePicker);
        EditText editUbicacion = findViewById(R.id.editUbicacion);
        Button btnCrearPartido = findViewById(R.id.btnCrearPartido);


        // ...
        btnCrearPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fechaPartido = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                String tipoCancha = spinnerTipoCancha.getSelectedItem().toString();
                String horaPartido = timePicker.getHour() + ":" + timePicker.getMinute();
                String ubicacionPartido = editUbicacion.getText().toString();

                // Insertar datos en la base de datos
                insertarPartido(fechaPartido, tipoCancha, horaPartido, ubicacionPartido);

                mostrarMensaje("Partido creado con Éxito! ");
            }
        });

        // ...
    }

    private void insertarPartido(String fecha, String tipoCancha, String hora, String ubicacion) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FECHA, fecha);
        values.put(DatabaseHelper.COLUMN_TIPO_CANCHA, tipoCancha);
        values.put(DatabaseHelper.COLUMN_HORA, hora);
        values.put(DatabaseHelper.COLUMN_UBICACION, ubicacion);

        db.insert(DatabaseHelper.TABLE_PARTIDOS, null, values);

        db.close();
    }

    // ...
}

