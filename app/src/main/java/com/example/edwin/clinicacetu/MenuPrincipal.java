package com.example.edwin.clinicacetu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout nDrawable_layout;
private ActionBarDrawerToggle nToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        nDrawable_layout=(DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this, nDrawable_layout,R.string.abierto, R.string.cerrado);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        nDrawable_layout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       navigationView.setNavigationItemSelectedListener(this);
    }

    //metodo que maneja los click de la barra principal, para mostrar y ocultar el menu principal
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(nToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    // metodo que maneja los clicks o seleccion de una opcion del menu que se desplega
    public boolean onNavigationItemSelected( MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opc_nueva_cita){
            Toast.makeText(getApplicationContext(),"NUEVA CITA",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
