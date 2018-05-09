package com.example.edwin.clinicacetu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class historialClinico extends AppCompatActivity {
    ListView lwHistoral;
    ArrayList listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_clinico);
        lwHistoral = (ListView)findViewById(R.id.lwHistorial);
        cargarListado();

    }
    private void cargarListado(){
        listado = listaPersonas();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listado);
        lwHistoral.setAdapter(adapter);

    }

    public ArrayList<String> listaPersonas(){
        ArrayList<String> datos = new ArrayList<>();
        ClinicaDB helper = new ClinicaDB(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        String historial="SELECT * FROM consultaMedica";
        Cursor c = db.rawQuery(historial, null);
        if (c.moveToFirst()){
            do {
                String linea  = c.getInt(0)+" - "+c.getString(4)+" - "+c.getString(5);
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;


    }
    public class MyAdapter extends BaseAdapter{
        private Context context;
        private  int layout;
        private List<String> names;

        public MyAdapter(Context context, int layout, List<String> names){


        }

        @Override
        public int getCount() {
            return this.names.size();
        }

        @Override
        public Object getItem(int position) {
            return this.names.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View v = convertView;
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            v= layoutInflater.inflate(R.layout.list_item, names);
            return ;
        }
    }
}
