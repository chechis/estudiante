package com.example.chechis.estudiante.Inicio;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.chechis.estudiante.Inicio.Estructura;

public class BaseDatosInicio extends SQLiteOpenHelper {

    private static final String tipo = " TEXT";
    private static final String coma = ",";

    private static final String Sentencia =
            "CREATE TABLE " + Estructura.EstructuraInicio.TABLE_NAME + " ("
                    + Estructura.EstructuraInicio.COLUMN_NAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraInicio.COLUMN_NAME_NOMBRE + tipo + coma
                    + Estructura.EstructuraInicio.COLUMN_NAME_CONTRA + tipo + coma
                    + Estructura.EstructuraInicio.COLUMN_NAME_ROL + tipo + " )";

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Inicio Estudiante.sqLite";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Estructura.EstructuraInicio.TABLE_NAME;

    public BaseDatosInicio (Activity activity){

        super (activity, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
