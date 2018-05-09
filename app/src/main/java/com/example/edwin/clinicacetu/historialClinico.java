package com.example.edwin.clinicacetu;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class historialClinico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_clinico);
    }

    public ArrayList<String> listaPersonas(){
        ArrayList<String> datos = new ArrayList<>();
        ClinicaDB helper = new ClinicaDB(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        String historial="SELECT * FROM consultaMedica";
        Cursor c = db.rawQuery(historial, null);
        if (c.moveToFirst()){
            do {
                String linea  = c.getInt(0)+" - "+c.getString(1)+" - "+c.getString(2);
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;


    }
}
