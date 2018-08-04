package com.example.chechis.estudiante;

import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chechis.estudiante.adapter.Tarea;
import com.example.chechis.estudiante.adapter.TareaAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    TextView textView = null;
    CursorLoader cursorLoader;
    private ArrayList<Tarea> tareas = new ArrayList<>();
    RecyclerView recyclerView;
    TareaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2,
                GridLayoutManager.VERTICAL, false));
        adapter = new TareaAdapter(MainActivity.this, tareas);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        cursorLoader = new CursorLoader(this, Uri.parse("content://com.example.chechis.profesor.ProveedorContenidos/cte"), null, null, null, null);
        return cursorLoader;

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        try {
            tareas.clear();
            if (data.moveToFirst()){
                do {
                    String tarea= data.getString(data.getColumnIndex("actividad"));
                    String estudiante = data.getString(data.getColumnIndex("estudiante"));
                    String asignatura = data.getString(data.getColumnIndex("asignatura"));
                    String nota = data.getString(data.getColumnIndex("nota"));
                    tareas.add(new Tarea(tarea, estudiante, asignatura, nota));
                }while (data.moveToNext());
            }adapter.notifyDataSetChanged();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "No se pudo recuperar datos", Toast.LENGTH_SHORT).show();

        }
    }

    public void listar (View view){
        Snackbar.make(view, "Desplegando", Snackbar.LENGTH_SHORT).show();
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
