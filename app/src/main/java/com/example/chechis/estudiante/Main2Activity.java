package com.example.chechis.estudiante;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private SharedPreferences pref;
    private Bundle parametro = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button bton = (Button) findViewById(R.id.btn_direccion);
        Button button = (Button) findViewById(R.id.btn_guardar_dir);
        final TextInputLayout editDireccion = (TextInputLayout) findViewById(R.id.edit_direccion);
        final TextInputLayout editPuerto = (TextInputLayout) findViewById(R.id.edit_puerto);



        pref = getSharedPreferences(PreferenceConstan.PREFERENCE_NAME, MODE_PRIVATE);
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editDireccion!= null && editPuerto!= null){
                    Intent intent = new Intent(Main2Activity.this, InicioActivity.class);
                    parametro.putString("url", editDireccion.getEditText().getText().toString()+":"+editPuerto.getEditText().getText().toString());
                    intent.putExtras(parametro);
                    startActivity(intent);

                }


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = editDireccion.getEditText().getText().toString()+":"+editPuerto.getEditText().getText().toString();
                SharedPreferences.Editor edit = pref.edit();
                edit.putString(PreferenceConstan.PREF_KEY_USERNAME, link);
                edit.apply();
                Toast.makeText(Main2Activity.this, "Dirección y puerto guardado", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
