package com.example.chechis.estudiante.Inicio;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class ServicioInicio {

    private String nombre;
    private String contrasena;
    private String rol;
    private Activity activity;

    public ServicioInicio(String nombre, String contrasena, String rol, Activity activity) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.activity = activity;
    }

    public void almacenarUsuario (String id, String nombre, String contrasena, String rol, BaseDatosInicio baseDatos){

        int aux = 0;
        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        ContentValues content = new ContentValues();
        if (nombre != null && contrasena != null) {
            String comparador1;
            Cursor cursor= sq.rawQuery("SELECT * FROM "+ Estructura.EstructuraInicio.TABLE_NAME, null);
            if (cursor.moveToFirst()){

                do {
                    Log.i("AG", cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_NOMBRE)));

                    comparador1 = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_NOMBRE));
                    if (comparador1.equals(nombre)){
                        aux = 1;
                    }
                }while (cursor.moveToNext());
            }

            if (aux==1){
                Toast.makeText(activity, "Base datos cargada", Toast.LENGTH_SHORT).show();

            }else {
                content.put(Estructura.EstructuraInicio.COLUMN_NAME_ID, id);
                content.put(Estructura.EstructuraInicio.COLUMN_NAME_NOMBRE, nombre);
                content.put(Estructura.EstructuraInicio.COLUMN_NAME_CONTRA, contrasena);
                content.put(Estructura.EstructuraInicio.COLUMN_NAME_ROL, rol);
                sq.insert(Estructura.EstructuraInicio.TABLE_NAME, null, content);
                Toast.makeText(activity, "Base de datos cargada con éxito", Toast.LENGTH_SHORT).show();

            }
        }
        sq.close();
    }

    public int confirmarUsuario (String nombre, String contrasena, String rol, BaseDatosInicio baseDatos, Activity activity){
        int aux = 0;
        int aux2 = 0;
        int aux3 = 0;

        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        ContentValues content = new ContentValues();
        if (nombre != null && contrasena != null && rol != null) {
            String comparador1;
            String comparador2;
            String comparador3;
            Cursor cursor= sq.rawQuery("SELECT * FROM "+ Estructura.EstructuraInicio.TABLE_NAME, null);
            if (cursor.moveToFirst()){

                do {
                    Log.i("Usuario", cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_NOMBRE)));

                    Log.i("Contrasena", cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_CONTRA)));

                    Log.i("Rol", cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_ROL)));

                    comparador1 = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_NOMBRE));

                    comparador2 = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_CONTRA));

                    comparador3 = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraInicio.COLUMN_NAME_ROL));


                    if (comparador1.equals(nombre)){
                        aux = 1;
                    }
                    if (comparador2.equals(contrasena)){
                        aux2 = 1;
                    }
                    if (comparador3.equals("estudiante")){
                        aux3 = 1;
                    }
                }while (cursor.moveToNext());
            }


            if (aux != 1){
                Toast.makeText(activity, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
            if (aux2 !=1){
                Toast.makeText(activity, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
            if (aux3 !=1){
                Toast.makeText(activity, "No tienes permiso de entrar", Toast.LENGTH_SHORT).show();
            }

            if (aux==1 && aux2==1 && aux3 ==1){
                aux = 2;

            }else {
                Toast.makeText(activity, "Vuelve a intentarlo, prueba con" +
                        "\n\n"+"Usuario: Julio\n"+"Contraseña : 123", Toast.LENGTH_LONG).show();
            }
        }
        sq.close();
        return aux;

    }
}
