package com.example.chechis.estudiante.Inicio;

import android.provider.BaseColumns;

public class Estructura {

    public Estructura() {
    }

    public static abstract class EstructuraInicio implements BaseColumns {
        public static final String TABLE_NAME = "Inicio";
        public static final String COLUMN_NAME_ID ="Id";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_CONTRA = "contrasena";
        public static final String COLUMN_NAME_ROL = "rol";
    }
}
