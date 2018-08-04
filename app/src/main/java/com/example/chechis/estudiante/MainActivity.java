package com.example.chechis.estudiante;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    TextView textView = null;
    CursorLoader cursorLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.texto);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        cursorLoader = new CursorLoader(this, Uri.parse("content://com.example.chechis.profesor.ProveedorContenidos/cte"), null, null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        try {
            data.moveToFirst();
            StringBuilder txt = new StringBuilder();
            while (!data.isAfterLast()){
                txt.append("\n"+data.getString(data.getColumnIndex("Id"))+" - " +data.getString(data.getColumnIndex("actividad"))
                        +" - " +data.getString(data.getColumnIndex("estudiante")) +" - " +data.getString(data.getColumnIndex("asignatura"))
                        +" - " +data.getString(data.getColumnIndex("nota")));
                data.moveToNext();
            }
            textView.setText(txt);
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "No se pudo recuperar datos", Toast.LENGTH_SHORT).show();

        }
    }

    public void listar (View view){
        Toast.makeText(MainActivity.this, "Desplegando", Toast.LENGTH_SHORT).show();
        getSupportLoaderManager().initLoader(1,null,this);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
    @Override
    public void onDestroy(){
        super.onDestroy();

    }
}
