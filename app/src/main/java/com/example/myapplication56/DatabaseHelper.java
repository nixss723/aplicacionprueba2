package com.example.myapplication56;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PartidosDB";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PARTIDOS = "partidos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FECHA = "fecha";
    public static final String COLUMN_TIPO_CANCHA = "tipo_cancha";
    public static final String COLUMN_HORA = "hora";
    public static final String COLUMN_UBICACION = "ubicacion";

    private static final String DATABASE_CREATE =
            "create table " + TABLE_PARTIDOS + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_FECHA + " text not null, " +
                    COLUMN_TIPO_CANCHA + " text not null, " +
                    COLUMN_HORA + " text not null, " +
                    COLUMN_UBICACION + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No se realiza ninguna acción en este ejemplo
    }
}

