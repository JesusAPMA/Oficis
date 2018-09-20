package com.proyectoprueba.jesus.proyectoprueba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SharedPreferences sharedPref;
    private HeaderAdapter headerAdapter;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    TextView txtnombre,txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Context context = this.getApplicationContext();

        List items = new ArrayList();



// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclar);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new HeaderAdapter(items,this);

        recycler.setAdapter(adapter);

        items.add(new Servicios(R.drawable.car1, "Open Car", 4.5,"Blvd. Fusión 144, Parque Industrial Dinatech, 83299 Hermosillo, Son."));
        items.add(new Servicios(R.drawable.car2, "M. García", 4.8,"Paseo Río Sonora sn, Villa de Seris, 83260 Hermosillo, Sonora"));
        items.add(new Servicios(R.drawable.car3, "Auto Zone", 5,"Boulevard García Morales Kilómetro 0.5, Olivares, 83220 Hermosillo, Sonora"));
        items.add(new Servicios(R.drawable.car4, "Taller Pérez", 4.6,"CRISTOBAL COLON 2523, PABLO A. DE LA GARZA , MONTERREY , NL , C.P.64580"));
        items.add(new Servicios(R.drawable.car5, "Ortega", 3.8,"BERNARDO REYES 3403, HIDALGO , MONTERREY , NL , C.P.64290"));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //OBTENER LOS DATOS DEL SHAREDPREFERENCE
        sharedPref = context.getSharedPreferences("preference_file_key",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String nombre=  sharedPref.getString("nombre_cliente","");
        String email = sharedPref.getString("correo_cliente","");
        //CAMBIAR LOS TEXTVIEW DEL NAVIGATION POR LOS DEL USUARIO
        View hView = navigationView.getHeaderView(0);
        txtnombre = (TextView) hView.findViewById(R.id.nombre_cliente);
        txtemail = (TextView) hView.findViewById(R.id.textView);
        txtnombre.setText(nombre);
        txtemail.setText(email);

    }
    public void maps(View v){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Context context = this.getApplicationContext();
            sharedPref = context.getSharedPreferences("preference_file_key",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.remove("telefono_cliente");
            editor.remove("contrasena_cliente");
            editor.commit();
            Intent intent = new Intent(principal.this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }else if (id == R.id.nav_historial) {
            Intent historial= new Intent (this,Historial.class);
            startActivity(historial);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
