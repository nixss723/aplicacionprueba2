
package com.example.myapplication56;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class ListarPartidosActivity extends AppCompatActivity {

    private PartidoRepository partidoRepository;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_partidos);

        partidoRepository = new PartidoRepository(this);

        mostrarPartidos();

        Button btnVolverList = findViewById(R.id.btnVolverList);
        btnVolverList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Volver al MainActivity
                Intent intent = new Intent(ListarPartidosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void mostrarPartidos() {
        cursor = partidoRepository.obtenerTodosLosPartidos();

        String[] fromColumns = {
                DatabaseHelper.COLUMN_FECHA,
                DatabaseHelper.COLUMN_TIPO_CANCHA,
                DatabaseHelper.COLUMN_HORA,
                DatabaseHelper.COLUMN_UBICACION
        };

        int[] toViews = {
                R.id.textFecha,
                R.id.textTipoCancha,
                R.id.textHora,
                R.id.textUbicacion
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.item_partido,
                cursor,
                fromColumns,
                toViews,
                0
        );

        ListView listView = findViewById(R.id.listViewPartidos);
        listView.setAdapter(adapter);
    }

    public void eliminarPartido(View view) {

        int idDelPartido = obtenerIdPartidoDesdeCursor(view);

        if (idDelPartido != -1) {
            partidoRepository.eliminarPartido(idDelPartido);

            mostrarPartidos();
        }
    }


    private int obtenerIdPartidoDesdeCursor(View view) {
       int columnIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);

        if (columnIndex != -1) {
            int position = ((ListView) findViewById(R.id.listViewPartidos)).getPositionForView(view);

            if (cursor.moveToPosition(position)) {
                return cursor.getInt(columnIndex);
            }
        }

        return -1;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}