package com.example.myapplication56;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import androidx.appcompat.app.AppCompatActivity;

public class ListarPartidosActivity extends AppCompatActivity {

    private PartidoRepository partidoRepository;
    private Cursor cursor; // Añade esta variable de instancia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_partidos);

        partidoRepository = new PartidoRepository(this);

        // Obtener todos los partidos y mostrarlos en un ListView
        mostrarPartidos();
    }

    private void mostrarPartidos() {
        cursor = partidoRepository.obtenerTodosLosPartidos();

        // Configurar el adaptador para el ListView
        String[] fromColumns = {
                DatabaseHelper.COLUMN_FECHA,
                DatabaseHelper.COLUMN_TIPO_CANCHA,
                DatabaseHelper.COLUMN_HORA,
                DatabaseHelper.COLUMN_UBICACION
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.item_partido,
                cursor,
                fromColumns,
                new int[]{R.id.textFecha, R.id.textTipoCancha, R.id.textHora, R.id.textUbicacion},
                0
        );

        // Configurar el ListView
        ListView listView = findViewById(R.id.listViewPartidos);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cierra el cursor cuando la actividad está siendo destruida
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}

