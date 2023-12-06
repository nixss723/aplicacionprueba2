package com.example.myapplication56;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PartidoRepository {




        private DatabaseHelper dbHelper;

        public PartidoRepository(Context context) {
            dbHelper = new DatabaseHelper(context);
        }

        public void insertarPartido(String fecha, String tipoCancha, String hora, String ubicacion) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_FECHA, fecha);
            values.put(DatabaseHelper.COLUMN_TIPO_CANCHA, tipoCancha);
            values.put(DatabaseHelper.COLUMN_HORA, hora);
            values.put(DatabaseHelper.COLUMN_UBICACION, ubicacion);

            db.insert(DatabaseHelper.TABLE_PARTIDOS, null, values);

            db.close();
        }

        public Cursor obtenerTodosLosPartidos() {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String[] columnas = {
                    DatabaseHelper.COLUMN_FECHA,
                    DatabaseHelper.COLUMN_TIPO_CANCHA,
                    DatabaseHelper.COLUMN_HORA,
                    DatabaseHelper.COLUMN_UBICACION
            };

            return db.query(
                    DatabaseHelper.TABLE_PARTIDOS,
                    columnas,
                    null,
                    null,
                    null,
                    null,
                    null
            );
        }
    }


